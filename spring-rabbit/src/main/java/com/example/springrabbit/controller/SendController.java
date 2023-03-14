package com.example.springrabbit.controller;

import com.alibaba.fastjson2.JSONObject;
import com.example.springrabbit.common.RabbitMQConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 这是消息产生者
 */
@RestController
public class SendController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/apitest", method = RequestMethod.POST)
    @ResponseBody
    public Map recordActionInfo(String data, MultipartFile[] Files,MultipartFile files) {
        System.out.println(data);
        System.out.println(Files);
        System.out.println(files);
//        System.out.println(files[1]);
        return new HashMap();
    }

    /**
     * 发送消息到队列中(还需消费者从队列中获取消息并消费)
     *
     * @return
     */
    @RequestMapping("/sendDirectMessage")
    public String sendDirectMessage() {
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("messageId", UUID.randomUUID());
            put("messageData", "Hello, Direct Message Test!");
            put("createTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }};
        //将消息携带绑定键值：routing.key.direct 发送到交换机exchange.direct
        rabbitTemplate.convertAndSend(RabbitMQConstant.EXCHANGE_DIRECT, RabbitMQConstant.ROUTING_KEY_DIRECT, new JSONObject(map));
        // 可在http://127.0.0.1:15672/#/下 Overview下 Totals下 看到有1个ready
        return "ok";
    }

    /**
     * Topic交换机测试
     *
     * @return
     */
    @RequestMapping("/sendTopicMessage1")
    public String sendTopicMessage1() {
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("messageId", UUID.randomUUID());
            put("messageData", "Hello, Topic Message1 Test!");
            put("createTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }};
        //将消息携带绑定键值：routing.key.direct1 发送到交换机exchange.topic
        rabbitTemplate.convertAndSend(RabbitMQConstant.EXCHANGE_TOPIC, RabbitMQConstant.ROUTING_KEY_TOPIC1, new JSONObject(map));
        return "ok";
    }

    /**
     * Topic交换机测试
     *
     * @return
     */
    @RequestMapping("/sendTopicMessage2")
    public String sendTopicMessage2() {
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("messageId", UUID.randomUUID());
            put("messageData", "Hello, Topic Message2 Test!");
            put("createTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }};
        //将消息携带绑定键值：routing.key.direct2 发送到交换机exchange.topic
        rabbitTemplate.convertAndSend(RabbitMQConstant.EXCHANGE_TOPIC, RabbitMQConstant.ROUTING_KEY_TOPIC2, new JSONObject(map));
        return "ok";
    }

    /**
     * Fanout交换机测试
     *
     * @return
     */
    @RequestMapping("/sendFanoutMessage")
    public String sendFanoutMessage() {
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("messageId", UUID.randomUUID());
            put("messageData", "Hello, Fanout Message Test!");
            put("createTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }};
        //将消息发送到交换机exchange.fanout 不需要路由键
        rabbitTemplate.convertAndSend(RabbitMQConstant.EXCHANGE_FANOUT, null, new JSONObject(map));
        return "ok";
    }
}
