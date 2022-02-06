package org.ktxdev.customer;

import lombok.val;
import org.ktxdev.clients.fraud.FraudClient;
import org.ktxdev.clients.notification.NotificationClient;
import org.ktxdev.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public record CustomerService(CustomerRepository customerRepository, FraudClient fraudClient, NotificationClient notificationClient) {

    public void register(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();

        customerRepository.saveAndFlush(customer);

        val response = fraudClient.isFraudster(customer.getId());

        if (response.isFraudster())
            throw new IllegalStateException("Fraudster");

        notificationClient.sendNotification(
                NotificationRequest.builder()
                        .toCustomerId(customer.getId())
                        .toCustomerEmail(customer.getEmail())
                        .message(String.format("Hi %s, welcome to Ktxdev.org...", customer.getFirstName()))
                        .sentAt(LocalDate.now())
                        .build()

        );
    }
}
