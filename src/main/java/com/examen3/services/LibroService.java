package com.examen3.services;

import com.examen3.domain.Libro;
import net.bytebuddy.dynamic.DynamicType;

import java.util.List;
import java.util.Optional;

public interface LibroService {
    public List<Object> getAll();
    public List<Libro> findById(long id);
    public  Optional<Libro> save(Libro contact);
    public List<Libro> getAllLibros();

}
