package com.example.springrabbit.config;

import com.example.springrabbit.common.MyAckReceiver;
import com.example.springrabbit.common.RabbitMQConstant;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CallbackRabbitMQConfig {

    /**
     * 第三种情况测试
     */
    @Bean
    public DirectExchange nonQueueExchange() {
        return new DirectExchange("find_exchange_non_queue");
    }

    /**
     * 生产者消息推送成功消息确认
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("ConfirmCallback:     " + "相关数据：" + correlationData);
                System.out.println("ConfirmCallback:     " + "确认情况：" + ack);
                System.out.println("ConfirmCallback:     " + "原因：" + cause);
            }
        });

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("ReturnCallback:     " + "消息：" + message);
                System.out.println("ReturnCallback:     " + "回应码：" + replyCode);
                System.out.println("ReturnCallback:     " + "回应信息：" + replyText);
                System.out.println("ReturnCallback:     " + "交换机：" + exchange);
                System.out.println("ReturnCallback:     " + "路由键：" + routingKey);
            }
        });

        return rabbitTemplate;
    }

    /**
     * 消费者消息确认机制
     * 1、自动确认 RabbitMQ成功将消息发出（即将消息成功写入TCP Socket）中立即认为本次投递已经被正确处理，不管消费者端是否成功处理本次投递
     * 2、手动确认 basic.ack用于肯定确认 basic.nack用于否定确认 basic.reject用于否定确认，但与basic.nack相比有一个限制:一次只能拒绝单条消息
     * 2.1、basic.nack channel.basicNack(deliveryTag,false,true)
     * 第一个参数依然是当前消息到的数据的唯一id;
     * 第二个参数是指是否针对多条消息；如果是true，也就是说一次性针对当前通道的消息的tagID小于当前这条消息的，都拒绝确认
     * 第三个参数是指是否重新入列，也就是指不确认的消息是否重新丢回到队列里面去
     * 2.2、basic.reject channel.basicReject(deliveryTag,true) 拒绝消费当前消息，如果第二参数传入true，就是将数据重新丢回队列里
     */

    @Autowired
    private CachingConnectionFactory cachingConnectionFactory;
    @Autowired
    private MyAckReceiver myAckReceiver;

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cachingConnectionFactory);
        container.setConcurrentConsumers(1); // 设置并发用户数量
        container.setMaxConcurrentConsumers(1); // 设置最大并发用户数量
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // RabbitMQ默认是自动确认，这里改为手动确认消息
        //设置一个队列
        container.setQueueNames(RabbitMQConstant.QUEUE_DIRECT);
        //如果同时设置多个如下： 前提是队列都是必须已经创建存在的
        //container.setQueueNames("TestDirectQueue","TestDirectQueue2","TestDirectQueue3");

        //另一种设置队列的方法,如果使用这种情况,那么要设置多个,就使用addQueues
        //container.setQueues(new Queue("TestDirectQueue",true));
        //container.addQueues(new Queue("TestDirectQueue2",true));
        //container.addQueues(new Queue("TestDirectQueue3",true));
        container.setMessageListener(myAckReceiver);
        return container;
    }
}
