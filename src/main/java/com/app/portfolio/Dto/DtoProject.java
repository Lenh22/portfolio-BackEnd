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
public class DtoProject {

    @NotBlank
    private int id;
    @NotBlank
    private String nombreProj;
    @NotBlank
    private String descripcionProj;
    @NotBlank
    private String fechaInicioProj;
    @NotBlank
    private String fechaFinProj;

    private String imgProj;

    private String linkProj;

    public DtoProject() {
    }

    public DtoProject(String nombreProj, String descripcionProj) {
        this.nombreProj = nombreProj;
        this.descripcionProj = descripcionProj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProj() {
        return nombreProj;
    }

    public void setNombreProj(String nombreProj) {
        this.nombreProj = nombreProj;
    }

    public String getDescripcionProj() {
        return descripcionProj;
    }

    public void setDescripcionProj(String descripcionProj) {
        this.descripcionProj = descripcionProj;
    }

    public String getFechaInicioProj() {
        return fechaInicioProj;
    }

    public void setFechaInicioProj(String fechaInicioProj) {
        this.fechaInicioProj = fechaInicioProj;
    }

    public String getFechaFinProj() {
        return fechaFinProj;
    }

    public void setFechaFinProj(String fechaFinProj) {
        this.fechaFinProj = fechaFinProj;
    }

    public String getImgProj() {
        return imgProj;
    }

    public void setImgProj(String imgProj) {
        this.imgProj = imgProj;
    }

    public String getLinkProj() {
        return linkProj;
    }

    public void setLinkProj(String linkProj) {
        this.linkProj = linkProj;
    }

}
