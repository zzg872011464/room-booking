package com.example.roombooking.pojo.student;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.roombooking.arc.pojo.EntityPOJO;
import com.example.roombooking.common.validate.groups.CreateValidateGroup;
import com.example.roombooking.common.validate.groups.UpdateValidateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@TableName("student")
public class Student extends EntityPOJO {
    // 主键id
    @NotBlank(message = "主键不能为空", groups = {
            UpdateValidateGroup.class
    })
    @TableId
    private String studentId;

    // 学生姓名
    @NotBlank(message = "学生名不能为空", groups = {
            CreateValidateGroup.class
    })
    private String studentName;

    // 学号
    @NotBlank(message = "学号不能为空", groups = {
            CreateValidateGroup.class
    })
    private String studentNumber;

    // 学生邮箱
    @NotBlank(message = "学生邮箱不能为空", groups = {
            CreateValidateGroup.class
    })
    private String studentEmail;
}
