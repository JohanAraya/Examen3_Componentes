package com.examen3.controller;

import com.examen3.domain.Hijo;
import com.examen3.domain.Libro;
import com.examen3.services.HijoService;
import com.examen3.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/libro"})
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public List getAll(){

        return libroService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public List<Libro> findById(@PathVariable long id){

        return libroService.findById(id);
    }

    @PostMapping
    public Libro create(@RequestBody Libro contact){

        return libroService.save(contact).get();
    }
}
