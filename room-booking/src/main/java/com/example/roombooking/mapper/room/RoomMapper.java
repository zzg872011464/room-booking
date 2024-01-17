package com.example.roombooking.mapper.room;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.roombooking.pojo.room.Room;
import com.example.roombooking.pojo.student.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomMapper extends BaseMapper<Room> {
}
