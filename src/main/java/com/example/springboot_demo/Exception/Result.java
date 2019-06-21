package com.example.springboot_demo.Exception;

/**
 *
 * @author Huang Fuzhi
 * @date 2019/6/16
 */
public class Result {
    //错误码
    private Integer code;

    //错误内容
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
