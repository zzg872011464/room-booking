package com.example.roombooking.common.rest.r;

public class R<T> {
    private int code;
    private String msg;
    private T data;

    public R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public R(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R(RCode code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public R() {
    }

    public static <T> R<T> sentinel() {
        return new R<>(RCode.SENTINEL);
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /*********************************** 以下为业务返回方法封装 ***********************************/

    public static <T> R<T> ok() {
        return new R<>(RCode.SUCCESS);
    }

    public static <T> R<T> ok(String message) {
        R<T> r = new R<>(RCode.SUCCESS);

        r.setMsg(message);

        return r;
    }

    public static <T> R<T> ok(T data, String msg) {
        R<T> r = new R<>(RCode.SUCCESS);

        r.setMsg(msg);
        r.setData(data);

        return r;
    }

    public static <T> R<T> ok(T data) {
        R<T> r = new R<>(RCode.SUCCESS);

        r.setData(data);

        return r;
    }

    public static <T> R<T> error(int code, String message) {
        return new R<>(code, message);
    }

    public static <T> R<T> error(T data, String message) {
        R<T> r = new R<>(RCode.ERROR);

        r.setMsg(message);
        r.setData(data);

        return r;
    }

    public static <T> R<T> error() {
        return new R<>(RCode.ERROR);
    }

    public static <T> R<T> error(String msg) {
        R<T> r = new R<>(RCode.ERROR);

        r.setMsg(msg);

        return r;
    }

    public static <T> R<T> error(T data) {
        R<T> r = new R<>(RCode.ERROR);

        r.setData(data);

        return r;
    }

    public static <T> R<T> error(int code, String msg, T data) {
        return new R<>(code, msg, data);
    }

    public static <T> R<T> dataInvalid(T data) {
        R<T> r = new R<>(RCode.DATA_INVALID);

        r.setData(data);

        return r;
    }

    public static <T> R<T> unauth() {
        return new R<>(RCode.UNAUTH);
    }

    public static <T> R<T> forbidden() {
        return new R<>(RCode.FORBIDDEN);
    }

    public static <T> R<T> todo() {
        return new R<>(RCode.TODO);
    }
}
