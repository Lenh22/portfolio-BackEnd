/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.portfolio.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author suble
 */
public class DtoAboutMe {
    @NotBlank
    private int id;
    
    private String imagenMi;
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;

    public DtoAboutMe() {
    }

    public DtoAboutMe(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
