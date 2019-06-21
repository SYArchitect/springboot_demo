package com.example.springboot_demo.Controller;

import com.example.springboot_demo.Aspect.HttpAspect;
import com.example.springboot_demo.Modal.User;
import com.example.springboot_demo.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Huang Fuzhi on 2019/6/2.
 */
@Controller
@RequestMapping(value = {"/user"})
public class UserController {

    private static final Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private UserService userService;

    /**
     * 跳转到登录页面
     * @return 登录页面
     */
    @RequestMapping(value = {"/login"})
    public String login()
    {
        return "userLogin";
    }

    /**
     * 跳转到用户注册页面
     * @return 注册页面
     */
    @RequestMapping(value = {"/register"})
    public String register()
    {
        return "register";
    }

    /**
     * 获取用户名和密码进行登录
     * @param id1
     * @param userInput
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"/userLogin/{id1}"},method = RequestMethod.POST)
    public User userLogin(@PathVariable("id1") int id1, User userInput)
    {
        User user = userService.useLogin(userInput.getUsername(),userInput.getPassword());

        logger.info("userLogin");

        return user;
    }

    @ResponseBody
    @RequestMapping(value = {"/uregister"})
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("password2") String password2,
                          @RequestParam("age") int age)
    {
        if (!password.equals(password2))
        {
            return "两次输入密码不一致，注册失败！！";
        }
        else
        {
            int result = userService.adduser(username,password,age);
            if (result==0)
            {
                return "注册失败！";
            }
            else
            {
                return "注册成功！";
            }
        }
    }

}
