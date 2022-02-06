package org.ktxdev.clients.notification;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {
    private int toCustomerId;

    private String toCustomerEmail;

    private String message;

    private String sender;

    private LocalDate sentAt;
}
