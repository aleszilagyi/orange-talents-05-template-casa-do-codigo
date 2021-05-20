package com.example.casadocodigo.novoLivro;

import com.example.casadocodigo.compartilhado.ParamsExist;
import com.example.casadocodigo.compartilhado.UniqueValue;
import com.example.casadocodigo.novaCategoria.Categoria;
import com.example.casadocodigo.novoAutor.Autor;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FormLivroRequest {
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
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
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;
    @NotNull
    @ManyToOne
    @ParamsExist(domainClass = Categoria.class, fieldName = "nome")
    private String categoria;
    @ManyToMany
    private List<@NotBlank @ParamsExist(domainClass = Autor.class, fieldName = "nome")
            String> autores;

    public FormLivroRequest(String titulo, String sumario, BigDecimal preco, int numPaginas, String isbn, String categoria) {
        this.titulo = titulo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.categoria = categoria;
    }

    // Bug maldito que não deixava desserializar o Json de data, setter parece ser necessário, não remover
    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    //Manter este getter para eitar bug na validaçao
    public List<String> getAutores() {
        return autores;
    }

    // Mais um bug
    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public Livro converter(EntityManager manager) {
        Query queryCategoria = manager.createQuery("select c from Categoria c where c.nome = :categoria");
        queryCategoria.setParameter("categoria", categoria);
        List<Categoria> lista = (List<Categoria>) queryCategoria.getResultList();
        Categoria categoriaListada = lista.get(0);

        List<Autor> listaAutores = new ArrayList<>();
        for (String autor : autores) {
            Query queryAutor = manager.createQuery("select a from Autor a where a.nome = :autor");
            queryAutor.setParameter("autor", autor);
            listaAutores.addAll(queryAutor.getResultList());
        }

        return new Livro(titulo, sumario, preco, numPaginas, isbn, dataPublicacao, categoriaListada, listaAutores);
    }
}
