/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.portfolio.Controller;

import com.app.portfolio.Dto.DtoProject;
import com.app.portfolio.Entity.Project;
import com.app.portfolio.Security.Controller.Mensaje;
import com.app.portfolio.Service.ProjectService;
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
@RequestMapping("Proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/lista")
    public ResponseEntity<List<Project>> list() {
        List<Project> newList = projectService.list();
        return new ResponseEntity(newList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProject dtoProject) {
        if (StringUtils.isBlank(dtoProject.getNombreProj())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (projectService.existsByNombreProj(dtoProject.getNombreProj())) {
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        Project project = new Project();
        
        System.out.println(dtoProject.getFechaInicioProj()+" y "+dtoProject.getFechaFinProj());
        
        project.setNombreProj(dtoProject.getNombreProj());
        project.setDescripcionProj(dtoProject.getDescripcionProj());
        project.setFechaInicioProj(dtoProject.getFechaInicioProj());
        project.setFechaFinProj(dtoProject.getFechaFinProj());
        project.setLinkProj(dtoProject.getLinkProj());
        if(dtoProject.getImgProj().isEmpty() || dtoProject.getImgProj().isBlank()){
            dtoProject.setImgProj("nubeG.png");
        }
        
        project.setImgProj(dtoProject.getImgProj());

        projectService.save(project);
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProject dtoProject) {
        if (!projectService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (projectService.existsByNombreProj(dtoProject.getNombreProj()) && projectService.getByNombreProj(dtoProject.getNombreProj()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProject.getNombreProj())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Project project = projectService.getOne(id).get();

        project.setNombreProj(dtoProject.getNombreProj());
        project.setDescripcionProj(dtoProject.getDescripcionProj());
        project.setFechaInicioProj(dtoProject.getFechaInicioProj());
        project.setFechaFinProj(dtoProject.getFechaFinProj());
        project.setLinkProj(dtoProject.getLinkProj());
        if(dtoProject.getImgProj().isEmpty()|| dtoProject.getImgProj().isBlank()){
            dtoProject.setImgProj("nubeG.png");
        }
        project.setImgProj(dtoProject.getImgProj());

        projectService.save(project);
        return new ResponseEntity(new Mensaje("Proyecto editado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!projectService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El proyecto no existe"), HttpStatus.BAD_REQUEST);
        }
        projectService.delete(id);

        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") int id) {
        if (!projectService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe ese id"), HttpStatus.BAD_REQUEST);
        }
        Project project = projectService.getOne(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }

}
