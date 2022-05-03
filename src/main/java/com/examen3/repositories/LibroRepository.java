package com.examen3.repositories;

import com.examen3.domain.Hijo;
import com.examen3.domain.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
