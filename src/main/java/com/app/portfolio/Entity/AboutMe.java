package com.app.portfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AboutMe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imagenMi;
    private String nombreAbout;
    private String descripcionAbout;

    public AboutMe() {
    }

    public AboutMe(String nombre, String descripcion) {
        this.nombreAbout = nombre;
        this.descripcionAbout = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagenMi() {
        return imagenMi;
    }

    public void setImagenMi(String imagenMi) {
        this.imagenMi = imagenMi;
    }

    public String getNombre() {
        return nombreAbout;
    }

    public void setNombre(String nombre) {
        this.nombreAbout = nombre;
    }

    public String getDescripcion() {
        return descripcionAbout;
    }

    public void setDescripcion(String descripcion) {
        this.descripcionAbout = descripcion;
    }

}
