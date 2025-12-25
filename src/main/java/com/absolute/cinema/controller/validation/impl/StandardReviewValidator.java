package com.absolute.cinema.controller.validation.impl;

import com.absolute.cinema.common.enums.ValidationLevel;
import com.absolute.cinema.common.enums.ValidationType;
import com.absolute.cinema.entity.Review;
import com.absolute.cinema.controller.validation.Validator;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
class StandardReviewValidator implements Validator<Review> {

    @Override
    public boolean validate(Review review) {
        UUID reviewId = review.getId();
        UUID filmId = review.getFilm().getId();
        UUID userId = review.getClient().getId();

        return reviewId != null && filmId != null && userId != null;
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
