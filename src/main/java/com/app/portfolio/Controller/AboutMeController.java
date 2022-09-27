/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.portfolio.Controller;

import com.app.portfolio.Dto.DtoAboutMe;
import com.app.portfolio.Entity.AboutMe;
import com.app.portfolio.Security.Controller.Mensaje;
import com.app.portfolio.Service.AboutMeService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("AboutMe")
@CrossOrigin(origins = "http://localhost:4200") //
//@CrossOrigin(origins = "https://ftend-porfolio.web.app") //Con heroku
public class AboutMeController {

    @Autowired
    AboutMeService aboutMeService;

    @GetMapping("/lista")
    public ResponseEntity<List<AboutMe>> list() {
        List<AboutMe> newList = aboutMeService.list();
        return new ResponseEntity<>(newList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoAboutMe dtoAboutMe) {
        if (StringUtils.isBlank(dtoAboutMe.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (aboutMeService.existsByNombreAbout(dtoAboutMe.getNombre())) {
            return new ResponseEntity(new Mensaje("La persona ya existe"), HttpStatus.BAD_REQUEST);
        }

        AboutMe aboutMe = new AboutMe();

        aboutMe.setNombre(dtoAboutMe.getNombre());
        aboutMe.setDescripcion(dtoAboutMe.getDescripcion());
        if (dtoAboutMe.getImagenMi().isEmpty() || dtoAboutMe.getImagenMi().isBlank()) {
            dtoAboutMe.setImagenMi("perfil.jpg");
        }
        aboutMe.setImagenMi(dtoAboutMe.getImagenMi());

        aboutMeService.save(aboutMe);
        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoAboutMe dtoAboutMe) {
        if (!aboutMeService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (aboutMeService.existsByNombreAbout(dtoAboutMe.getNombre()) && aboutMeService.getByNombreAbout(dtoAboutMe.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoAboutMe.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        AboutMe aboutMe = aboutMeService.getOne(id).get();

        aboutMe.setNombre(dtoAboutMe.getNombre());
        aboutMe.setDescripcion(dtoAboutMe.getDescripcion());
        if (dtoAboutMe.getImagenMi().isEmpty() || dtoAboutMe.getImagenMi().isBlank()) {
            dtoAboutMe.setImagenMi("perfil.jpg");
        }
        aboutMe.setImagenMi(dtoAboutMe.getImagenMi());

        aboutMeService.save(aboutMe);
        return new ResponseEntity(new Mensaje("Persona editada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<AboutMe> getById(@PathVariable("id") int id) {
        if (!aboutMeService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe ese id"), HttpStatus.BAD_REQUEST);
        }
        AboutMe aboutMe = aboutMeService.getOne(id).get();
        return new ResponseEntity(aboutMe, HttpStatus.OK);
    }

}
