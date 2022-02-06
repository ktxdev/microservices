package org.ktxdev.notification;

import org.ktxdev.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public record NotificationService(NotificationRepository notificationRepository) {
    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.getToCustomerId())
                        .toCustomerEmail(notificationRequest.getToCustomerEmail())
                        .sentAt(notificationRequest.getSentAt())
                        .message(notificationRequest.getMessage())
                        .sender("Ktxdev")
                        .build()
        );
    }
}
