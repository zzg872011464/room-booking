package com.example.roombooking.common.validate;

import java.util.Set;

public class ValidateMessage {

    // 数据验证错误的参数名
    private String name;
    // 参数值
    private Object value;
    // 数据验证错误信息
    private Set<String> messages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Set<String> getMessages() {
        return messages;
    }

    public void setMessages(Set<String> messages) {
        this.messages = messages;
    }
}
