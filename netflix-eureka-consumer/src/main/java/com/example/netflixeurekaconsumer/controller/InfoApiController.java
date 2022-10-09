package com.example.netflixeurekaconsumer.controller;

import com.example.netflixeurekaconsumer.feign.InfoApiFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoApiController {

    @Autowired
    private InfoApiFeign infoApiFeign;

    /**
     * openfeign 调用netflix-eureka-client服务的/getInfo接口
     *
     * @return
     */
    @PostMapping("/getInfo")
    public String getInfo() {
        return "服务间调用：" + infoApiFeign.getInfo();
    }

}
