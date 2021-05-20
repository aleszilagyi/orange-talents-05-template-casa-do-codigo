package com.example.casadocodigo.novoLivro;

import com.example.casadocodigo.compartilhado.ParamsExist;
import com.example.casadocodigo.compartilhado.UniqueValue;
import com.example.casadocodigo.novaCategoria.Categoria;
import com.example.casadocodigo.novaCategoria.CategoriaRepository;
import com.example.casadocodigo.novoAutor.Autor;
import com.example.casadocodigo.novoAutor.AutorRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
    @ParamsExist(domainClass = Categoria.class, fieldName = "id")
    private Long categoria;
    @ManyToMany
    private List<@NotNull @ParamsExist(domainClass = Autor.class, fieldName = "id")
            Long> autores;

    public FormLivroRequest(String titulo, String sumario, BigDecimal preco, int numPaginas, String isbn, Long categoria) {
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

    //Manter este getter para evitar bug na validaçao
    public List<Long> getAutores() {
        return autores;
    }

    // Mais um bug, manter para evitar erro na validação dos autores
    public void setAutores(List<Long> autores) {
        this.autores = autores;
    }

    public Livro converter(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
        Categoria categoriaListada = (Categoria) categoriaRepository.findById(categoria).get();

        List<Autor> listaAutores = autores.stream().map(autor -> (Autor) autorRepository.findById(autor).get()).collect(Collectors.toList());

        return new Livro(titulo, sumario, preco, numPaginas, isbn, dataPublicacao, categoriaListada, listaAutores);
    }
}
