package com.example.casadocodigo.novoLocal;

public class EstadoDto {
    private Long id;
    private String nome;
    private Pais pais;

    public EstadoDto(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.pais = estado.getPais();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public PaisDto getPais() {
        return new PaisDto(pais);
    }
}
