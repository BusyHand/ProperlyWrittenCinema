package com.absolute.cinema.controller.validation.impl;

import com.absolute.cinema.common.enums.ValidationLevel;
import com.absolute.cinema.common.enums.ValidationType;
import com.absolute.cinema.dto.PaymentPurchase;
import com.absolute.cinema.controller.validation.Validator;
import org.springframework.stereotype.Component;

@Component
class StandardPaymentValidator implements Validator<PaymentPurchase> {

    @Override
    public boolean validate(PaymentPurchase paymentPurchase) {
        int amountCents = paymentPurchase.amount();

        return amountCents > 0 && amountCents < 999999999;
    }


    @Override
    public ValidationType getValidationType() {
        return ValidationType.STANDARD;
    }

    @Override
    public ValidationLevel getValidationLevel() {
        return ValidationLevel.ONE;
    }
}
