package com.amigoscode.notification;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    public void sendNotification(NotificationRequest request){
        Notification notification = Notification.builder()
                .toCustomerEmail(request.toCustomerEmail())
                .toCustomerId(request.toCustomerId())
                .message(request.message())
                .sender("Sue M")
                .sentAt(LocalDateTime.now())
                .build();
        notificationRepository.save(notification);
    }
}
