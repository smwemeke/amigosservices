package com.amigoscode.notification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;


    @Value("${rabbitmq.queue.notification}")
    private String  internalQueue;

   @Value("${rabbitmq.routing-keys.internal-notification}")
    private String routingKeys;

    public String getInternalExchange() {
        return internalExchange;
    }

    public String getInternalQueue() {
        return internalQueue;
    }

    public String getRoutingKeys() {
        return routingKeys;
    }
}
