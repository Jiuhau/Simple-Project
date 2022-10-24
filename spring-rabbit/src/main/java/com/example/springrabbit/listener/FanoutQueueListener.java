package com.example.springrabbit.listener;

import com.alibaba.fastjson2.JSONObject;
import com.example.springrabbit.common.RabbitMQConstant;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@EnableRabbit
public class FanoutQueueListener {

    @RabbitHandler
    @RabbitListener(queues = {RabbitMQConstant.QUEUE_FANOUT1})
    public void process1(JSONObject jsonObject) {
        Map<String, Object> map = jsonObject;
        System.out.println("绑定队列queue.fanout.f1的消费者收到消息  : " + map);
    }

    @RabbitHandler
    @RabbitListener(queues = {RabbitMQConstant.QUEUE_FANOUT2})
    public void process2(JSONObject jsonObject) {
        Map<String, Object> map = jsonObject;
        System.out.println("绑定队列queue.fanout.f2的消费者收到消息  : " + map);
    }

    @RabbitHandler
    @RabbitListener(queues = {RabbitMQConstant.QUEUE_FANOUT3})
    public void process3(JSONObject jsonObject) {
        Map<String, Object> map = jsonObject;
        System.out.println("绑定队列queue.fanout.f3的消费者收到消息  : " + map);
    }
}
