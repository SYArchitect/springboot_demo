package com.example.springboot_demo.Exception;

/**
 * Created by Huang Fuzhi on 2019/6/16.
 */
public enum EnumResult {
    /**
     * 用户不存在
     */
    USER_NOT_FOUND(40401,"用户不存在!"),
    /**
     * 用户已存在
     */
    USER_ALRAEDY_EXIST(40001,"用户已存在"),
    ;


    private Integer code;
    private String msg;

    EnumResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
