package com.examen3.services;

import com.examen3.domain.Hijo;
import com.examen3.domain.Padre;

import java.util.List;
import java.util.Optional;

public interface HijoService {
    public List<Hijo> getAll();
    public Optional<Object> findById(long id);
    public  Optional<Hijo> save(Hijo contact);
    public  Optional<Hijo> update(Hijo contact);
    public boolean delete(Long id);

}
