package com.example.roombooking.common.validate;

import java.util.Map;

public class ValidateResult<T> {

    //验证的bean
    private T beValidateData;

    // 是否发生错误
    private boolean isInvalid;

    // 数据验证不合法信息
    private Map<String, ValidateMessage> illegalDataMessagesMap;

    public T getBeValidateData() {
        return beValidateData;
    }

    public void setBeValidateData(T beValidateData) {
        this.beValidateData = beValidateData;
    }

    public boolean isInvalid() {
        return isInvalid;
    }

    public void setInvalid(boolean invalid) {
        this.isInvalid = invalid;
    }

    public Map<String, ValidateMessage> getIllegalDataMessagesMap() {
        return illegalDataMessagesMap;
    }

    public void setIllegalDataMessagesMap(Map<String, ValidateMessage> illegalDataMessagesMap) {
        this.illegalDataMessagesMap = illegalDataMessagesMap;
    }
}
