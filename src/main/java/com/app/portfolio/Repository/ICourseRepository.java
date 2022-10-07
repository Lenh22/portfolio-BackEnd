package com.app.portfolio.Repository;

import com.app.portfolio.Entity.Course;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {

    public Optional<Course> findByNombreCurso(String nombreCurso);
    public Optional<Course> findByTituloCurso(String tituloCurso);

    public boolean existsByNombreCurso(String nombreCurso);
    public boolean existsByTituloCurso(String tituloCurso);
}
