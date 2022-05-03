package com.examen3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class LibroxPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idHijo;
    private Long idLibro;

    public LibroxPersona() {
    }

    public LibroxPersona(Long id, Long idHijo, Long idLibro) {
        this.id = id;
        this.idHijo = idHijo;
        this.idLibro = idLibro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdHijo() {
        return idHijo;
    }

    public void setIdHijo(Long idHijo) {
        this.idHijo = idHijo;
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }
}
