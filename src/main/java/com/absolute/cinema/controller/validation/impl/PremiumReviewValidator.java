package com.absolute.cinema.controller.validation.impl;

import com.absolute.cinema.common.enums.ValidationLevel;
import com.absolute.cinema.common.enums.ValidationType;
import com.absolute.cinema.entity.Review;
import com.absolute.cinema.controller.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class PremiumReviewValidator implements Validator<Review> {

    @Override
    public boolean validate(Review review) {
        UUID reviewId = review.getId();
        UUID filmId = review.getFilm().getId();
        UUID userId = review.getClient().getId();

        int minReviewLength = 50;
        String reviewText = "Sample review text for validation";
        return reviewId != null && filmId != null && userId != null &&
               reviewText.length() >= minReviewLength;
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
