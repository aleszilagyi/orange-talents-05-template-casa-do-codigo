package com.example.casadocodigo.compartilhado;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsNullValidator implements ConstraintValidator<IsNull, Object> {
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return value == null;
    }
}
