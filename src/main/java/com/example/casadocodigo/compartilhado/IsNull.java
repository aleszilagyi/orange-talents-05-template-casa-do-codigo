package com.example.casadocodigo.compartilhado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {IsNullValidator.class})
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IsNull {
    String message() default "o valor não é nulo";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
