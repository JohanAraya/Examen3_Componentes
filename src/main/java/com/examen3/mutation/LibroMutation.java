package com.examen3.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.examen3.domain.Libro;
import com.examen3.services.LibroServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LibroMutation  implements GraphQLMutationResolver {

    @Autowired
    private LibroServiceCRUD libroService;

    public Libro createLibro(String nombre) {
        return this.libroService.createLibro(nombre);
    }

    public Optional<Libro> updateLibro(Long id, String nombre) {
        return this.libroService.updateLibro(id,nombre);
    }

    public Optional<Libro> deleteLibro(Long id) {
        return this.libroService.deleteLibro(id);
    }

}
