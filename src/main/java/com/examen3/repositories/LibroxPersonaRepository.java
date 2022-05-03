package com.examen3.repositories;

import com.examen3.domain.Hijo;
import com.examen3.domain.LibroxPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroxPersonaRepository extends JpaRepository<LibroxPersona, Long> {
}
