package com.example.casadocodigo.autor;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class AutorEntidade {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String nome;
    private String email;
    private String descricao;
    private @CreationTimestamp LocalDateTime momentoCriacao;

    public AutorEntidade(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
