package cn.zhaofd.demorabbitmqweb.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置
 */
@Configuration
public class RabbitMQConfig {
    /**
     * 创建队列
     *
     * @return Queue
     */
    @Bean
    public Queue LogQueue() {
        return new Queue("log-queue");
    }
}
