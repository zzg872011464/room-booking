package com.example.roombooking.pojo.teacher;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.roombooking.arc.pojo.EntityPOJO;
import com.example.roombooking.common.validate.groups.CreateValidateGroup;
import com.example.roombooking.common.validate.groups.UpdateValidateGroup;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@TableName("teacher")
public class Teacher extends EntityPOJO {
    // 主键id
    @NotBlank(message = "主键不能为空", groups = {
            UpdateValidateGroup.class
    })
    @TableId
    private String teacherId;

    // 教师名
    @NotBlank(message = "教师名不能为空", groups = {
            CreateValidateGroup.class
    })
    private String teacherName;

    // 教工号
    @NotBlank(message = "教工号不能为空", groups = {
            CreateValidateGroup.class
    })
    private String teacherNumber;

    // 密码
    @NotBlank(message = "密码不能为空", groups = {
            CreateValidateGroup.class
    })
    private String teacherPassword;

    // 教师邮箱
    @NotBlank(message = "教师邮箱不能为空", groups = {
            CreateValidateGroup.class
    })
    private String teacherEmail;
}
