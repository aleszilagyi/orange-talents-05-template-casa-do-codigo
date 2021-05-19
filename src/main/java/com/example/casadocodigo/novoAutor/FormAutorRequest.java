package com.example.casadocodigo.novoAutor;

import com.example.casadocodigo.compartilhado.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FormAutorRequest {
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @UniqueValue
            (domainClass = Autor.class, fieldName = "email")
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public FormAutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor converter() {
        return new Autor(nome, email, descricao);
    }
}
