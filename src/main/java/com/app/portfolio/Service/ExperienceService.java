/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.portfolio.Service;

import com.app.portfolio.Entity.Experience;
import com.app.portfolio.Repository.IExperienceRepository;
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
public class ExperienceService {

    @Autowired
    IExperienceRepository expRepository;

    public List<Experience> list() {
        return expRepository.findAll();
    }

    public Optional<Experience> getOne(int id) {
        return expRepository.findById(id);
    }

    public Optional<Experience> getByNombreExp(String nombre) {
        return expRepository.findByNombreExp(nombre);
    }

    public void save(Experience exp) {
        expRepository.save(exp);
    }

    public void delete(int id) {
        expRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return expRepository.existsById(id);
    }

    public boolean existsByNombreExp(String nombreExp) {
        return expRepository.existsByNombreExp(nombreExp);
    }
}
