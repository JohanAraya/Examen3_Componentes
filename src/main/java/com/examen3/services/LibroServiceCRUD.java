package com.examen3.services;

import com.examen3.domain.Libro;
import com.examen3.repositories.LibroRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroServiceCRUD {
    @Autowired
    LibroRepository libroRepo;

    public List<Libro> getAllLibros(int count) {
        List<Libro> listaObjeto = Lists.newArrayList();
        List<Libro> libros = this.libroRepo.findAll().stream().limit(count).collect(Collectors.toList());

        for (Libro l : libros){
            if(l.getEstado().equals("Activo")){
                listaObjeto.add(l);
            }

        }


        return listaObjeto;
    }

    public Optional<Libro> getLibro(Long id) {
        return this.libroRepo.findById(id);
    }

    public Libro createLibro(String nombre) {

        Libro libro = new Libro();
        libro.setNombre(nombre);

        libro.setEstado("Activo");
        return this.libroRepo.save(libro);
    }

    public Optional<Libro> updateLibro(Long id, String nombre) {
        Optional<Libro> record = libroRepo.findById(id);
        if (record.isPresent()) {
            Libro data = record.get();
            data.setNombre(nombre);

            data.setEstado("Activo");
            return Optional.of(libroRepo.save(data));
        }
        return Optional.empty();
    }

    public Optional<Libro> deleteLibro(Long id) {
        Optional<Libro> record = libroRepo.findById(id);
        if (record.isPresent()) {
            Libro data = record.get();
            data.setEstado("Inactivo");
            return Optional.of(libroRepo.save(data));
        }
        return Optional.empty();
    }

}
