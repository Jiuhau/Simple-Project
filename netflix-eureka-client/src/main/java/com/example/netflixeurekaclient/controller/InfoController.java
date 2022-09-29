package com.example.netflixeurekaclient.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @PostMapping("/getInfo")
    public String getInfo() {
        return "eureka client 客户端方法回参";
    }
}
