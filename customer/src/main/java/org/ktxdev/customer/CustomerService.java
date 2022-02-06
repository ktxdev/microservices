package org.ktxdev.customer;

import lombok.val;
import org.ktxdev.clients.fraud.FraudClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate, FraudClient fraudClient) {

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

    }
}
