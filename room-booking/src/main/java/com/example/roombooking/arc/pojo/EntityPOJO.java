package com.example.roombooking.arc.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.example.roombooking.common.util.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

@Data
public class EntityPOJO {

    // 删除标识符 0:未删除 1:已删除
    @TableField
    private Integer deleteFlag;

    // 创建时间
    @JsonFormat(pattern = DateUtil.DATE_FORMAT_DB_DATE_TIME)
    @DateTimeFormat(pattern = DateUtil.DATE_FORMAT_DB_DATE_TIME)
    private Timestamp createTime;

    // 更新时间
    @JsonFormat(pattern = DateUtil.DATE_FORMAT_DB_DATE_TIME)
    @DateTimeFormat(pattern = DateUtil.DATE_FORMAT_DB_DATE_TIME)
    private Timestamp updateTime;
}
