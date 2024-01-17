package com.example.roombooking.common.data.result;

import java.util.List;

public class DataResult<T> {
    // 返回码
    private int code;
    // 返回消息
    private String msg;
    // 返回数据
    private List<T> datas;

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

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
