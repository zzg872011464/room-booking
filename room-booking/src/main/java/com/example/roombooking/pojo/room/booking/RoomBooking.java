package com.example.roombooking.pojo.room.booking;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.roombooking.arc.pojo.EntityPOJO;
import com.example.roombooking.common.util.date.DateUtil;
import com.example.roombooking.common.validate.groups.CreateValidateGroup;
import com.example.roombooking.common.validate.groups.UpdateValidateGroup;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("room_booking")
public class RoomBooking extends EntityPOJO {
    // 主键id
    @NotBlank(message = "主键不能为空", groups = {
            UpdateValidateGroup.class
    })
    @TableId
    private String bookingId;

    // 房间id
    @NotBlank(message = "房间id不能为空", groups = {
            CreateValidateGroup.class
    })
    private String roomId;

    // 教师id
    @NotBlank(message = "教师id不能为空", groups = {
            CreateValidateGroup.class
    })
    private String teacherId;

    // 课程id
    @NotBlank(message = "课程id不能为空", groups = {
            CreateValidateGroup.class
    })
    private String courseId;

    // 周几 :1,2,3,4,5,6,7
    @NotNull(message = "周几上课不能为空", groups = {
            CreateValidateGroup.class
    })
    @DecimalMin(value = "1", groups = {
            CreateValidateGroup.class
    })
    @DecimalMax(value = "7", groups = {
            CreateValidateGroup.class
    })
    private Integer weekDay;

    // 第几节课 :1,2,3,4,5,6,7,8
    @NotNull(message = "第几节上课不能为空", groups = {
            CreateValidateGroup.class
    })
    @DecimalMin(value = "1", groups = {
            CreateValidateGroup.class
    })
    @DecimalMax(value = "8", groups = {
            CreateValidateGroup.class
    })
    private Integer courseStart;

    // 申请状态 1:待定 2:已批准 3:已拒绝 4:已取消
    private Integer bookingState;

    // 有效截止时间
    @JsonFormat(pattern = DateUtil.DATE_FORMAT_YYYY_MM_DD)
    @DateTimeFormat(pattern = DateUtil.DATE_FORMAT_YYYY_MM_DD)
    @NotNull(message = "截止时间不能为空", groups = {
            CreateValidateGroup.class
    })
    private Date deadline;
}
