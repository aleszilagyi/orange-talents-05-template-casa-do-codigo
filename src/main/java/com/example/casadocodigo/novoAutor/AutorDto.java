package com.example.casadocodigo.novoAutor;

public class AutorDto {
    private Long id;
    private String email;
    private String nome;
    private String descricao;

    public AutorDto(Autor autor) {
        this.id = autor.getId();
        this.email = autor.getEmail();
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
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

    public String getDescricao() {
        return descricao;
    }
}

