package com.example.springrabbit.listener;

import com.alibaba.fastjson2.JSONObject;
import com.example.springrabbit.common.RabbitMQConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 这是消息消费者
 */
@Component
@RabbitListener(queues = {RabbitMQConstant.QUEUE_DIRECT})
public class DirectQueueListener2 {

    /**
     * 多台监听器绑定同一个直连队列，轮询消费 多次调用localhost:8080/sendDirectMessage查看
     * @param jsonObject
     */
    @RabbitHandler
    public void process(JSONObject jsonObject) {
        Map<String, Object> map = jsonObject;
        System.out.println("第二个Direct消费者收到消息  : " + map);
    }
}
