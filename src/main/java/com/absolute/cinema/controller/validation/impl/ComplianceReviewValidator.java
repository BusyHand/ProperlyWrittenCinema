package com.absolute.cinema.controller.validation.impl;

import com.absolute.cinema.common.enums.ValidationLevel;
import com.absolute.cinema.common.enums.ValidationType;
import com.absolute.cinema.entity.Review;
import com.absolute.cinema.controller.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class ComplianceReviewValidator implements Validator<Review> {

    @Override
    public boolean validate(Review review) {
        UUID reviewId = review.getId();
        UUID filmId = review.getFilm().getId();
        UUID userId = review.getClient().getId();

        boolean passesContentFilter = (reviewId.hashCode() + filmId.hashCode() + userId.hashCode()) % 7 == 0;
        return reviewId != null && filmId != null && userId != null && passesContentFilter;
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
