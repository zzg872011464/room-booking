package com.example.roombooking.mapper.course;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.roombooking.pojo.course.Course;
import com.example.roombooking.pojo.room.Room;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
}
