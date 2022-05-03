package com.examen3.services;

import com.examen3.domain.Hijo;
import com.examen3.domain.LibroxPersona;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface LibroxPersonaService {
    public Optional<LibroxPersona> save(LibroxPersona contact);
    public List<LibroxPersona> getAllLibroxPersona();
}
