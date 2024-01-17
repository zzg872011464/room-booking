package com.example.roombooking.pojo.room.booking.history;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.roombooking.arc.pojo.EntityPOJO;
import com.example.roombooking.common.util.date.DateUtil;
import com.example.roombooking.common.validate.groups.CreateValidateGroup;
import com.example.roombooking.common.validate.groups.UpdateValidateGroup;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.sql.Timestamp;

@Data
@TableName("room_booking_history")
public class RoomBookingHistory extends EntityPOJO {
    // 主键id
    @NotBlank(message = "主键不能为空", groups = {
            UpdateValidateGroup.class
    })
    @TableId
    private String historyId;

    // 预定记录id
    @NotBlank(message = "预定id不能为空", groups = {
            CreateValidateGroup.class
    })
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
    private Integer weekDay;

    // 第几节课 :1,2,3,4,5,6,7,8
    @NotNull(message = "第几节上课不能为空", groups = {
            CreateValidateGroup.class
    })
    private Integer courseStart;

    // 预定描述
    @NotBlank(message = "预定描述不能为空", groups = {
            CreateValidateGroup.class
    })
    private String bookingLog;

    // 有效截止时间
    @JsonFormat(pattern = DateUtil.DATE_FORMAT_YYYY_MM_DD)
    @DateTimeFormat(pattern = DateUtil.DATE_FORMAT_YYYY_MM_DD)
    @NotNull(message = "截止时间不能为空", groups = {
            CreateValidateGroup.class
    })
    private Date deadline;

    // 处理时间
    @JsonFormat(pattern = DateUtil.DATE_FORMAT_DB_DATE_TIME)
    @DateTimeFormat(pattern = DateUtil.DATE_FORMAT_DB_DATE_TIME)
    @NotNull(message = "处理时间不能为空", groups = {
            CreateValidateGroup.class
    })
    private Timestamp processTime;
}
