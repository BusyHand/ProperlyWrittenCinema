package com.absolute.cinema.controller.validation.impl;

import com.absolute.cinema.common.enums.ValidationLevel;
import com.absolute.cinema.common.enums.ValidationType;
import com.absolute.cinema.entity.Session;
import com.absolute.cinema.controller.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class PremiumSessionValidator implements Validator<Session> {

    @Override
    public boolean validate(Session session) {
        UUID sessionId = session.getId();
        UUID filmId = session.getFilm().getId();
        UUID hallId = session.getHall().getId();

        int minHallCapacityForPremium = 50;
        return sessionId != null && filmId != null && hallId != null &&
               hallId.hashCode() % minHallCapacityForPremium == 0;
    }

    @Override
    public ValidationType getValidationType() {
        return ValidationType.PREMIUM;
    }

    @Override
    public ValidationLevel getValidationLevel() {
        return ValidationLevel.TWO;
    }
}
