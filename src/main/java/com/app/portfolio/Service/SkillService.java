/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.portfolio.Service;

import com.app.portfolio.Entity.Skill;
import com.app.portfolio.Repository.ISkillRepository;
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
public class SkillService {
    @Autowired
    ISkillRepository iSkillRepository;

    public List<Skill> list() {
        return iSkillRepository.findAll();
    }

    public Optional<Skill> getOne(int id) {
        return iSkillRepository.findById(id);
    }

    public void save(Skill exp) {
        iSkillRepository.save(exp);
    }

    public void delete(int id) {
        iSkillRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iSkillRepository.existsById(id);
    }

    public boolean existsByNombreHab(String nombre) {
        return iSkillRepository.existsByNombreHab(nombre);
    }

    public Optional<Skill> getByNombreHab(String nombre) {
        return iSkillRepository.findByNombreHab(nombre);
    }

    
}
