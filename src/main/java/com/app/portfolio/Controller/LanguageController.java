/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.portfolio.Controller;

import com.app.portfolio.Dto.DtoLanguage;
import com.app.portfolio.Entity.Language;
import com.app.portfolio.Security.Controller.Mensaje;
import com.app.portfolio.Service.LanguageService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suble
 */
@RestController
@RequestMapping("Idioma")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://ftend-porfolio.web.app")
public class LanguageController {

    @Autowired
    LanguageService languageService;

    @GetMapping("/lista")
    public ResponseEntity<List<Language>> list() {
        List<Language> newList = languageService.list();
        return new ResponseEntity(newList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoLanguage dtoLanguage) {
        if (StringUtils.isBlank(dtoLanguage.getNombreIdi())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (languageService.existsByNombreIdi(dtoLanguage.getNombreIdi())) {
            return new ResponseEntity(new Mensaje("El idioma ya existe"), HttpStatus.BAD_REQUEST);
        }

        Language language = new Language();

        language.setNombreIdi(dtoLanguage.getNombreIdi());
        language.setNivelIdi(dtoLanguage.getNivelIdi());

        languageService.save(language);
        return new ResponseEntity(new Mensaje("Idioma agregado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoLanguage dtoLanguage) {
        if (!languageService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (languageService.existsByNombreIdi(dtoLanguage.getNombreIdi()) && languageService.getByNombreIdi(dtoLanguage.getNombreIdi()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese idioma ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoLanguage.getNombreIdi())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Language language = languageService.getOne(id).get();

        language.setNombreIdi(dtoLanguage.getNombreIdi());
        language.setNivelIdi(dtoLanguage.getNivelIdi());

        languageService.save(language);
        return new ResponseEntity(new Mensaje("Idioma editado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!languageService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El idioma no existe"), HttpStatus.BAD_REQUEST);
        }
        languageService.delete(id);

        return new ResponseEntity(new Mensaje("Idioma eliminado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Language> getById(@PathVariable("id") int id) {
        if (!languageService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe ese id"), HttpStatus.BAD_REQUEST);
        }
        Language language = languageService.getOne(id).get();
        return new ResponseEntity(language, HttpStatus.OK);
    }
}
