package com.example.casadocodigo.novoLivro;

import org.springframework.data.domain.Page;

public class LivroDto {
    private Long id;
    private String titulo;

    public LivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    static Page<LivroDto> converter(Page<Livro> livros) {
        return livros.map(LivroDto::new);
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}