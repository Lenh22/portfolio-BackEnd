/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class DtoExperience {

    @NotBlank
    private int id;
    @NotBlank
    private String nombreExp;
    @NotBlank
    private String subNombreExp;
    @NotBlank
    private String descripcionExp;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaFin;

    public DtoExperience() {
    }

    public DtoExperience(String nombreExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }

    public String getSubNombreExp() {
        return subNombreExp;
    }

    public void setSubNombreExp(String subNombreExp) {
        this.subNombreExp = subNombreExp;
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
}
