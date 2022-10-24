package com.example.jdkdozer;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class JdkDozerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdkDozerApplication.class, args);
    }

    @Bean
    public Mapper dozerMapper(){
        return new DozerBeanMapper();
    }
}
