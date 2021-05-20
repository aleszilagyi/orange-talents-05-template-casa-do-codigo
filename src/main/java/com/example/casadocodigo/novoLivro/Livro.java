package com.example.casadocodigo.novoLivro;

import com.example.casadocodigo.novaCategoria.Categoria;
import com.example.casadocodigo.novoAutor.Autor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 500)
    private String titulo;
    @NotBlank
    private String sumario;
    @NotNull
    @DecimalMin(value = "20.00", inclusive = true)
    private BigDecimal preco;
    @NotNull
    @Min(100)
    private int numPaginas;
    @NotBlank
    private String isbn;
    @NotNull
    @Future
    private LocalDate dataPublicacao;
    @NotNull
    @ManyToOne
    private Categoria categoria;
    @NotNull
    @ManyToMany
    private List<@NotNull Autor> autores;

    @Deprecated
    public Livro() {
    }

    public Livro(String titulo, String sumario, BigDecimal preco, int numPaginas, String isbn, LocalDate dataPublicacao, Categoria categoria, List<Autor> autores) {
        this.titulo = titulo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autores = autores;
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
