package com.example.netflixeurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //开启发现服务注册
public class NetflixEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixEurekaClientApplication.class, args);
    }

}
