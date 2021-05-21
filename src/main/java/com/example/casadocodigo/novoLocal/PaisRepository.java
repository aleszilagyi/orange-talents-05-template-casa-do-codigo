package com.example.casadocodigo.novoLocal;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais, Long> {
    Optional<Pais> findByNomeIgnoreCase(String pais);
}
