package com.example.springboot_demo.Exception;

/**
 * Created by Huang Fuzhi on 2019/6/16.
 */
public class UserNotFoundException extends GlobalException {
    public UserNotFoundException(String message, Integer code) {
        super(message, code);
    }
}
