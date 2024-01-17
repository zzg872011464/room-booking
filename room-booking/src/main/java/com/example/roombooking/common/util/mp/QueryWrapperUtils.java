package com.example.roombooking.common.util.mp;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.base.CaseFormat;


import java.lang.reflect.Field;

/**
 * mybatis-plus的QueryWrapper封装工具类
 */
public class QueryWrapperUtils {
    public static <T> QueryWrapper<T> buildQueryWrapper(T params) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();

        if (params == null) {
            return queryWrapper;
        }

        Field[] fields = params.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(params);

                if (value != null) {
                    String columnName = getColumnName(field);

                    // 如果是String类型如果是空则跳过
                    if (value instanceof String && StringUtils.isBlank((String) value)) {
                        continue;
                    }

                    // 满足上述全部判断条件后拼接查询条件
                    queryWrapper.eq(columnName, value);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error accessing field value", e);
            }
        }

        return queryWrapper;
    }

    private static String getColumnName(Field field) {
        // 如果有TableField那么数据库的名字在value字段中
        if (field.isAnnotationPresent(TableField.class)) {
            TableField tableField = field.getAnnotation(TableField.class);
            if (StringUtils.isNotBlank(tableField.value())) {
                return tableField.value();
            }
        }

        // 不然的话驼峰转下划线
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field.getName());
    }
}
