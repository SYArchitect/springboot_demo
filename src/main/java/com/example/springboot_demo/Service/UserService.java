package com.example.springboot_demo.Service;

import com.example.springboot_demo.Dao.UserMapper;
import com.example.springboot_demo.Exception.EnumResult;
import com.example.springboot_demo.Exception.UserNotFoundException;
import com.example.springboot_demo.Modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Huang Fuzhi on 2019/6/2.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     */
    public User useLogin(String username, String password)
    {
        User user = userMapper.userlogin(username,password);
        return user;
    }

    /**
     * 查询用户
     * @param id
     * @return
     */
    public User GetUser(Integer id) throws UserNotFoundException
    {
        User user = userMapper.getUser(id);
        //用户不存在
        if (user == null)
        {
            throw new UserNotFoundException(EnumResult.USER_NOT_FOUND.getMsg(),EnumResult.USER_NOT_FOUND.getCode());
        }
        return user;
    }

    /**
     * 注册新用户
     */
    public int adduser(String username, String password, int age)
    {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAge(age);
        return userMapper.adduser(user);
    }

}
