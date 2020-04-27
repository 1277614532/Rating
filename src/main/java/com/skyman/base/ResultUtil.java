package com.skyman.base;



public class ResultUtil {

    public ResultUtil() {
    }

    public static ResultEntity success() {
        return success((Object)null);
    }

    public static ResultEntity success(Object object) {
        return success("操作成功",object);
    }

    public static ResultEntity success(String msg, Object object) {
        ResultEntity result = new ResultEntity();
        result.setCount(1);
        result.setCode(0);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    public static ResultEntity error(Integer code, String msg) {
        ResultEntity result = new ResultEntity();
        result.setCount(1);
        result.setCode(code);
        result.setMsg(msg);
        result.setData((String)null);
        return result;
    }

    public static ResultEntity error(ExceptionEnum exceptionEnum) {
        ResultEntity result = new ResultEntity();
        result.setCount(1);
        result.setCode(exceptionEnum.getCode());
        result.setMsg(exceptionEnum.getMsg());
        result.setData((String)null);
        return result;
    }

    public static ResultEntity error(String msg) {
        ResultEntity result = new ResultEntity();
        result.setCount(1);
        result.setCode(ExceptionEnum.BUSINESS.getCode());
        result.setMsg(msg);
        result.setData((String)null);
        return result;
    }
}
