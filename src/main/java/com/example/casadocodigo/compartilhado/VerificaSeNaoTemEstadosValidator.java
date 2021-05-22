package com.example.casadocodigo.compartilhado;

import com.example.casadocodigo.novoCliente.FormClienteRequest;
import com.example.casadocodigo.novoLocal.Estado;
import com.example.casadocodigo.novoLocal.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class VerificaSeNaoTemEstadosValidator implements ConstraintValidator<VerificaSeNaoTemEstados, FormClienteRequest> {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public boolean isValid(FormClienteRequest value, ConstraintValidatorContext context) {
        Optional<Estado> talvezPaisTemEstado = estadoRepository.findByPaisId(value.getPaisId());
        Optional<String> talvezEstadoNome = Optional.ofNullable(value.getEstadoNome());
        if (talvezPaisTemEstado.isPresent()) {
            if (talvezEstadoNome.isPresent()) {
                Optional<Estado> talvezEstadoNoPais = estadoRepository.findByNomeAndPaisId(value.getEstadoNome(), value.getPaisId());
                return talvezEstadoNoPais.isPresent();
            }
            return false;
        }
        return talvezEstadoNome.isEmpty();
    }
}
