package com.absolute.cinema.dto.card;


import jakarta.validation.constraints.NotBlank;

public record BillingAddress(

        @NotBlank(message = "Billing address is required")
        String address,

        @NotBlank(message = "Billing city is required")
        String city,

        @NotBlank(message = "Billing zip is required")
        String zip,

        @NotBlank(message = "Billing country is required")
        String country
) {
}
