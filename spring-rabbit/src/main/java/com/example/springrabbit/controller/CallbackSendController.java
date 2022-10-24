package com.example.springrabbit.controller;

import com.alibaba.fastjson2.JSONObject;
import com.example.springrabbit.common.RabbitMQConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 测试ack
 * 1、消息推送到server,找不到交换机
 * 2、消息推送到server,找不到交换机,找不到队列
 * 3、消息推送到server,找到交换机,找不到队列
 * 4、成功推送
 */
@RestController
public class CallbackSendController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 触发的是ConfirmCallback回调函数
     */
    @RequestMapping("/ackMessage1")
    public String ackMessage1() {
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("messageId", UUID.randomUUID());
            put("messageData", "消息推送到server,找不到交换机 测试");
            put("createTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }};
        rabbitTemplate.convertAndSend("this_exchange_not_exist", "routingKey", new JSONObject(map));
        return "ok";
    }

    /**
     * 同上
     */
    @RequestMapping("/ackMessage2")
    public String ackMessage2() {
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("messageId", UUID.randomUUID());
            put("messageData", "消息推送到server,找不到交换机,找不到队列 测试");
            put("createTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }};
        rabbitTemplate.convertAndSend("this_exchange_not_exist", "routingKey", new JSONObject(map));
        return "ok";
    }

    /**
     * 触发的是ConfirmCallback和RetrunCallback两个回调函数
     */
    @RequestMapping("/ackMessage3")
    public String ackMessage3() {
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("messageId", UUID.randomUUID());
            put("messageData", "消息推送到server,找到交换机,找不到队列 测试");
            put("createTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }};
        rabbitTemplate.convertAndSend("find_exchange_non_queue", "routingKey", new JSONObject(map));
        return "ok";
    }

    /**
     * 触发的是ConfirmCallback回调函数
     * 此接口也用于测试消费端回调
     */
    @RequestMapping("/ackMessage4")
    public String ackMessage4() {
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("messageId", UUID.randomUUID());
            put("messageData", "成功推送 测试");
            put("createTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }};
        //调用之前成功的队列
        rabbitTemplate.convertAndSend(RabbitMQConstant.EXCHANGE_DIRECT, RabbitMQConstant.ROUTING_KEY_DIRECT, new JSONObject(map));
        return "ok";
    }
}
