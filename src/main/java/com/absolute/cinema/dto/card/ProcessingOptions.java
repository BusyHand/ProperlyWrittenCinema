package com.absolute.cinema.dto.card;

import jakarta.validation.constraints.Min;

public record ProcessingOptions(

        boolean sendConfirmationEmail,
        boolean createInvoice,

        @Min(value = 0, message = "Retry count cannot be negative")
        int retryCount
) {
}


