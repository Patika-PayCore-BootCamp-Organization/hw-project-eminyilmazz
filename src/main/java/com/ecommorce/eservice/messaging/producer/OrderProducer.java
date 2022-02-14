package com.ecommorce.eservice.messaging.producer;

import com.ecommorce.eservice.config.RabbitMQConfig;
import com.ecommorce.eservice.model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void onOrder(Order order) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, order);
    }
}