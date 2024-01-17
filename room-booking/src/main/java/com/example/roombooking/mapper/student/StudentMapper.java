package com.example.roombooking.mapper.student;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.roombooking.pojo.student.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
