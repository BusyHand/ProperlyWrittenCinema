package com.absolute.cinema.common.enums;

public enum PaymentMethod {

    CREDIT_CARD,
    DEBIT_CARD,
    PAYPAL,
    APPLE_PAY,
    GOOGLE_PAY,
    BANK_TRANSFER;

    public boolean requiresCardDetails() {
        return this == CREDIT_CARD || this == DEBIT_CARD;
    }
}

