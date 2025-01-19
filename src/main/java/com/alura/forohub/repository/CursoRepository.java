package com.alura.forohub.repository;

import com.alura.forohub.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, JpaRepository> {
    Optional<Curso> findByNombre(String nombre);
}
