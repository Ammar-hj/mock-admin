package com.platform.mocklearn.enums;

public enum ConfigMode {
    TEXT("TEXT","文本"),
    GROOVY("GROOVY","groovy语法"),
    GROOVY_TEMPLATE_SWITCH_CASE("GROOVY_TEMPLATE_SWITCH_CASE","groovy条件语法");

    private final String code;
    private final String msg;

    ConfigMode(String code, String msg) {
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
