package com.example.casadocodigo.novaCategoria;

public class CategoriaDto {
    private String nome;

    public CategoriaDto(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
