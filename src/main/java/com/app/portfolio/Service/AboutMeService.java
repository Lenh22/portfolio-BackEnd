/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.portfolio.Service;

import com.app.portfolio.Entity.AboutMe;
import com.app.portfolio.Repository.IAboutMeRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author suble
 */
@Service
@Transactional
public class AboutMeService {

    @Autowired
    IAboutMeRepository aboutMeRepository;

    public List<AboutMe> list() {
        return aboutMeRepository.findAll();
    }

    public Optional<AboutMe> getOne(int id) {
        return aboutMeRepository.findById(id);
    }

    public Optional<AboutMe> getByNombreAbout(String nombre) {
        return aboutMeRepository.findByNombreAbout(nombre);
    }

    public void save(AboutMe abo) {
        aboutMeRepository.save(abo);
    }
    public boolean existsById(int id) {
        return aboutMeRepository.existsById(id);
    }

    public boolean existsByNombreAbout(String nombre) {
        return aboutMeRepository.existsByNombreAbout(nombre);
    }

}
