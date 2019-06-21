package com.example.springboot_demo.Handler;

import com.example.springboot_demo.Exception.Result;
import com.example.springboot_demo.Exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 统一异常处理
 * @author Huang Fuzhi
 * @date 2019/6/16
 */
@ControllerAdvice
public class RestExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result handleResourceNotFoundException(Exception e)
    {
        logger.error(e.getMessage(),e);
        if (e instanceof UserNotFoundException)
        {
            UserNotFoundException userNotFoundException = (UserNotFoundException) e;
            return new Result(userNotFoundException.getCode(),userNotFoundException.getMessage());
        }
        else
        {
            return new Result(-1,"系统异常");
        }
    }
}
