package com.absolute.cinema.controller.validation;

import com.absolute.cinema.common.enums.ValidationLevel;
import com.absolute.cinema.common.enums.ValidationType;

public interface Validator<T> {

    boolean validate(T context);

    ValidationType getValidationType();

    ValidationLevel getValidationLevel();
}
