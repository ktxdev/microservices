package org.ktxdev.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
