package com.example.springrabbit.common;

public class RabbitMQConstant {

    // 直连交换机 根据Routing Key(路由键)进行投递到不同队列
    public static final String EXCHANGE_DIRECT = "exchange.direct";
    // 扇形交换机 采用广播模式，交换机在接收到消息后，会直接转发到绑定到它上面的所有队列
    public static final String EXCHANGE_FANOUT = "exchange.fanout";
    // 主题交换机 对路由键进行模式匹配后进行投递，符号#表示一个或多个词，*表示一个词
    public static final String EXCHANGE_TOPIC = "exchange.topic";
    // 头交换机 不处理路由键。而是根据发送的消息内容中的headers属性进行匹配
    public static final String EXCHANGE_HEADER = "EXCHANGE";
    // 默认交换机
    public static final String EXCHANGE_DEFAULT = "EXCHANGE";
    // 死信交换机
    public static final String EXCHANGE_DEAD_LETTER = "EXCHANGE";

    // 直连队列
    public static final String QUEUE_DIRECT = "queue.direct";
    // 扇形队列
    public static final String QUEUE_FANOUT1 = "queue.fanout.f1";
    public static final String QUEUE_FANOUT2 = "queue.fanout.f2";
    public static final String QUEUE_FANOUT3 = "queue.fanout.f3";
    // 主题队列
    public static final String QUEUE_TOPIC1 = "queue.topic1";
    public static final String QUEUE_TOPIC2 = "queue.topic2";
    // 头队列
    public static final String QUEUE_HEADER = "QUEUE";
    // 默认队列
    public static final String QUEUE_DEFAULT = "QUEUE";
    // 死信队列
    public static final String QUEUE_DEAD_LETTER = "QUEUE";

    // 直连路由键
    public static final String ROUTING_KEY_DIRECT = "routing.key.direct";
    // 扇形路由键
    public static final String ROUTING_KEY_FANOUT = "不需要路由键";
    // 主题路由键
    public static final String ROUTING_KEY_TOPIC1 = "routing.key.topic.t1";
    public static final String ROUTING_KEY_TOPIC2 = "routing.key.topic.t2";
    public static final String ROUTING_KEY_TOPIC_ALL = "routing.key.topic.#"; // #表示一个或多个词，*表示一个词
}
