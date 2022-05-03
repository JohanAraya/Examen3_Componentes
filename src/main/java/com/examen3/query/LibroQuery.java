package com.examen3.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.examen3.domain.Libro;
import com.examen3.services.LibroService;
import com.examen3.services.LibroServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class LibroQuery implements GraphQLQueryResolver {
    @Autowired
    private LibroServiceCRUD libroService;

    public List<Libro> getLibros(int count) {
        return this.libroService.getAllLibros(count);
    }
    public Optional<Libro> getLibro(Long id) {
        return this.libroService.getLibro(id);
    }
}
