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
public class DtoLanguage {
    @NotBlank
    private int id;
    @NotBlank
    private String nombreIdi;
    @NotBlank
    private String nivelIdi;

    public DtoLanguage() {
    }

    public DtoLanguage(String nombreIdi, String nivelIdi) {
        this.nombreIdi = nombreIdi;
        this.nivelIdi = nivelIdi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreIdi() {
        return nombreIdi;
    }

    public void setNombreIdi(String nombreIdi) {
        this.nombreIdi = nombreIdi;
    }

    public String getNivelIdi() {
        return nivelIdi;
    }

    public void setNivelIdi(String nivelIdi) {
        this.nivelIdi = nivelIdi;
    }
    
    
}
