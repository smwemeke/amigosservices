package com.amigoscode.notification.rabbitmq;

import com.amigoscode.notification.NotificationRequest;
import com.amigoscode.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private  final NotificationService notificationService;


    public NotificationConsumer(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("Consumed {} from queue", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }
}