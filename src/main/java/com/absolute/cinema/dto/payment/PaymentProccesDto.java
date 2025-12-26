package com.absolute.cinema.dto.payment;

import com.absolute.cinema.common.enums.PaymentMethod;
import com.absolute.cinema.dto.card.BillingAddress;
import com.absolute.cinema.dto.card.CardDetails;
import com.absolute.cinema.dto.card.Money;
import com.absolute.cinema.dto.card.ProcessingOptions;

import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


public record PaymentProccesDto(

        @NotNull(message = "Purchase ID is required")
        UUID purchaseId,

        @NotNull(message = "Payment method is required")
        PaymentMethod paymentMethod,

        @Valid
        CardDetails cardDetails,

        @NotNull(message = "Billing address is required")
        @Valid
        BillingAddress billingAddress,

        @NotNull(message = "Money is required")
        @Valid
        Money money,

        @NotNull(message = "Processing options are required")
        @Valid
        ProcessingOptions options
) {
}

