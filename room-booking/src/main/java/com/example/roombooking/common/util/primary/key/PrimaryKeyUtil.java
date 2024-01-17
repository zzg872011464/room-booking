package com.example.roombooking.common.util.primary.key;

import com.github.f4b6a3.ulid.UlidCreator;

import java.util.UUID;

public class PrimaryKeyUtil {

    /**
     * 生成唯一标识字符串
     * @return 唯一标识字符串
     */
    public static String getPrimaryKey() {
        return getULIdPrimaryKey();
    }

    /**
     * 通过uuid生成唯一标识字符串
     * @return 生成唯一标识字符串
     */
    private static String getUUIdPrimaryKey() {
        return UUID.randomUUID().toString();
    }

    /**
     * 通过ulid生成唯一标识字符串
     * @return 生成唯一标识字符串
     */
    private static String getULIdPrimaryKey() {
        return UlidCreator.getMonotonicUlid().toString();
    }

    private PrimaryKeyUtil() {}
}
