package com.example.roombooking.common.field.room.booking.type;

public enum RoomBookingTypeFields {
    YI_CHAUNG_JIAN(1, "已创建"),
    YI_PI_ZHUN(2, "已批准"),
    YI_JV_JUE(3, "已拒绝"),
    YI_QV_XIAO(4, "已取消");
    private int state;

    private String str;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    RoomBookingTypeFields(int state, String str) {
        this.state = state;
        this.str = str;
    }
}
