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
public class DtoEducation {
    @NotBlank
    private int id;
    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String tituloEdu;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaFin;
    @NotBlank
    private String aprobadasEdu;
    @NotBlank
    private String promedio; 
    
    private String imagen;

    public DtoEducation() {
    }

    public DtoEducation(String nombreEdu, String tituloEdu) {
        this.nombreEdu = nombreEdu;
        this.tituloEdu = tituloEdu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getTituloEdu() {
        return tituloEdu;
    }

    public void setTituloEdu(String tituloEdu) {
        this.tituloEdu = tituloEdu;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getAprobadasEdu() {
        return aprobadasEdu;
    }

    public void setAprobadasEdu(String aprobadasEdu) {
        this.aprobadasEdu = aprobadasEdu;
    }

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
    
}
