package com.example.casadocodigo.compartilhado;

import com.example.casadocodigo.novoLocal.Estado;
import com.example.casadocodigo.novoLocal.EstadoRepository;
import com.example.casadocodigo.novoLocal.FormEstadoRequest;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class VerificaEstadoEPaisValidator implements ConstraintValidator<VerificaEstadoEPais, FormEstadoRequest> {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public boolean isValid(FormEstadoRequest value, ConstraintValidatorContext context) {
        Optional<Estado> talvezEstado = estadoRepository.findByNomeAndPaisId(value.getNome(), value.getPaisId());
        return talvezEstado.isEmpty();
    }
}
