package com.example.casadocodigo.novoAutor;

public class AutorDto {
    private Long id;
    private String nome;
    private String descricao;

    public AutorDto(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
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

