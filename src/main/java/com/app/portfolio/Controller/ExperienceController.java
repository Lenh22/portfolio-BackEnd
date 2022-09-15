/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.portfolio.Controller;

import com.app.portfolio.Dto.DtoExperience;
import com.app.portfolio.Entity.Experience;
import com.app.portfolio.Security.Controller.Mensaje;

import com.app.portfolio.Service.ExperienceService;
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
@RequestMapping("Experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienceController {

    @Autowired
    ExperienceService experienceService;

    @GetMapping("/lista")
    public ResponseEntity<List<Experience>> list() {
        List<Experience> newList = experienceService.list();
        return new ResponseEntity(newList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperience dtoExp) {
        if (StringUtils.isBlank(dtoExp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (experienceService.existsByNombreExp(dtoExp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        Experience experience = new Experience();
        experience.setNombreExp(dtoExp.getNombreExp());
        experience.setSubNombreExp(dtoExp.getSubNombreExp());
        experience.setDescripcionExp(dtoExp.getDescripcionExp());
        experience.setFechaInicio(dtoExp.getFechaInicio());
        experience.setFechaFin(dtoExp.getFechaFin());
        
        experienceService.save(experience);
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperience dtoExp) {
        if (!experienceService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (experienceService.existsByNombreExp(dtoExp.getNombreExp()) && experienceService.getByNombreExp(dtoExp.getNombreExp()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoExp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experience experience = experienceService.getOne(id).get();
        experience.setNombreExp(dtoExp.getNombreExp());
        experience.setSubNombreExp(dtoExp.getSubNombreExp());
        experience.setDescripcionExp(dtoExp.getDescripcionExp());
        experience.setFechaInicio(dtoExp.getFechaInicio());
        experience.setFechaFin(dtoExp.getFechaFin());
        
        experienceService.save(experience);
        return new ResponseEntity(new Mensaje("Experiencia editada"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable ("id") int id){
            if (!experienceService.existsById(id)) {
            return new ResponseEntity(new Mensaje("La experiencia no existe"), HttpStatus.BAD_REQUEST);
        }
            experienceService.delete(id);
            
            return new ResponseEntity(new Mensaje("Experiencia eliminada"),HttpStatus.OK);
    }
        @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") int id){
        if(!experienceService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe ese id"),HttpStatus.BAD_REQUEST);
        }
        Experience experience = experienceService.getOne(id).get();
        return new ResponseEntity(experience,HttpStatus.OK);
    }
}
