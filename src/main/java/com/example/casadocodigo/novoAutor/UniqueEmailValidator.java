package com.example.casadocodigo.novoAutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return autorRepository.findByEmail(email).isEmpty();
    }
}
