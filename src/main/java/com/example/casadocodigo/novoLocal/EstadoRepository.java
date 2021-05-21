package com.example.casadocodigo.novoLocal;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Optional<Estado> findByNomeAndPaisId(String nome, Long paisId);
}
