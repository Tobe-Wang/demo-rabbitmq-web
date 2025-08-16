package cn.zhaofd.demorabbitmqweb.modules.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RabbitMQ应用示例
 */
@Service
public class RabbitMQService {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQService.class);
    private final RabbitTemplate rabbitTemplate;
    private final Queue logQueue;

    public RabbitMQService(@Autowired RabbitTemplate rabbitTemplate, @Autowired Queue logQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.logQueue = logQueue;
    }

    /**
     * 发送消息
     *
     * @param message 消息
     */
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(logQueue.getName(), message);
    }

    /**
     * 接收消息
     *
     * @param message 消息
     */
    @RabbitListener(queues = "log-queue")
    public void receiveMessage(String message) {
        logger.info("Received <{}>", message);
    }
}
