/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.portfolio.Service;

import com.app.portfolio.Entity.Project;
import com.app.portfolio.Repository.IProjectRepository;
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
public class ProjectService {

    @Autowired
    IProjectRepository iProjectRepository;

    public List<Project> list() {
        return iProjectRepository.findAll();
    }

    public Optional<Project> getOne(int id) {
        return iProjectRepository.findById(id);
    }

    public Optional<Project> getByNombreProj(String nombre) {
        return iProjectRepository.findByNombreProj(nombre);
    }

    public void save(Project exp) {
        iProjectRepository.save(exp);
    }

    public void delete(int id) {
        iProjectRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iProjectRepository.existsById(id);
    }

    public boolean existsByNombreProj(String nombre) {
        return iProjectRepository.existsByNombreProj(nombre);
    }

}
