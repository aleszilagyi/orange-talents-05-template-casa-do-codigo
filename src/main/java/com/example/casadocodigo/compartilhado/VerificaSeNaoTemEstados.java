package com.example.casadocodigo.compartilhado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {VerificaSeNaoTemEstadosValidator.class})
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface VerificaSeNaoTemEstados {
    String message() default "país não cadastrado, ou possui estado(s) que não foram selecionados";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
