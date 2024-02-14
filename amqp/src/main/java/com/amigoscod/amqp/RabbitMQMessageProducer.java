package com.amigoscod.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

   // publish message to topic exchange
    public void publish (Object payload, String exchange, String routingKey){
        log.info("Publishinh to {} using routingKey {}. Payload: {}", exchange, routingKey);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("Published to {} using routingKey {}. Payload: {}", exchange, routingKey);

    }

}
