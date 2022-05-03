package com.examen3.services;

import com.examen3.domain.Padre;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PadreService {
    public List<Padre> getAll();
    public Optional<Padre> findByName(String nombre);
    public Optional<Padre> findById(long id);
    public  Optional<Padre> save(Padre contact);
    public  Optional<Padre> update(Padre contact);
    public boolean delete(Long id);
    public List<Padre>getAllName(String nombre);
}
