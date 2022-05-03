package com.examen3.services;

import com.examen3.domain.Hijo;
import com.examen3.domain.Libro;
import com.examen3.domain.LibroxPersona;
import com.examen3.repositories.HijoRepository;
import com.examen3.repositories.LibroRepository;
import com.examen3.repositories.LibroxPersonaRepository;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.collection.immutable.HashMap;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {
    @Autowired
    LibroRepository libroRepo;

    @Autowired
    HijoRepository hijoRepo;

    @Autowired
    LibroxPersonaRepository libroxPersonaRepo;

    @Override
    public List<Object> getAll() {


        int cant;
        List<Object> listaObjeto = Lists.newArrayList();
        List<Hijo> hijos = hijoRepo.findAll();
        List<LibroxPersona> librosxPersona = libroxPersonaRepo.findAll();
        List<Libro> libros = getAllLibros();

        for (Hijo h : hijos){
            cant = 0;
            for(LibroxPersona l : librosxPersona){
                if (h.getId() == l.getIdHijo()){
                    cant++;
                }


            }
            listaObjeto.add("Nombre: " + h.getNombre());
            listaObjeto.add("Cantidad de libros leidos: " + cant);

        }

        return listaObjeto;
    }

    @Override
    public List<Libro> getAllLibros() {

        return libroRepo.findAll();
    }



    @Override
    public List<Libro> findById(long id) {
        List<Libro> listaObjeto = Lists.newArrayList();

        List<LibroxPersona> librosxPersona = libroxPersonaRepo.findAll();
        List<Libro> libros = libroRepo.findAll();


        for (LibroxPersona lxP : librosxPersona){
            for(Libro l : libros){
                if(lxP.getIdHijo() == (id) && lxP.getIdLibro() == l.getId()){
                    listaObjeto.add(l);

                }

            }
        }


        return listaObjeto;
    }

    @Override
    public Optional<Libro> save(Libro contact) {
        if(contact.getEstado().equals(null) || contact.getEstado().equals("")){
            contact.setEstado("Activo");
        }
        return Optional.of(libroRepo.save(contact));
    }





}
