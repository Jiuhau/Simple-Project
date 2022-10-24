package com.example.jdkdozer.controller;

import com.example.jdkdozer.res.UserVo;
import com.example.jdkdozer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    public TestService testService;

    @RequestMapping("/getUser")
    public UserVo getUser() {
        return testService.getUser();
    }
}
