package com.example.casadocodigo.novoAutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid FormAutorRequest form) {
        Autor autor = form.converter();
        autorRepository.save(autor);

        return ResponseEntity.ok(new AutorDto(autor));
    }

}
