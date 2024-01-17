package com.example.roombooking.service.room.occupancy;

import com.example.roombooking.arc.service.BaseService;
import com.example.roombooking.pojo.room.occupancy.RoomOccupancy;

import java.util.List;

public interface RoomOccupancyServiceI extends BaseService<RoomOccupancy> {

    /**
     * 通过上课时间和学生数查询可用房间
     *
     * @param roomOccupancy 上课时间和周几
     * @param studentNum    学生数
     * @return 全部可用的房间
     */
    List<RoomOccupancy> readAvailableRoomsByCourseAndStudentCount(RoomOccupancy roomOccupancy, Integer studentNum);

    /**
     * 通过主键更改房间占用信息
     * @param roomOccupancy 主键id 预定id
     * @return 更新结果
     */
    Boolean updateByPrimaryKeyIfFree(RoomOccupancy roomOccupancy);
}
