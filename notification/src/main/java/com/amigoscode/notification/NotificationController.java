package com.amigoscode.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    @PostMapping
    public ResponseEntity<?> sendNotification(@RequestBody  NotificationRequest notificationRequest){
        log.info("New notification sent {}", notificationRequest);
        notificationService.sendNotification(notificationRequest);
        return  new ResponseEntity<>("Notification sent successfully", HttpStatus.OK);

    }

}
