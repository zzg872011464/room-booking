package com.example.roombooking.pojo.room.occupancy;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.roombooking.arc.pojo.EntityPOJO;
import com.example.roombooking.common.validate.groups.CreateValidateGroup;
import com.example.roombooking.common.validate.groups.UpdateValidateGroup;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@TableName("room_occupancy")
public class RoomOccupancy extends EntityPOJO {
    // 主键id
    @NotBlank(message = "主键不能为空", groups = {
            UpdateValidateGroup.class
    })
    @TableId
    private String occupancyId;

    // 房间id
    @NotBlank(message = "房间id不能为空", groups = {
            CreateValidateGroup.class
    })
    private String roomId;

    // 周几 :1,2,3,4,5,6,7
    @NotNull(message = "周几不能为空", groups = {
            CreateValidateGroup.class
    })
    @DecimalMin(value = "1", message = "周几的值最小为1", groups = {
            CreateValidateGroup.class
    })
    @DecimalMax(value = "7", message = "周几的值最大为7", groups = {
            CreateValidateGroup.class
    })
    private Integer weekDay;

    // 第几节课 :1,2,3,4,5,6,7,8
    @NotNull(message = "第几节课不能为空", groups = {
            CreateValidateGroup.class
    })
    @DecimalMin(value = "1", message = "第几节课的值最小为1", groups = {
            CreateValidateGroup.class
    })
    @DecimalMax(value = "8", message = "第几节课的值最大为8", groups = {
            CreateValidateGroup.class
    })
    private Integer courseStart;

    // 房间容量
    @NotNull(message = "房间容量不能为空", groups = {
            CreateValidateGroup.class
    })
    private Integer capacity;

    // 占用状态 1:空闲 2:占用
    private Integer occupancyState;

    // 预定id
    private String bookingId;
}
