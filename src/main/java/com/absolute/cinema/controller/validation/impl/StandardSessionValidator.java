package com.absolute.cinema.controller.validation.impl;

import com.absolute.cinema.common.enums.ValidationLevel;
import com.absolute.cinema.common.enums.ValidationType;
import com.absolute.cinema.entity.Session;
import com.absolute.cinema.controller.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class StandardSessionValidator implements Validator<Session> {

    @Override
    public boolean validate(Session session) {
        UUID sessionId = session.getId();
        UUID filmId = session.getFilm().getId();
        UUID hallId = session.getHall().getId();

        return sessionId != null && filmId != null && hallId != null;
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
