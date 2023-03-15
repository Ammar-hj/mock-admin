package com.platform.mocklearn.enums;

public enum SpaceEnum {
    PUBLIC("PUBLIC","公开"),
    PRIVATE("PRIVATE","私有");

    private final String code;
    private final String msg;

    SpaceEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
