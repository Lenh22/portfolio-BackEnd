/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.portfolio.Controller;

import com.app.portfolio.Dto.DtoEducation;
import com.app.portfolio.Service.EducationService;
import com.app.portfolio.Entity.Education;
import com.app.portfolio.Security.Controller.Mensaje;
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
@RequestMapping("Educacion")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://ftend-porfolio.web.app")
public class EducationController {

    @Autowired
    EducationService eduService;

    @GetMapping("/lista")
    public ResponseEntity<List<Education>> list() {
        List<Education> newList = eduService.list();
        return new ResponseEntity(newList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducation dtoEducation) {
        if (StringUtils.isBlank(dtoEducation.getNombreEdu())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (eduService.existsByTituloEdu(dtoEducation.getTituloEdu())) {
            return new ResponseEntity(new Mensaje("La educacion ya existe"), HttpStatus.BAD_REQUEST);
        }

        Education education = new Education();

        education.setNombreEdu(dtoEducation.getNombreEdu());
        education.setTituloEdu(dtoEducation.getTituloEdu());
        education.setFechaInicio(dtoEducation.getFechaInicio());
        education.setFechaFin(dtoEducation.getFechaFin());
        education.setAprobadasEdu(dtoEducation.getAprobadasEdu());
        education.setPromedio(dtoEducation.getPromedio());
        if (dtoEducation.getImagen().isEmpty()) {
            dtoEducation.setImagen("nubeG.png");
        }
        education.setImagen(dtoEducation.getImagen());

        eduService.save(education);
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducation dtoEducation) {
        if (!eduService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (eduService.existsByTituloEdu(dtoEducation.getTituloEdu()) && eduService.getByTituloEdu(dtoEducation.getTituloEdu()).get().getId() != id) {
            if (eduService.existsByNombreEdu(dtoEducation.getNombreEdu()) && eduService.getByNombreEdu(dtoEducation.getNombreEdu()).get().getId() != id) {
                return new ResponseEntity(new Mensaje("El titulo de esa educacion ya existe"), HttpStatus.BAD_REQUEST);
            }
        }

        if (StringUtils.isBlank(dtoEducation.getNombreEdu())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Education education = eduService.getOne(id).get();
        education.setNombreEdu(dtoEducation.getNombreEdu());
        education.setTituloEdu(dtoEducation.getTituloEdu());
        education.setFechaInicio(dtoEducation.getFechaInicio());
        education.setFechaFin(dtoEducation.getFechaFin());
        education.setAprobadasEdu(dtoEducation.getAprobadasEdu());
        education.setPromedio(dtoEducation.getPromedio());
        if (dtoEducation.getImagen().isEmpty()) {
            dtoEducation.setImagen("nubeG.png");
        }
        education.setImagen(dtoEducation.getImagen());

        eduService.save(education);
        return new ResponseEntity(new Mensaje("Educacion editada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!eduService.existsById(id)) {
            return new ResponseEntity(new Mensaje("La educacion no existe"), HttpStatus.BAD_REQUEST);
        }
        eduService.delete(id);

        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id) {
        if (!eduService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe ese id"), HttpStatus.BAD_REQUEST);
        }
        Education education = eduService.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
}
