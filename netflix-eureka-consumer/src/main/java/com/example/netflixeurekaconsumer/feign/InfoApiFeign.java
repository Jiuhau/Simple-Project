package com.example.netflixeurekaconsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// 注册中心上的服务名spring.application.name
@FeignClient("netflix-eureka-client")
public interface InfoApiFeign {

    //注意这个接口必须与生产者接口保持一致，任何地方都不可以不一样，否则将失败
    @PostMapping("/getInfo")
    public String getInfo();
}
