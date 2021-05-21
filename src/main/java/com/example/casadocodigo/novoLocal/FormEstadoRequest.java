package com.example.casadocodigo.novoLocal;

import javax.validation.constraints.NotBlank;
import java.util.Locale;

public class FormEstadoRequest {
    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase(Locale.ROOT);
    }

    public Estado converter(Pais pais) {
        return new Estado(nome, pais);
    }

}
