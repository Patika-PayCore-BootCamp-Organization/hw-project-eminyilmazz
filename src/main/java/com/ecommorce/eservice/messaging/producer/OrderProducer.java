package com.ecommorce.eservice.messaging.producer;

import com.ecommorce.eservice.config.RabbitMQConfig;
import com.ecommorce.eservice.model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class OrderProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @PostMapping("/test")
    public void onOrder(@RequestBody Order order) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, order);
        System.out.println("Order: \n" + order + "\nSent");
    }
}
