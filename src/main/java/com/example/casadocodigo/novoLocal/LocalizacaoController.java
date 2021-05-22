package com.example.casadocodigo.novoLocal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class LocalizacaoController {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PaisRepository paisRepository;

    @PostMapping("/paises")
    @Transactional
    public ResponseEntity<PaisDto> cadastrar(@RequestBody @Valid FormPaisRequest request) {
        Pais pais = request.converter();
        paisRepository.save(pais);

        return ResponseEntity.ok(new PaisDto(pais));
    }

    @PostMapping("/estados")
    @Transactional
    public ResponseEntity<EstadoDto> cadastrarEstado(@RequestBody @Valid FormEstadoRequest request) {

        Estado estado = request.converter(paisRepository);
        estadoRepository.save(estado);

        return ResponseEntity.ok(new EstadoDto(estado));
    }
}