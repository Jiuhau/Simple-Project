package com.example.springrabbit.config;

import com.example.springrabbit.common.RabbitMQConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitMQConfig {

    /*todo 声明交换机 */

    /**
     * 直连交换机
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(RabbitMQConstant.EXCHANGE_DIRECT);
    }

    /*todo 声明队列 */

    /**
     * 直连交换机对应队列
     */
    @Bean
    public Queue directQueue() {
        // durable:默认false,是否持久化,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
        // exclusive:默认false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
        // autoDelete:默认false，是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除
        return new Queue(RabbitMQConstant.QUEUE_DIRECT);
    }

    /*todo 绑定交换机与队列 */

    /**
     * 绑定直连队列到直连交换机并设置路由键routing.key.direct
     */
    @Bean
    public Binding bindDirectQueue() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with(RabbitMQConstant.ROUTING_KEY_DIRECT);
    }

}
