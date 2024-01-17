package com.example.roombooking.service.room.occupancy.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.roombooking.common.batch.result.BatchResult;
import com.example.roombooking.common.constant.ConstantFields;
import com.example.roombooking.common.util.mp.QueryWrapperUtils;
import com.example.roombooking.exception.todo.TodoException;
import com.example.roombooking.mapper.room.occupancy.RoomOccupancyMapper;
import com.example.roombooking.pojo.room.occupancy.RoomOccupancy;
import com.example.roombooking.service.room.occupancy.RoomOccupancyServiceI;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.baomidou.mybatisplus.core.toolkit.Wrappers.lambdaQuery;
import static com.baomidou.mybatisplus.core.toolkit.Wrappers.lambdaUpdate;

@Service
public class RoomOccupancyServiceImpl implements RoomOccupancyServiceI {

    @Autowired
    private RoomOccupancyMapper roomOccupancyMapper;

    @Override
    public boolean create(RoomOccupancy roomOccupancy) {
        return roomOccupancyMapper.insert(roomOccupancy) == 1;
    }

    @Override
    public BatchResult<RoomOccupancy> createBatch(List<RoomOccupancy> list,
                                                  BatchResult<RoomOccupancy> batchResult) {
        throw new TodoException();
    }

    @Override
    public boolean update(RoomOccupancy roomOccupancy) {
        return roomOccupancyMapper.updateById(roomOccupancy) == 1;
    }

    @Override
    public BatchResult<RoomOccupancy> updateBatch(List<RoomOccupancy> list,
                                                  BatchResult<RoomOccupancy> batchResult) {
        throw new TodoException();
    }

    @Override
    public boolean delete(RoomOccupancy roomOccupancy) {
        return roomOccupancyMapper.deleteById(roomOccupancy) == 1;
    }

    @Override
    public BatchResult<RoomOccupancy> deleteBatch(List<RoomOccupancy> list,
                                                  BatchResult<RoomOccupancy> batchResult) {
        throw new TodoException();
    }

    @Override
    public List<RoomOccupancy> readList(RoomOccupancy roomOccupancy) {
        return roomOccupancyMapper.selectList(QueryWrapperUtils.buildQueryWrapper(roomOccupancy));
    }

    @Override
    public RoomOccupancy readOne(RoomOccupancy roomOccupancy) {
        if (null == roomOccupancy.getOccupancyId()) {
            return new RoomOccupancy();
        }

        return roomOccupancyMapper.selectById(roomOccupancy.getOccupancyId());
    }

    @Override
    public Map<String, RoomOccupancy> read4MapByIds(List<String> ids) {
        throw new TodoException();
    }

    @Override
    public boolean deleteDbData(RoomOccupancy roomOccupancy) {
        throw new TodoException();
    }

    @Override
    public BatchResult<RoomOccupancy> deleteDbDataBatch(List<RoomOccupancy> list,
                                                        BatchResult<RoomOccupancy> batchResult) {
        throw new TodoException();
    }

    @Override
    public List<RoomOccupancy> readAvailableRoomsByCourseAndStudentCount(RoomOccupancy roomOccupancy, Integer studentNum) {
        if (null == roomOccupancy
                || null == roomOccupancy.getWeekDay()
                || null == roomOccupancy.getCourseStart()
                || null == studentNum) {
            return new ArrayList<>();
        }

        return roomOccupancyMapper.selectList(
                lambdaQuery(RoomOccupancy.class)
                        .gt(RoomOccupancy::getCapacity, studentNum)
                        .eq(RoomOccupancy::getWeekDay, roomOccupancy.getWeekDay())
                        .eq(RoomOccupancy::getOccupancyState, ConstantFields.OCCUPANCY_STATE_FREE)
                        .eq(RoomOccupancy::getCourseStart, roomOccupancy.getCourseStart())
                        .orderByAsc(RoomOccupancy::getCapacity));
    }

    @Override
    public Boolean updateByPrimaryKeyIfFree(RoomOccupancy roomOccupancy) {
        if (null == roomOccupancy
                || null == roomOccupancy.getOccupancyId()) {
            return false;
        }

        int update = roomOccupancyMapper.update(lambdaUpdate(RoomOccupancy.class)
                .eq(RoomOccupancy::getOccupancyId, roomOccupancy.getOccupancyId())
                .eq(RoomOccupancy::getOccupancyState, ConstantFields.OCCUPANCY_STATE_FREE)
                .set(RoomOccupancy::getOccupancyState, ConstantFields.OCCUPANCY_STATE_OCCUPANCY)
                .set(RoomOccupancy::getBookingId, roomOccupancy.getBookingId()));

        return ConstantFields.UPDATE_ONE_SUCCESS == update;
    }
}
