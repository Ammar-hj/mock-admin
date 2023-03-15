package com.platform.mocklearn.exception;

import com.platform.mocklearn.enums.RespCodeEnum;

public class MockException extends RuntimeException {

    private final String code;
    private final String message;

    public MockException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public MockException(RespCodeEnum respCodeEnum) {
        this(respCodeEnum.getCode(), respCodeEnum.getMsg());
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
