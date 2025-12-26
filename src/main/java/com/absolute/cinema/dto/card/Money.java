package com.absolute.cinema.dto.card;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record Money(

        @Min(value = 1, message = "Payment amount must be positive")
        int amountCents,

        @NotBlank(message = "Currency is required")
        @Pattern(
                regexp = "EUR|USD|GBP",
                message = "Unsupported currency"
        )
        String currency
) {
}

