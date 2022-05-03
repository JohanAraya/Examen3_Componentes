package com.examen3.services;

import antlr.collections.impl.Vector;
import com.examen3.domain.Padre;
import com.examen3.repositories.PadreRepository;
import com.google.common.collect.Lists;
import org.apache.xbean.propertyeditor.LinkedListEditor;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PadreServiceImpl implements PadreService{
    @Autowired
    PadreRepository padreRepo;

    @Override
    public List<Padre> getAll() {
        return padreRepo.findAll();
    }

    @Override
    public Optional<Padre> findById(long id) {
        return padreRepo.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }
    @Override
    public Optional<Padre> findByName(String nombre) {
        return null;
    }

    @Override
    public  Optional<Padre> save(Padre padre) {
        return Optional.of(padreRepo.save(padre));
    }

    @Override
    public  Optional<Padre> update(Padre padre) {
        Optional<Padre> record = padreRepo.findById(padre.getId());
        if (record.isPresent()) {
            Padre data = record.get();
            data.setNombre(padre.getNombre());
            data.setCedula(padre.getCedula());
            data.setDireccion(padre.getDireccion());
            data.setTelefono1(padre.getTelefono1());
            data.setTelefono2(padre.getTelefono2());
            return Optional.of(padreRepo.save(data));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        Optional<Padre> result = padreRepo.findById(id);
        if (result.isPresent()){
            padreRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Padre> getAllName(String nombre) {
        List<Padre> data = Lists.newArrayList();
        List<Padre> record = getAll();

        for (Padre p : record){
            if(p.getNombre().contains(nombre)){
                data.add(p);
            }
        }

        return data;
    }
}
