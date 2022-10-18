package com.example.springaspectsaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy // 开启切面
@SpringBootApplication
public class SpringAspectsAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAspectsAopApplication.class, args);
    }

}
