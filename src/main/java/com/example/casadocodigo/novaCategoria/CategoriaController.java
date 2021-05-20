package com.example.casadocodigo.novaCategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid FormCategoriaRequest request) {

        Categoria novaCategoria = request.converter();
        categoriaRepository.save(novaCategoria);

        return ResponseEntity.ok(new CategoriaDto(novaCategoria));

    }

}
