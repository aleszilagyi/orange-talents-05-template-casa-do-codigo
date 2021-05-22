package com.example.casadocodigo.novoCliente;

import com.example.casadocodigo.novoLocal.EstadoRepository;
import com.example.casadocodigo.novoLocal.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class ClienteController {
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/clientes")
    @Transactional
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid FormClienteRequest request) {
        Cliente cliente = request.converter(paisRepository, estadoRepository);
        clienteRepository.save(cliente);

        return ResponseEntity.ok(new ClienteDto(cliente));
    }
}
