package com.example.casadocodigo.novaCategoria;

import javax.validation.constraints.NotBlank;

public class FormCategoriaRequest {
    @NotBlank
    @UniqueCategoria
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria converter() {
        return new Categoria(nome);
    }
}
