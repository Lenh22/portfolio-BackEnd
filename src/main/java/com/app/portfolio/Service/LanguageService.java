/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.portfolio.Service;

import com.app.portfolio.Entity.Language;
import com.app.portfolio.Repository.ILanguageRepository;
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
public class LanguageService {
    @Autowired
    ILanguageRepository iLanguageRepository;

    public List<Language> list() {
        return iLanguageRepository.findAll();
    }

    public Optional<Language> getOne(int id) {
        return iLanguageRepository.findById(id);
    }

    public Optional<Language> getByNombreIdi(String nombreIdi) {
        return iLanguageRepository.findByNombreIdi(nombreIdi);
    }

    public void save(Language exp) {
        iLanguageRepository.save(exp);
    }

    public void delete(int id) {
        iLanguageRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iLanguageRepository.existsById(id);
    }

    public boolean existsByNombreIdi(String nombre) {
        return iLanguageRepository.existsByNombreIdi(nombre);
    }
}
