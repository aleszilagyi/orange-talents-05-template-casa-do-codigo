package com.example.casadocodigo.novaCategoria;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {UniqueCategoriaValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueCategoria {
    String message() default "Categoria já cadastrada";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
