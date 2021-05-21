package com.example.casadocodigo.novoLocal;

import com.example.casadocodigo.exceptions.FieldErrorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/paises")
@Validated
public class LocalizacaoController {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<PaisDto> cadastrar(@RequestBody @Valid FormPaisRequest request) {
        Pais pais = request.converter();
        paisRepository.save(pais);

        return ResponseEntity.ok(new PaisDto(pais));
    }

    @PostMapping("/{pais}")
    @Transactional
    public ResponseEntity<?> cadastrarEstado(@PathVariable("pais") String pais, @RequestBody @Valid FormEstadoRequest request) {
        Optional<Pais> talvezPaisExista = paisRepository.findByNomeIgnoreCase(pais);
        if (talvezPaisExista.isPresent()) {
            Optional<Estado> talvezExisteEstadoComMesmoNomeNoPais = estadoRepository.findByNomeAndPaisId(request.getNome(), talvezPaisExista.get().getId());
            if (talvezExisteEstadoComMesmoNomeNoPais.isEmpty()) {
                Estado estado = request.converter(talvezPaisExista.get());
                estadoRepository.save(estado);

                return ResponseEntity.ok(new EstadoDto(estado));
            }
            return ResponseEntity.badRequest().body(new FieldErrorOutputDto("nome",
                    talvezExisteEstadoComMesmoNomeNoPais.get().getNome() + " já cadastrado para o país: " + pais));
        }
        return ResponseEntity.badRequest().body(new FieldErrorOutputDto("pais", pais + " não está cadasrado"));
    }
}
