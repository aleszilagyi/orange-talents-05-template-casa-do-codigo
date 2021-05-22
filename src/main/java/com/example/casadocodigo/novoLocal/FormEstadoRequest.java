package com.example.casadocodigo.novoLocal;

import com.example.casadocodigo.compartilhado.ValueExists;
import com.example.casadocodigo.compartilhado.VerificaEstadoEPais;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Locale;

@VerificaEstadoEPais
public class FormEstadoRequest {
    @NotBlank
    private String nome;
    @NotNull
    @ValueExists(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase(Locale.ROOT);
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public Estado converter(PaisRepository paisRepository) {
        Pais pais = paisRepository.findById(paisId).get();
        return new Estado(nome, pais);
    }

}
