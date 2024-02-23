package com.amigoscode.notification;

import com.amigoscode.amqp.RabbitMQMessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication (
        scanBasePackages = {
                "com.amigoscode.notification",
                "com.amigoscode.amqp",
        }
)
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
public class NotificationApplication {
//   @Autowired
//    private  NotificationService notificationService;

    public static void main(String [] args){

        SpringApplication.run(NotificationApplication.class, args);

    }
//
//    @RabbitListener(queues = "${rabbitmq.queues.notification}")
//    public void consumer(NotificationRequest notificationRequest) {
//        log.info("Consumed {} from queue", notificationRequest);
//        notificationService.sendNotification(notificationRequest);
//    }
//    @Bean
//    CommandLineRunner commandLineRunner (
//            RabbitMQMessageProducer producer,
//            NotificationConfig notificationConfig
//    ){
//        return args -> {
//            producer.publish(
//                    "myMicroservice",
//                    notificationConfig.getInternalExchange(),
//                    notificationConfig.getinternalNotificationRoutingKey()
//            );
//        };
//    }
}
