package com.example.springcloudconfigconsumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InfoController {

    @Value("${config.name:notFound}")
    String name;

    @PostMapping("/getConfig")
    public String getConfig() {
        return "name:" + name;
    }

    // 测试单个数据是否可被识别为List
    @Value("${config.girlfriendList:notFound}")
    List<String> girlfriendList; // List数据
    @Value("${config.boyfriendList:notFound}")
    List<String> boyfriendList; // 单个数据
    @Value("#{'${config.babyList:notFound}'.split(',')}")
    List<String> babyList; // 逗号分割的单个数据

    @PostMapping("/getConfigList")
    public String getConfigList() {
        List<String> girlfriendList = this.girlfriendList;
        List<String> boyfriendList = this.boyfriendList;
        List<String> babyList = this.babyList;
        return "girlfriendList:" + girlfriendList
                + "\n" + "boyfriendList:" + boyfriendList
                + "\n" + "babyList:" + babyList;
    }
}
