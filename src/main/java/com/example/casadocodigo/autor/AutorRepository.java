package com.example.casadocodigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<AutorEntidade, Long> {
    Optional<AutorEntidade> findByEmail(String email);
}
