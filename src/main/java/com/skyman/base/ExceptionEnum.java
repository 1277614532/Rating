package com.skyman.base;

public enum ExceptionEnum {
    UNKONW_ERROR(-1, "系统业务发生异常,请联系管理员"),
    SUCCESS(200, "成功"),
    NULL_POINTER(1, "发生空指针异常"),
    ILLEGAL_ARGUMENT(2, "请求参数类型不匹配"),
    SQL(3, "数据库访问异常"),
    ACCOUNT_ERROR(4, "用户名或密码错误"),
    BUSINESS(5, "业务逻辑异常"),
    HYSTRIX(40801, "服务响应超时，请检查被调用的服务是否正常运行!"),
    ARRAY_OUT_OF_INDEX(6, "业务逻辑数据越界异常，请联系管理员"),
    FAIL(500, "请求失败，请联系管理员"),
    PARAMETER_MISSING(600,"参数缺失"),

    //用户信息
    USERNAME_REPEAT(5000100,"用户名已存在"),
     PHONE_REPEAT(5000101,"手机号已存在"),
    EMAIL_REPEAT(5000102,"邮箱已存在"),

    //卫视及节目信息
    SNAME_REPEAT(5000103,"卫视名已存在"),
    PNAME_REPEAT(5000104,"节目名已存在");

    private Integer code;
    private String msg;

    private ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
