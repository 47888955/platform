package com.yaoyong.demo.base.exception;


public class BaseException extends RuntimeException {

    private Integer code;//错误码
    private String msg;//错误信息
    private String describe;//异常描述

    public BaseException(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getStatus();
        this.msg = exceptionEnum.getMessage();
    }

    public BaseException(ExceptionEnum exceptionEnum, String describe) {
        this.code = exceptionEnum.getStatus();
        this.msg = exceptionEnum.getMessage();
        this.describe = describe;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

}
