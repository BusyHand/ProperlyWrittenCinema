package com.absolute.cinema.dto.card;

import com.absolute.cinema.common.enums.CardType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CardDetails(

        @NotBlank(message = "Card number is required")
        @Size(min = 13, max = 19, message = "Card number must be between 13 and 19 digits")
        @Pattern(regexp = "\\d+", message = "Card number must contain only digits")
        String cardNumber,

        @NotBlank(message = "Expiry date is required")
        @Pattern(
                regexp = "(0[1-9]|1[0-2])/\\d{2}",
                message = "Expiry date must be in MM/YY format"
        )
        String expiryDate,

        @NotBlank(message = "CVV is required")
        @Pattern(regexp = "\\d{3,4}", message = "CVV must be 3 or 4 digits")
        String cvv,

        @NotBlank(message = "Cardholder name is required")
        String cardholderName,

        @NotNull(message = "Card type is required")
        CardType cardType
) {
}

