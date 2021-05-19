package com.example.casadocodigo.novoAutor;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {UniqueEmailValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueEmail {
    String message() default "Endereço de e-mail já cadastrado em outro autor";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
