package com.examen3.services;

import com.examen3.domain.Hijo;
import com.examen3.domain.LibroxPersona;
import com.examen3.repositories.HijoRepository;
import com.examen3.repositories.LibroxPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroxPersonaSeviceImpl implements LibroxPersonaService{
    @Autowired
    LibroxPersonaRepository libroxPersonaRepo;
    @Override
    public Optional<LibroxPersona> save(LibroxPersona contact) {
        return Optional.of(libroxPersonaRepo.save(contact));
    }

    @Override
    public List<LibroxPersona> getAllLibroxPersona() {

        return libroxPersonaRepo.findAll();
    }
}
