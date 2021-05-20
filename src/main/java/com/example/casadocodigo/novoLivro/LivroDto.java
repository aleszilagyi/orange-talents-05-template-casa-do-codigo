package com.example.casadocodigo.novoLivro;

import com.example.casadocodigo.novaCategoria.Categoria;
import com.example.casadocodigo.novoAutor.Autor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class LivroDto {
    private Long id;
    private String titulo;
    private String sumario;
    private BigDecimal preco;
    private int numPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private Categoria categoria;
    private List<Autor> autores;

    public LivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numPaginas = livro.getNumPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.categoria = livro.getCategoria();
        this.autores = livro.getAutores();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public List<Autor> getAutores() {
        return autores;
    }
}
