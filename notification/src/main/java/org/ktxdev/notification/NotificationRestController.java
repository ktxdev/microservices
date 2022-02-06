package org.ktxdev.notification;

import lombok.extern.slf4j.Slf4j;
import org.ktxdev.clients.notification.NotificationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/notification")
public record NotificationRestController(NotificationService notificationService) {

    @PostMapping
    public void send(@RequestBody NotificationRequest request) {
        log.info("### Notification request received: {}", request);
        notificationService.send(request);
    }
}
