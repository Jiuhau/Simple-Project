package com.example.springaspectsaop.controller;

import com.example.springaspectsaop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/getAll")
    public String getAll() {
        return userService.getAll();
    }

    @PostMapping("/getOne")
    public String getOne(String name) {
        return userService.getOne(name);
    }
}
