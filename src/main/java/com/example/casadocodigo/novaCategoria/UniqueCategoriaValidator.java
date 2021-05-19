package com.example.casadocodigo.novaCategoria;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCategoriaValidator implements ConstraintValidator<UniqueCategoria, String> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext context) {
        return categoriaRepository.findByNome(nome).isEmpty();
    }
}
