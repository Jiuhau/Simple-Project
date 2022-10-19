package com.example.springaspectsaop.controller;

import com.example.springaspectsaop.annotatioin.LogAnnotatioin;
import com.example.springaspectsaop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user2")
public class UserController2 {

    @Autowired
    UserService userService;

    @PostMapping("/getAll")
    public String getAll() {
        return userService.getAll();
    }

    @LogAnnotatioin(desc = "@Annotation") // 标有这个注解的方法会被增强
    @PostMapping("/getOne")
    public String getOne(String name) {
        return userService.getOne(name);
    }
}
