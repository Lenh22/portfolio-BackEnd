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
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreHab;
    private String nivelHab;
    private String imgHab;

    public Skill() {
    }

    public Skill(String nombreHab, String nivelHab) {
        this.nombreHab = nombreHab;
        this.nivelHab = nivelHab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreHab() {
        return nombreHab;
    }

    public void setNombreHab(String nombreHab) {
        this.nombreHab = nombreHab;
    }

    public String getNivelHab() {
        return nivelHab;
    }

    public void setNivelHab(String nivelHab) {
        this.nivelHab = nivelHab;
    }

    public String getImgHab() {
        return imgHab;
    }

    public void setImgHab(String imgHab) {
        this.imgHab = imgHab;
    }
    
    
}
