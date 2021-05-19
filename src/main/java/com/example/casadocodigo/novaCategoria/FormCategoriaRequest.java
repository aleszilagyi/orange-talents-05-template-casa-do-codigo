package com.example.casadocodigo.novaCategoria;

import com.example.casadocodigo.compartilhado.UniqueValue;
import com.example.casadocodigo.novoAutor.Autor;

import javax.validation.constraints.NotBlank;

public class FormCategoriaRequest {
    @NotBlank
    @UniqueValue
            (domainClass = Categoria.class, fieldName = "nome")
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
