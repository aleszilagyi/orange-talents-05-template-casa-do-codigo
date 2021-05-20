package com.example.casadocodigo.novoLivro;

import com.example.casadocodigo.novaCategoria.CategoriaRepository;
import com.example.casadocodigo.novoAutor.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid FormLivroRequest request) {
        Livro livro = request.converter(categoriaRepository, autorRepository);
        livroRepository.save(livro);

        return ResponseEntity.ok(new LivroDto(livro));
    }

    @GetMapping
    public Page<LivroDto> listarTodos(@PageableDefault(sort = "titulo", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        Page<Livro> livros = livroRepository.findAll(paginacao);
        return LivroDto.converter(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalhesDto> detalhar(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if(livro.isPresent()){
            return ResponseEntity.ok(new LivroDetalhesDto(livro.get()));
        }
        return ResponseEntity.notFound().build();
    }

}