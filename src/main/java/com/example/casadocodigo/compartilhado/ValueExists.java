package com.example.casadocodigo.compartilhado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {ValueExistsValidator.class})
@Target(value = {ElementType.FIELD, ElementType.TYPE_USE, ElementType.TYPE_PARAMETER, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValueExists {
    String message() default "{fieldName} fornecido não está cadastrado como ${domainClass.getSimpleName()}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
}
