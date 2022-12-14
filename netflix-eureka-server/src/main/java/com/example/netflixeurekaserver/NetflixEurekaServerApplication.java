package com.example.netflixeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //开启注册中心
public class NetflixEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixEurekaServerApplication.class, args);
    }

}
