package com.app.portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class DtoCourse {
    @NotBlank
    private int id;
    
    private String linkCurso;
    @NotBlank
    private String tituloCurso;
    @NotBlank
    private String nombreCurso;

    public DtoCourse() {
    }

    public DtoCourse(String tituloCurso, String nombreCurso) {
        this.tituloCurso = tituloCurso;
        this.nombreCurso = nombreCurso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLinkCurso() {
        return linkCurso;
    }

    public void setLinkCurso(String linkCurso) {
        this.linkCurso = linkCurso;
    }

    public String getTituloCurso() {
        return tituloCurso;
    }

    public void setTituloCurso(String tituloCurso) {
        this.tituloCurso = tituloCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    
    
}
