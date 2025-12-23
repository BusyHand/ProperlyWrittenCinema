package com.absolute.cinema.service.impl;

import org.springframework.stereotype.Component;
import java.util.UUID;
// todo Альтернативные классы с раз-ми интерфейсами
//todo Параллельные иерархии наследования
//todo Параллельные иерархии наследования
@Component
abstract class ReviewValidatorV2 {
    
    public abstract boolean validateReview(UUID reviewId, UUID filmId, UUID userId);
    
    public abstract String getValidationType();
    
    public abstract int getValidationLevel();
}
