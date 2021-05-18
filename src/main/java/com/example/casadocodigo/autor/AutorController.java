package com.example.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private EmailUnicoValidator emailUnicoValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(emailUnicoValidator);
    }

    @PostMapping("/autores")
    @Transactional
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid FormDto form) {
        AutorEntidade autor = form.converter();
        autorRepository.save(autor);
        System.out.println(autor.getId());

        return ResponseEntity.ok(new AutorDto(autor));
    }

}
