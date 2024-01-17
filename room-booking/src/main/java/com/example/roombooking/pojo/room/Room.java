package com.example.roombooking.pojo.room;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.roombooking.arc.pojo.EntityPOJO;
import com.example.roombooking.common.validate.groups.CreateValidateGroup;
import com.example.roombooking.common.validate.groups.UpdateValidateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@TableName("room")
public class Room extends EntityPOJO {
    // 主键id
    @NotBlank(message = "主键不能为空", groups = {
            UpdateValidateGroup.class
    })
    @TableId
    private String roomId;

    // 房间号
    @NotBlank(message = "学生名不能为空", groups = {
            CreateValidateGroup.class
    })
    private String roomNumber;

    // 房间容量
    @NotNull(message = "房间容量不能为空", groups = {
            CreateValidateGroup.class
    })
    private Integer capacity;

    // 房间状态 1:不可用 2:可用
    @NotNull(message = "房间状态不能为空", groups = {
            CreateValidateGroup.class
    })
    private Integer roomState;
}
