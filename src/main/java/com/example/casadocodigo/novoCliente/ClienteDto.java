package com.example.casadocodigo.novoCliente;

public class ClienteDto {
    private Long id;

    public ClienteDto(Cliente cliente) {
        this.id = cliente.getId();
    }

    public Long getId() {
        return id;
    }
}
