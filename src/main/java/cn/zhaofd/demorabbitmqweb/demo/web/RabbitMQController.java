package cn.zhaofd.demorabbitmqweb.demo.web;

import cn.zhaofd.demorabbitmqweb.demo.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RabbitMQ应用示例
 */
@RestController
@RequestMapping("/demo/rabbitmq")
public class RabbitMQController {
    private final RabbitMQService rabbitMQService;

    public RabbitMQController(@Autowired RabbitMQService rabbitMQService) {
        this.rabbitMQService = rabbitMQService;
    }

    /**
     * 发送消息
     *
     * @param message 消息
     */
    @GetMapping("/sendMessage")
    public void sendMessage(String message) {
        rabbitMQService.sendMessage(message);
    }
}
