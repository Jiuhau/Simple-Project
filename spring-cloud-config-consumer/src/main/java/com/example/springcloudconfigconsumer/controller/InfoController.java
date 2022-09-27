package com.example.springcloudconfigconsumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Value("${config.name:notFound}")
    String name;

    @PostMapping("/getConfig")
    public String getConfig() {
        return "name:" + name;
    }
}
