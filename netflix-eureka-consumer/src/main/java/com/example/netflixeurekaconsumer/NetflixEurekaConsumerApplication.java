package com.example.netflixeurekaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient //开启发现服务注册
@EnableFeignClients // 启用feign客户端
public class NetflixEurekaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixEurekaConsumerApplication.class, args);
    }

}
