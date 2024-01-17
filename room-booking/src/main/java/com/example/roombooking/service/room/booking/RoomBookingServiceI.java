package com.example.roombooking.service.room.booking;

import com.example.roombooking.arc.service.BaseService;
import com.example.roombooking.common.rest.r.R;
import com.example.roombooking.pojo.room.booking.RoomBooking;
import com.example.roombooking.pojo.room.booking.dto.RoomBookingDTO;
import com.example.roombooking.pojo.teacher.Teacher;

public interface RoomBookingServiceI extends BaseService<RoomBooking> {

    /**
     * 教师预定座位
     * @param roomBookingDTO
     * @return
     */
    R<Object> teacherBooking(RoomBookingDTO roomBookingDTO);
}
