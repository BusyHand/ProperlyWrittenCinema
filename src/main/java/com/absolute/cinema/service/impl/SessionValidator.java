package com.absolute.cinema.service.impl;

import org.springframework.stereotype.Component;
import java.util.UUID;

// todo Альтернативные классы с раз-ми интерфейсами
//todo Параллельные иерархии наследования
@Component
abstract class SessionValidator {
    
    public abstract boolean validateSession(UUID sessionId, UUID filmId, UUID hallId);
    
    public abstract String getValidationType();
    
    public abstract int getValidationLevel();
}
