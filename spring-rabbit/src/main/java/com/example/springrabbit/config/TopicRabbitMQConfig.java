package com.example.springrabbit.config;

import com.example.springrabbit.common.RabbitMQConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitMQConfig {

    /*todo 声明交换机 */

    /**
     * 主题交换机
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(RabbitMQConstant.EXCHANGE_TOPIC);
    }

    /*todo 声明队列 */

    /**
     * 主题交换机对应队列1
     */
    @Bean
    public Queue topicQueue1() {
        return new Queue(RabbitMQConstant.QUEUE_TOPIC1);
    }

    /**
     * 主题交换机对应队列2
     */
    @Bean
    public Queue topicQueue2() {
        return new Queue(RabbitMQConstant.QUEUE_TOPIC2);
    }

    /*todo 绑定交换机与队列 */

    /**
     * 只要是消息携带的路由键是routing.key.direct1,才会分发到该队列
     */
    @Bean
    public Binding bindTopicQueue1() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with(RabbitMQConstant.ROUTING_KEY_TOPIC1);
    }

    /**
     * 只要是消息携带的路由键是以routing.key.开头,都会分发到该队列
     */
    @Bean
    public Binding bindTopicQueue2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with(RabbitMQConstant.ROUTING_KEY_TOPIC_ALL);
    }
}
