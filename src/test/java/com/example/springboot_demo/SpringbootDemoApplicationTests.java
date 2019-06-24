package com.example.springboot_demo;

import com.example.springboot_demo.Modal.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 测试使用redis存储字符串类型
     */
    @Test
    public void TestStringRedisTemplate()
    {
        stringRedisTemplate.opsForValue().set("key1","value1");
        String value=stringRedisTemplate.opsForValue().get("key1");
        System.out.println(value);
    }

    /**
     * 测试使用redis存储对象类型
     */
    @Test
    public void TestRedisTemplate()
    {
        User user = new User();
        user.setId(1);
        user.setUsername("null");
        user.setAge(21);
        user.setPassword("123456");
        redisTemplate.opsForValue().set("user",user);
        User temp=(User)redisTemplate.opsForValue().get("user");
        System.out.println(temp.getUsername());
    }

}
