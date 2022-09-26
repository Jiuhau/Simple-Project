package com.example.nacosconsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("nacos-provider")
public interface ProviderClient {

    //注意这个接口必须与生产者接口保持一致，任何地方都不可以不一样，否则将失败
    @GetMapping("/service")
    public String service();
}
