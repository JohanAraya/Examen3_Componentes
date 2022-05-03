package com.examen3.controller;

import com.examen3.domain.Padre;
import com.examen3.services.PadreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/padre"})
public class PadreController {
    @Autowired
    private PadreService padreService;

    @GetMapping
    public List getAll(){
        return padreService.getAll();
    }


    @GetMapping(path = {"/{nombre}"})
    public List getAllName(@PathVariable String nombre){

        return padreService.getAllName(nombre);
    }


    @PostMapping
    public Padre create(@RequestBody Padre contact){
        return padreService.save(contact).get();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Padre> update(@PathVariable("id") long id,
                                          @RequestBody Padre contact){
        contact.setId(id);
        Optional<Padre> result = padreService.update(contact);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (padreService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
