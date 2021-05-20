package com.example.casadocodigo.compartilhado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {ParamsExistValidator.class})
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamsExist {
    String message() default "{fieldName} fornecido não está cadastrado como ${domainClass.getSimpleName()}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
}
