package com.amigoscod.amqp;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AllArgsConstructor
public class RabbitMQConfig {
    @Autowired
    private  ConnectionFactory connectionFactory;

    @Bean
    public AmqpTemplate amqpTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        rabbitTemplate.setMessageConverter(jacksonConveter());
        return  rabbitTemplate;
    }
    @Bean
    public MessageConverter jacksonConveter(){
        MessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        return  jackson2JsonMessageConverter;

    }
}
