package com.example.roombooking.pojo.course;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.roombooking.arc.pojo.EntityPOJO;
import com.example.roombooking.common.validate.groups.CreateValidateGroup;
import com.example.roombooking.common.validate.groups.UpdateValidateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@TableName("course")
public class Course extends EntityPOJO {
    // 主键id
    @NotBlank(message = "主键不能为空", groups = {
            UpdateValidateGroup.class
    })
    @TableId
    private String courseId;

    // 教师id
    @NotBlank(message = "教师id不能为空", groups = {
            CreateValidateGroup.class
    })
    private String teacherId;

    // 课程名
    @NotBlank(message = "课程名不能为空", groups = {
            CreateValidateGroup.class
    })
    private String courseName;

    // 学生数
    @NotNull(message = "学生数不能为空", groups = {
            CreateValidateGroup.class
    })
    private Integer studentNum;
}
