package com.example.roombooking.service.room.booking.impl;

import cn.hutool.core.bean.BeanUtil;
import com.example.roombooking.common.batch.result.BatchResult;
import com.example.roombooking.common.field.room.booking.type.RoomBookingTypeFields;
import com.example.roombooking.common.history.util.room.booking.RoomBookingHistoryUtil;
import com.example.roombooking.common.rest.r.R;
import com.example.roombooking.common.util.mp.QueryWrapperUtils;
import com.example.roombooking.common.util.primary.key.PrimaryKeyUtil;
import com.example.roombooking.exception.todo.TodoException;
import com.example.roombooking.mapper.room.booking.RoomBookingMapper;
import com.example.roombooking.pojo.course.Course;
import com.example.roombooking.pojo.room.booking.RoomBooking;
import com.example.roombooking.pojo.room.booking.dto.RoomBookingDTO;
import com.example.roombooking.pojo.room.booking.history.RoomBookingHistory;
import com.example.roombooking.pojo.room.occupancy.RoomOccupancy;
import com.example.roombooking.pojo.teacher.Teacher;
import com.example.roombooking.service.course.CourseServiceI;
import com.example.roombooking.service.room.booking.RoomBookingServiceI;
import com.example.roombooking.service.room.booking.history.RoomBookingHistoryServiceI;
import com.example.roombooking.service.room.occupancy.RoomOccupancyServiceI;
import com.example.roombooking.service.teacher.TeacherServiceI;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class RoomBookingServiceImpl implements RoomBookingServiceI {

    @Autowired
    private RoomBookingMapper roomBookingMapper;
    @Autowired
    private CourseServiceI courseService;
    @Autowired
    private RoomOccupancyServiceI roomOccupancyService;
    @Autowired
    private TeacherServiceI teacherService;
    @Autowired
    private RoomBookingHistoryServiceI roomBookingHistoryService;

    @Override
    public boolean create(RoomBooking roomBooking) {
        if (Strings.isNullOrEmpty(roomBooking.getBookingId())) {
            roomBooking.setBookingId(PrimaryKeyUtil.getPrimaryKey());
        }

        return roomBookingMapper.insert(roomBooking) == 1;
    }

    @Override
    public BatchResult<RoomBooking> createBatch(List<RoomBooking> list,
                                                BatchResult<RoomBooking> batchResult) {
        throw new TodoException();
    }

    @Override
    public boolean update(RoomBooking roomBooking) {
        return roomBookingMapper.updateById(roomBooking) == 1;
    }

    @Override
    public BatchResult<RoomBooking> updateBatch(List<RoomBooking> list,
                                                BatchResult<RoomBooking> batchResult) {
        throw new TodoException();
    }

    @Override
    public boolean delete(RoomBooking roomBooking) {
        return roomBookingMapper.deleteById(roomBooking) == 1;
    }

    @Override
    public BatchResult<RoomBooking> deleteBatch(List<RoomBooking> list,
                                                BatchResult<RoomBooking> batchResult) {
        throw new TodoException();
    }

    @Override
    public List<RoomBooking> readList(RoomBooking roomBooking) {
        return roomBookingMapper.selectList(QueryWrapperUtils.buildQueryWrapper(roomBooking));
    }

    @Override
    public RoomBooking readOne(RoomBooking roomBooking) {
        if (null == roomBooking.getTeacherId()) {
            return new RoomBooking();
        }

        return roomBookingMapper.selectById(roomBooking.getTeacherId());
    }

    @Override
    public Map<String, RoomBooking> read4MapByIds(List<String> ids) {
        throw new TodoException();
    }

    @Override
    public boolean deleteDbData(RoomBooking roomBooking) {
        throw new TodoException();
    }

    @Override
    public BatchResult<RoomBooking> deleteDbDataBatch(List<RoomBooking> list,
                                                      BatchResult<RoomBooking> batchResult) {
        throw new TodoException();
    }

    // 教师预定房间
    // 1.数据校验
    // 2.根据房间剩余以及座位分配房间
    // 3.如果申请成功正常房间扣减
    // 4.申请失败返回对应错误信息
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public R<Object> teacherBooking(RoomBookingDTO roomBookingDTO) {
        // 2.1 查询出学生数
        Course courseParam = new Course();
        courseParam.setCourseId(roomBookingDTO.getCourseId());

        Course course = courseService.readOne(courseParam);

        if (null == course) {
            return R.dataInvalid("课程不存在");
        }

        Teacher teacherParam = new Teacher();
        teacherParam.setTeacherId(roomBookingDTO.getTeacherId());

        Teacher teacher = teacherService.readOne(teacherParam);

        if (null == teacher) {
            return R.dataInvalid("教师不存在");
        }

        Integer studentNum = course.getStudentNum();

        // 2.2 筛选出房间容量大于学生数的房间
        RoomOccupancy roomOccupancyParam = new RoomOccupancy();
        roomOccupancyParam.setWeekDay(roomBookingDTO.getWeekDay());
        roomOccupancyParam.setCourseStart(roomBookingDTO.getCourseStart());

        List<RoomOccupancy> roomOccupancies = roomOccupancyService.readAvailableRoomsByCourseAndStudentCount(roomOccupancyParam, studentNum);
        // 查看是否有空余
        if (null == roomOccupancies
                || roomOccupancies.isEmpty()) {
            return R.error("无空余座位");
        }

        // 3.如果申请成功正常房间扣减
        RoomOccupancy roomOccupancy = roomOccupancies.get(0);
        String roomBookingPrimaryKey = PrimaryKeyUtil.getPrimaryKey();

        // 3.1 更改房间占用信息
        roomOccupancy.setBookingId(roomBookingPrimaryKey);

        boolean updateSuccess = roomOccupancyService.updateByPrimaryKeyIfFree(roomOccupancy);

        if (!updateSuccess) {
            return R.error("更新房间占用失败");
        }

        // 3.2 创建房间申请表
        RoomBooking roomBooking = new RoomBooking();
        BeanUtil.copyProperties(roomBookingDTO, roomBooking);
        roomBooking.setBookingState(RoomBookingTypeFields.YI_PI_ZHUN.getState());
        roomBooking.setBookingId(roomBookingPrimaryKey);
        roomBooking.setRoomId(roomOccupancy.getRoomId());

        boolean createSuccess = create(roomBooking);

        if (!createSuccess) {
            return R.error("预定记录插入失败");
        }

        // 3.3 创建房间申请表历史
        RoomBookingHistory roomBookingHistory = new RoomBookingHistory();
        BeanUtil.copyProperties(roomBooking, roomBookingHistory);
        roomBookingHistory.setBookingLog(String.format(RoomBookingHistoryUtil.YI_PI_ZHUN, teacher.getTeacherName()));
        roomBookingHistory.setProcessTime(new Timestamp(System.currentTimeMillis()));

        boolean roomBookingHistoryCreateSuccess = roomBookingHistoryService.create(roomBookingHistory);

        if (!roomBookingHistoryCreateSuccess) {
            return R.error("申请历史历史创建失败");
        }
        // todo 异步发通知

        return R.ok(roomBookingDTO);
    }
}
