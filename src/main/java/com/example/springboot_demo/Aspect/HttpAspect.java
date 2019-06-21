package com.example.springboot_demo.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 定义切面
 * @author Huang Fuzhi
 * @date 2019/6/16
 */
@Aspect
@Component
public class HttpAspect {

    private static final Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.springboot_demo.Controller.UserController.userLogin(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //URL
        logger.info("url={}", request.getRequestURL());

        //Method 请求方法Get、Post...
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()
                + "."+ joinPoint.getSignature().getName());

        //将所有方法参数输出到日志
        Object []objects=joinPoint.getArgs();
        for (Object object : objects) {
            logger.info("arg={}", object.toString());
        }
    }

    @After("log()")
    public void doAfter(){
        logger.info("After userLogin");
    }

    /**
     * 获取方法的返回结果
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}", object);
    }

}
