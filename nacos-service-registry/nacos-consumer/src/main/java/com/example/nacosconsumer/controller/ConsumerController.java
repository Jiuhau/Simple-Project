package com.example.nacosconsumer.controller;

import com.example.nacosconsumer.feign.ProviderClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    private static final Logger LOG = LoggerFactory.getLogger(ConsumerController.class);

    //动态代理对象，内部远程调用服务生产者
    @Autowired
    ProviderClient providerClient;

    @GetMapping("/service")
    private String service() {
        LOG.info("consumer invoke");
        String service = providerClient.service();
        return "consumer invoke ：" + service;
    }

}

