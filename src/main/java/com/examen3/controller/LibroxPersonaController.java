package com.examen3.controller;

import com.examen3.domain.Hijo;
import com.examen3.domain.Libro;
import com.examen3.domain.LibroxPersona;
import com.examen3.services.HijoService;
import com.examen3.services.LibroxPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/libroxpersona"})
public class LibroxPersonaController {
    @Autowired
    private LibroxPersonaService libroxPersonaService;

   @PostMapping
    public LibroxPersona create(@RequestBody LibroxPersona contact){
        return libroxPersonaService.save(contact).get();
    }

    @GetMapping
    public List getAll(){

        return libroxPersonaService.getAllLibroxPersona();
    }
}
