package com.absolute.cinema.controller.validation.impl;

import com.absolute.cinema.common.enums.ValidationLevel;
import com.absolute.cinema.common.enums.ValidationType;
import com.absolute.cinema.entity.Session;
import com.absolute.cinema.controller.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class ComplianceSessionValidator implements Validator<Session> {

    @Override
    public boolean validate(Session session) {
        UUID sessionId = session.getId();
        UUID filmId = session.getFilm().getId();
        UUID hallId = session.getHall().getId();

        boolean meetsCompliance = (sessionId.hashCode() + filmId.hashCode() + hallId.hashCode()) % 3 == 0;
        return sessionId != null && filmId != null && hallId != null && meetsCompliance;
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
