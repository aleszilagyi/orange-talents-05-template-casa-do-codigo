package com.example.casadocodigo.novaCategoria;

public class CategoriaDto {
    private final String nome;

    public CategoriaDto(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
