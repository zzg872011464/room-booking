package com.example.roombooking.pojo.student.course;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;


import com.example.roombooking.arc.pojo.EntityPOJO;
import com.example.roombooking.common.validate.groups.CreateValidateGroup;
import com.example.roombooking.common.validate.groups.UpdateValidateGroup;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@TableName("student_course")
public class StudentCourse extends EntityPOJO {

    // 主键id
    @NotBlank(message = "主键不能为空", groups = {
            UpdateValidateGroup.class
    })
    @TableId
    private String correlationId;

    // 学生id
    @NotBlank(message = "学生id不能为空", groups = {
            CreateValidateGroup.class
    })
    private String studentId;

    // 课程id
    @NotBlank(message = "课程id不能为空", groups = {
            CreateValidateGroup.class
    })
    private String courseId;
}
