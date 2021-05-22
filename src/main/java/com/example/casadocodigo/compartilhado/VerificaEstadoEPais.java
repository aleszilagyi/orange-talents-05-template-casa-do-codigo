package com.example.casadocodigo.compartilhado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {VerificaEstadoEPaisValidator.class})
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface VerificaEstadoEPais {
    String message() default "estado já cadastrado para o país";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
