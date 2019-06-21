package com.example.springboot_demo.Exception;

/**
 *
 * @author Huang Fuzhi
 * @date 2019/6/16
 */
public class GlobalException extends RuntimeException {
    private Integer code;

    public GlobalException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
