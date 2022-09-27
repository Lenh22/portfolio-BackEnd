/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.portfolio.Controller;

import com.app.portfolio.Dto.DtoSkill;
import com.app.portfolio.Entity.Skill;
import com.app.portfolio.Security.Controller.Mensaje;
import com.app.portfolio.Service.SkillService;
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
@RequestMapping("Habilidad")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://ftend-porfolio.web.app")
public class SkillController {

    @Autowired
    SkillService skillService;

    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list() {
        List<Skill> newList = skillService.list();
        return new ResponseEntity(newList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkill dtoSkill) {
        if (StringUtils.isBlank(dtoSkill.getNombreHab())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (skillService.existsByNombreHab(dtoSkill.getNombreHab())) {
            return new ResponseEntity(new Mensaje("La habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = new Skill();

        skill.setNombreHab(dtoSkill.getNombreHab());
        String styleNivel = "width:" + dtoSkill.getNivelHab() + "%;"; //guardamos asi en la BD
        skill.setNivelHab(styleNivel);
        skill.setImgHab(dtoSkill.getImgHab());

        skillService.save(skill);
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkill dtoSkill) {
        if (!skillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (skillService.existsByNombreHab(dtoSkill.getNombreHab()) && skillService.getByNombreHab(dtoSkill.getNombreHab()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoSkill.getNombreHab())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = skillService.getOne(id).get();

        skill.setNombreHab(dtoSkill.getNombreHab());
        String styleNivel = "width:" + dtoSkill.getNivelHab() + "%;"; //guardamos asi en la BD
        skill.setNivelHab(styleNivel);
        skill.setImgHab(dtoSkill.getImgHab());

        skillService.save(skill);
        return new ResponseEntity(new Mensaje("Habilidad editada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("La habilidad no existe"), HttpStatus.BAD_REQUEST);
        }
        skillService.delete(id);

        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id) {
        if (!skillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe ese id"), HttpStatus.BAD_REQUEST);
        }
        Skill skill = skillService.getOne(id).get();
        String[] corte1 = skill.getNivelHab().split(":");//width: y A%
        String[] corte2 = corte1[1].split("%"); //A y %
        String numeroAncho = corte2[0];
        System.out.print("El ancho es:"+corte2[0]);
        skill.setNivelHab(numeroAncho);
        
        return new ResponseEntity(skill, HttpStatus.OK);
    }
}
