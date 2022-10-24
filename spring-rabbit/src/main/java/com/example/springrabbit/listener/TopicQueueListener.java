package com.example.springrabbit.listener;

import com.alibaba.fastjson2.JSONObject;
import com.example.springrabbit.common.RabbitMQConstant;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

// 在一个类中监听的定义方式
@Component
@EnableRabbit
public class TopicQueueListener {

    @RabbitHandler
    @RabbitListener(queues = {RabbitMQConstant.QUEUE_TOPIC1})
    public void process1(JSONObject jsonObject) {
        Map<String, Object> map = jsonObject;
        System.out.println("绑定队列queue.topic1的消费者收到消息  : " + map);
    }

    @RabbitHandler
    @RabbitListener(queues = {RabbitMQConstant.QUEUE_TOPIC2})
    public void process2(JSONObject jsonObject) {
        Map<String, Object> map = jsonObject;
        System.out.println("绑定队列queue.topic2的消费者收到消息  : " + map);
    }
}
