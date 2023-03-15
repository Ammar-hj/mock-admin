package com.platform.mocklearn.enums;

public enum RespCodeEnum {

    // SUCCESS
    SUCCESS("0", "成功"),
    SUCCESS_CREATE_SPACE("0", "空间创建成功"),
    SUCCESS_UPDATE_SPACE("0", "空间更新成功"),
    SUCCESS_DELETE_SPACE("0", "空间删除成功"),
    SUCCESS_CREATE_INTERFACE("0", "HTTP接口创建成功"),
    SUCCESS_UPDATE_INTERFACE("0", "HTTP接口更新成功"),
    SUCCESS_DELETE_INTERFACE("0", "HTTP接口删除成功"),
    SUCCESS_START_INTERFACE("0", "HTTP接口开启成功"),
    SUCCESS_SHUTDOWN_INTERFACE("0", "HTTP接口关闭成功"),

    // EXCEPTION
    ARGUMENTS_ERROR("101", "参数异常"),
    PERMISSION_DENIED("102", "无权限"),
    INTERFACE_NOT_OPEN("103", "接口未开启"),
    GROOVY_RUNTIME_EXCEPTION("111", "Groovy脚本运行时错误"),
    GROOVY_COMPILE_EXCEPTION("112", "Groovy脚本编译时错误"),
    FAILED_TO_CONVERT_GROOVY_EXEC_RESULT_TO_STRING("113", "无法将Groovy脚本执行结果转换为字符串"),
    SPACE_EXISTS("201", "名称已存在"),
    INTERFACE_EXISTS("202", "接口已存在"),
    INTERFACE_BRANCH_EXISTS("204", "分支名已存在"),
    INTERFACE_HEADER_EXISTS("205", "HTTP头键名已存在"),
    NOT_FOUND_SPACE("211", "未找到相应空间"),
    NOT_FOUND_PARENT_SPACE("212", "未找到相应父空间"),
    NOT_FOUND_INTERFACE("213", "未找到相应HTTP接口"),
    NOT_FOUND_INTERFACE_BRANCH("214", "未找到相应HTTP接口分支"),
    CAN_NOT_CREATE_SPACE_UNDER_THIS_LEVEL("301", "无法在该层级下创建空间"),
    CAN_NOT_CREATE_INTERFACE_UNDER_THIS_LEVEL("32", "无法在该层级下创建接口"),
    EXCEEDING_THRESHOLD_SYNC_DELAY("401", "同步延时超出阈值"),
    EXCEEDING_THRESHOLD_ASYNC_DELAY("401", "异步延时超出阈值"),
    INSERT_ERROR("501", "数据添加失败"),
    UPDATE_ERROR("502", "数据更新失败"),
    DELETE_ERROR("503", "删除更新失败"),
    DATA_NUM_ERROR("504", "查询数据数量异常"),
    NOT_FOUND_HTTP_INTERFACE_DATA("505", "未查询到数据"),
    UNKNOWN_ERROR("999", "未知错误");

    private final String code;
    private final String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    RespCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
