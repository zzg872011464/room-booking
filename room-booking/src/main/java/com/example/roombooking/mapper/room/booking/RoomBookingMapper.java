package com.example.roombooking.mapper.room.booking;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.roombooking.pojo.room.Room;
import com.example.roombooking.pojo.room.booking.RoomBooking;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomBookingMapper extends BaseMapper<RoomBooking> {
}
