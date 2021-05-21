package com.example.casadocodigo.novoLocal;

import com.example.casadocodigo.compartilhado.UniqueValue;

import javax.validation.constraints.NotBlank;
import java.util.Locale;

public class FormPaisRequest {
    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(@NotBlank @UniqueValue(domainClass = Pais.class, fieldName = "nome") String nome) {
        this.nome = nome.toUpperCase(Locale.ROOT);
    }

    public Pais converter() {
        return new Pais(nome);
    }
}
