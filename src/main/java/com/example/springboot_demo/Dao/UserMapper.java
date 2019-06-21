package com.example.springboot_demo.Dao;

import com.example.springboot_demo.Modal.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by Huang Fuzhi on 2019/6/2.
 */
@Mapper
@Component
public interface UserMapper {

    /**
     * 用户登录
     */
    User userlogin(@Param("username") String username, @Param("password") String password);

    User getUser(@Param("id") Integer id);

    /**
     * 用户注册，方式1
     */
    int adduser(User user);

    /**
     * 用户注册，方式2
     */
    int adduser1(@Param("username") String username, @Param("password") String password, @Param("age") int age);

}
