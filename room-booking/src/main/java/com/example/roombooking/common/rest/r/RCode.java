package com.example.roombooking.common.rest.r;

public enum RCode {
    SUCCESS(200, "请求成功"),
    ERROR(500, "请求错误"),
    FORBIDDEN(403, "权限阻止"),
    UNAUTH(401, "未认证"),
    DATA_INVALID(10001, "无效数据"),
    METHOD_NOT_ALLOWED(10002, "方法无权访问"),
    GET_REMOTE_TOKEN_KEY_ERROR(10003, "无法获取token_key"),
    SENTINEL(10004, "被流控"),
    GATEWAY(10005, "网关错误"),
    INVALID_TOKEN(10006, "无效token"),
    NO_TOKEN(10007, "缺少token"),
    UPDATE_TOKEN_ERROR(10008, "更新token错误"),
    NO_CLIENT_TYPE(10009, "缺少客户端类型"),
    NO_TIME(10010, "缺少time"),
    DECRYPT_TIME_ERROR(10011, "time解密失败"),
    REQUEST_INVALID(10012, "请求已过期"),
    NO_USER_ID(10013, "缺少userId"),
    DECRYPT_USER_ID_ERROR(10014, "userId解密失败"),
    CLIENT_TYPE_NOT_EXIST(10015, "客户端类型不存在"),
    DDOS_NOT_ALLOWED(10016, "不允许频繁请求"),
    API_ACCESS_LIMIT(10017, "访问限流"),
    TODO(10018, "该功能尚未完成");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    RCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
