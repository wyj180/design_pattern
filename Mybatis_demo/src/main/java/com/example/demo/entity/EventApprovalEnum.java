package com.example.demo.entity;

import java.util.Arrays;

public enum EventApprovalEnum {
    REJECT(0),
    APPROVAL(1),
    DISMISS(2),
    SUBMIT(3),
    WAITING(4),
    RESUBMIT(5),
    CLOSED(6),
    /**
     * 什么也不做，只增加一条记录
     */
    NONE(7);

    private int code;

    EventApprovalEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static EventApprovalEnum to(Integer code) {
        if (code == null) {
            return null;
        }
        return Arrays.stream(values()).filter(event -> event.getCode() == code).findFirst().get();
    }
}
