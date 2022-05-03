package com.examen3.services;

import com.examen3.domain.Hijo;
import com.examen3.domain.Padre;
import com.examen3.repositories.HijoRepository;
import com.examen3.repositories.PadreRepository;
import com.google.common.collect.Lists;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class HijoServiceImpl implements HijoService{
    @Autowired
    HijoRepository hijoRepo;

    @Autowired
    PadreRepository padreRepo;


    @Override
    public List<Hijo> getAll() {
        return hijoRepo.findAll();
    }

    @Override
    public Optional<Object> findById(long id) {
        List<Object> listaObjeto = Lists.newArrayList();
        List<Padre> padres = padreRepo.findAll();
        List<Hijo> hijos = getAll();
        String ced = "";

        for (Padre padre : padres){
            if(padre.getId() == id){
                ced = padre.getCedula();

                listaObjeto.add("Padre / Madre");
                listaObjeto.add("Nombre: "+padre.getNombre());
                listaObjeto.add("Cedula: "+padre.getCedula());
                listaObjeto.add("Direccion: "+padre.getDireccion());
                listaObjeto.add("Telefono1: "+padre.getTelefono1());
                listaObjeto.add("Telefono2: "+padre.getTelefono2());
                break;
            }
        }


        for (Hijo hijo : hijos){
            if(hijo.getCedulaPadre().equals(ced)){
                listaObjeto.add("Hijo(s)");
                listaObjeto.add("Nombre: "+hijo.getNombre());
                listaObjeto.add("Alergias: "+hijo.getAlergias());
            }
        }

        return Optional.of(listaObjeto);
    }

    @Override
    public Optional<Hijo> save(Hijo contact) {
        return Optional.of(hijoRepo.save(contact));
    }

    @Override
    public Optional<Hijo> update(Hijo contact) {
        Optional<Hijo> record = hijoRepo.findById(contact.getId());
        if (record.isPresent()) {
            Hijo data = record.get();
            data.setNombre(contact.getNombre());
            data.setAlergias(contact.getAlergias());
            data.setCedulaPadre(contact.getCedulaPadre());

            return Optional.of(hijoRepo.save(data));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        Optional<Hijo> result = hijoRepo.findById(id);
        if (result.isPresent()){
            hijoRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
