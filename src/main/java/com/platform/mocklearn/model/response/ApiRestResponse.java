package com.platform.mocklearn.model.response;

import com.platform.mocklearn.enums.RespCodeEnum;

public class ApiRestResponse<T> {

    private String code;
    private String message;
    private T data;

    public ApiRestResponse() {
        this(RespCodeEnum.SUCCESS.getCode(), RespCodeEnum.SUCCESS.getMsg());
    }

    public ApiRestResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiRestResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiRestResponse<T> success() {
        return new ApiRestResponse<>();
    }

    public static <T> ApiRestResponse<T> success(T data) {
        ApiRestResponse<T> resp = new ApiRestResponse<>();
        resp.setData(data);
        return resp;
    }

    public static <T> ApiRestResponse<T> error(RespCodeEnum ex) {
        return new ApiRestResponse<>(ex.getCode(), ex.getMsg());
    }

    public static <T> ApiRestResponse<T> error(String code, String msg) {
        return new ApiRestResponse<>(code, msg);
    }

    @Override
    public String toString() {
        return "ApiRestResponse{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
