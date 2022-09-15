/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.portfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author suble
 */
@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreIdi;
    private String nivelIdi;

    public Language() {
    }

    public Language(String nombreIdi, String nivelIdi) {
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
