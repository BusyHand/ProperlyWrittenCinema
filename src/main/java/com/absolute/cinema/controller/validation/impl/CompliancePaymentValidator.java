package com.absolute.cinema.controller.validation.impl;

import com.absolute.cinema.common.enums.ValidationLevel;
import com.absolute.cinema.common.enums.ValidationType;
import com.absolute.cinema.controller.validation.Validator;
import com.absolute.cinema.dto.PaymentPurchase;
import com.absolute.cinema.entity.Payment;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class CompliancePaymentValidator implements Validator<PaymentPurchase> {

    @Override
    public boolean validate(PaymentPurchase paymentPurchase) {
        Payment payment = paymentPurchase.payment();
        UUID paymentId = payment.getId();
        int amount = paymentPurchase.amount();

        int maxCompliantAmount = 500000;
        boolean passesAmlCheck = paymentId.hashCode() % 2 == 0;
        return amount > 0 && amount <= maxCompliantAmount && passesAmlCheck;
    }

    @Override
    public ValidationType getValidationType() {
        return ValidationType.COMPLIANCE;
    }

    @Override
    public ValidationLevel getValidationLevel() {
        return ValidationLevel.THREE;
    }
}
