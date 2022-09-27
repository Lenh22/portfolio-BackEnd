/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.portfolio.Controller;

import com.app.portfolio.Dto.DtoCourse;
import com.app.portfolio.Entity.Course;
import com.app.portfolio.Security.Controller.Mensaje;
import com.app.portfolio.Service.CourseService;

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
@RequestMapping("Curso")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://ftend-porfolio.web.app")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/lista")
    public ResponseEntity<List<Course>> list() {
        List<Course> newList = courseService.list();
        return new ResponseEntity(newList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoCourse dtoCourse) {
        if (StringUtils.isBlank(dtoCourse.getNombreCurso())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (courseService.existsByNombreCourse(dtoCourse.getNombreCurso())) {
            return new ResponseEntity(new Mensaje("El curso ya existe"), HttpStatus.BAD_REQUEST);
        }

        Course course = new Course();

        course.setNombreCurso(dtoCourse.getNombreCurso());
        course.setTituloCurso(dtoCourse.getTituloCurso());
        course.setLinkCurso(dtoCourse.getLinkCurso());

        courseService.save(course);
        return new ResponseEntity(new Mensaje("Curso agregado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoCourse dtoCourse) {
        if (!courseService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (courseService.existsByNombreCourse(dtoCourse.getNombreCurso()) && courseService.getByNombreCourse(dtoCourse.getNombreCurso()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El curso ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoCourse.getNombreCurso())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Course course = courseService.getOne(id).get();

        course.setNombreCurso(dtoCourse.getNombreCurso());
        course.setTituloCurso(dtoCourse.getTituloCurso());
        course.setLinkCurso(dtoCourse.getLinkCurso());

        courseService.save(course);
        return new ResponseEntity(new Mensaje("Curso editado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!courseService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El curso no existe"), HttpStatus.BAD_REQUEST);
        }
        courseService.delete(id);

        return new ResponseEntity(new Mensaje("Curso eliminado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Course> getById(@PathVariable("id") int id) {
        if (!courseService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe ese id"), HttpStatus.BAD_REQUEST);
        }
        Course course = courseService.getOne(id).get();
        return new ResponseEntity(course, HttpStatus.OK);
    }
}
