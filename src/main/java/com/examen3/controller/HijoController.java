package com.examen3.controller;

import com.examen3.domain.Hijo;
import com.examen3.domain.Padre;
import com.examen3.services.HijoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/hijo"})
public class HijoController {
    @Autowired
    private HijoService hijoService;

    @GetMapping
    public List getAll(){
        return hijoService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public Optional<Object> findById(@PathVariable long id){

        return hijoService.findById(id);
    }

    @PostMapping
    public Hijo create(@RequestBody Hijo contact){
        return hijoService.save(contact).get();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Hijo> update(@PathVariable("id") long id,
                                        @RequestBody Hijo contact){
        contact.setId(id);
        Optional<Hijo> result = hijoService.update(contact);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
