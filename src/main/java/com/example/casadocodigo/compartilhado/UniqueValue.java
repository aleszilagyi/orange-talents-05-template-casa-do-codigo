package com.example.casadocodigo.compartilhado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({ElementType.FIELD, ElementType.TYPE_USE, ElementType.TYPE_PARAMETER, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueValue {
    String message() default "{fieldName} fornecido já está cadastrado para ${domainClass.getSimpleName()}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
}
