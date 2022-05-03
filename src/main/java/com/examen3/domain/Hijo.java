package com.examen3.domain;

import javax.annotation.Nullable;
import javax.persistence.*;

@Entity
public class Hijo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String alergias;
    private String cedulaPadre;
    @Column(nullable = true)
    private int cant;

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public Hijo() {
    }

    public Hijo(Long id, String nombre, String alergias, String cedulaPadre) {
        this.id = id;
        this.nombre = nombre;
        this.alergias = alergias;
        this.cedulaPadre = cedulaPadre;
    }

    public Hijo(String nombre, int cant) {
        this.nombre = nombre;
        this.cant = cant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getCedulaPadre() {
        return cedulaPadre;
    }

    public void setCedulaPadre(String cedulaPadre) {
        this.cedulaPadre = cedulaPadre;
    }
}
