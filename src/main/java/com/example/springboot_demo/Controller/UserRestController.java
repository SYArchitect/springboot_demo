package com.example.springboot_demo.Controller;

import com.example.springboot_demo.Exception.UserNotFoundException;
import com.example.springboot_demo.Modal.User;
import com.example.springboot_demo.Service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Restful API
 * @author Huang Fuzhi
 * @date 2019/6/16
 */
@RestController
@RequestMapping("api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户信息",notes = "根据id获取用户信息")
    @GetMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.OK)    //标识正常返回时的状态码
    public User getUser(@PathVariable("id") Integer id) throws UserNotFoundException
    {
        return userService.GetUser(id);
    }

    @ApiOperation(value = "添加用户",notes = "添加用户")
    @PostMapping(value = "/users")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Object addUser(User user)
    {
        return userService.adduser(user.getUsername(),user.getPassword(),user.getAge());
    }

}
