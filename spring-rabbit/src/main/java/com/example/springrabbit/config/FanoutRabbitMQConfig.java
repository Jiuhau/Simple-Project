package com.example.springrabbit.config;

import com.example.springrabbit.common.RabbitMQConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class FanoutRabbitMQConfig {

    /*todo 声明交换机 */

    /**
     * 扇形交换机
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(RabbitMQConstant.EXCHANGE_FANOUT);
    }

    /*todo 声明队列 */

    /**
     * 扇形交换机对应队列
     */
    @Bean
    public Queue fanoutQueue1() {
        return new Queue(RabbitMQConstant.QUEUE_FANOUT1);
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue(RabbitMQConstant.QUEUE_FANOUT2);
    }

    @Bean
    public Queue fanoutQueue3() {
        return new Queue(RabbitMQConstant.QUEUE_FANOUT3);
    }

    /*todo 绑定交换机与队列 */

    @Bean
    public Binding bindFanoutQueue1() {
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding bindFanoutQueue2() {
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }

    @Bean
    public Binding bindFanoutQueue3() {
        return BindingBuilder.bind(fanoutQueue3()).to(fanoutExchange());
    }
}
