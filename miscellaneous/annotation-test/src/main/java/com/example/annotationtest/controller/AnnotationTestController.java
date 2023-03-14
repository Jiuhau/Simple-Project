package com.example.annotationtest.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.annotationtest.annotation.AnnotationTest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/annotation")
public class AnnotationTestController {

    @PostMapping(value = "/postTest")
    @AnnotationTest
    public String postAnnotationTest(@RequestBody JSONObject params) {
        System.out.println("进入POST接口");
        return JSON.toJSONString(params);
    }

    @GetMapping(value = "/getTest")
    @AnnotationTest
    public String getAnnotationTest(@RequestBody JSONObject params) {
        System.out.println("进入GET接口");
        return JSON.toJSONString(params);
    }
}
