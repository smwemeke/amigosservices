package com.amigoscode.customer;

public record CustomerRegistrationRequest(
        String firstname,
        String lastname,
        String email

) {
}
