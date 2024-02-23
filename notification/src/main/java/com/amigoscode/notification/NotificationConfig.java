package com.amigoscode.notification;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;


    @Value("${rabbitmq.queues.notification}")
    private String  notificationQueue;

   @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotificationRoutingKey;

   @Bean
   // Define exchange
   public TopicExchange internalTopicExchange(){
       return new TopicExchange(this.internalExchange);

   }
   @Bean
   // define queue
   public Queue notificationQueue(){
       return new Queue (this.notificationQueue);
   }

  @Bean
  // Binding of Topic Exchange and queue which is done using the routing key
   public Binding internalToNotificationBinding(){
       return BindingBuilder
               .bind(notificationQueue())
               .to(internalTopicExchange())
               .with(this.internalNotificationRoutingKey);
   }
    public String getInternalExchange() {
        return internalExchange;
    }
    public String getnotificationQueue() {
        return notificationQueue;
    }
    public String getinternalNotificationRoutingKey() {
        return internalNotificationRoutingKey;
    }
}
