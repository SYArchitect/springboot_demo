package com.example.springboot_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author f554
 */
@SpringBootApplication(scanBasePackages = {"com.example.springboot_demo.*"})
@MapperScan("com.example.springboot_demo.Dao")
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
