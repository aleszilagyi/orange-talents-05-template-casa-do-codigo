package com.example.casadocodigo.novoCliente;

import com.example.casadocodigo.novoLocal.Estado;
import com.example.casadocodigo.novoLocal.Pais;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    @Column(unique = true)
    private String sobrenome;
    @NotBlank
    @Column(unique = true)
    private String documento;
    @NotBlank
    private String logradouro;
    @NotNull
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ManyToOne
    private Pais pais;
    @ManyToOne
    private Estado estado;
    @NotBlank
    @Size(max = 20)
    private String telefone;
    @NotBlank
    @Size(max = 10)
    private String cep;
    @CreationTimestamp
    private LocalDateTime momentoCriacao;

    public Cliente() {
    }

    public Cliente(String email, String nome, String sobrenome, String documento, String logradouro, String complemento, String cidade, Pais pais, Estado estado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public LocalDateTime getMomentoCriacao() {
        return momentoCriacao;
    }
}
