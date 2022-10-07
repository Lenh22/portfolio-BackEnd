/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.portfolio.Service;

import com.app.portfolio.Entity.Course;
import com.app.portfolio.Repository.ICourseRepository;
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
public class CourseService {

    @Autowired
    ICourseRepository iCourseRepository;

    public List<Course> list() {
        return iCourseRepository.findAll();
    }

    public Optional<Course> getOne(int id) {
        return iCourseRepository.findById(id);
    }

    public Optional<Course> getByNombreCourse(String nombre) {
        return iCourseRepository.findByNombreCurso(nombre);
    }

    public Optional<Course> getByTituloCourse(String titulo) {
        return iCourseRepository.findByTituloCurso(titulo);
    }

    public void save(Course exp) {
        iCourseRepository.save(exp);
    }

    public void delete(int id) {
        iCourseRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iCourseRepository.existsById(id);
    }

    public boolean existsByNombreCourse(String nombre) {
        return iCourseRepository.existsByNombreCurso(nombre);
    }
     public boolean existsByTituloCurso(String titulo) {
        return iCourseRepository.existsByTituloCurso(titulo);
    }
}
