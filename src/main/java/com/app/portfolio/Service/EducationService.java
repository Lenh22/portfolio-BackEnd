/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.portfolio.Service;

import com.app.portfolio.Entity.Education;
import com.app.portfolio.Repository.IEducationRepository;
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
public class EducationService {

    @Autowired
    IEducationRepository eduRepository;

    public List<Education> list() {
        return eduRepository.findAll();
    }

    public Optional<Education> getOne(int id) {
        return eduRepository.findById(id);
    }

    public void save(Education exp) {
        eduRepository.save(exp);
    }

    public void delete(int id) {
        eduRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return eduRepository.existsById(id);
    }

    public boolean existsByNombreEdu(String nombre) {
        return eduRepository.existsByNombreEdu(nombre);
    }

    public boolean existsByTituloEdu(String tituloEdu) {
        return eduRepository.existsByTituloEdu(tituloEdu);
    }

    public Optional<Education> getByNombreEdu(String nombre) {
        return eduRepository.findByNombreEdu(nombre);
    }

    public Optional<Education> getByTituloEdu(String nombre) {
        return eduRepository.findByTituloEdu(nombre);
    }

}
