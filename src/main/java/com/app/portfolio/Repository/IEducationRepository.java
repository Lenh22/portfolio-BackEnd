package com.app.portfolio.Repository;

import com.app.portfolio.Entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationRepository extends JpaRepository<Education, Integer> {

    public Optional< Education > findByNombreEdu(String nombreEdu);

    public boolean existsByNombreEdu(String nombreEdu);
    
    public boolean existsByTituloEdu(String tituloEdu);
     public Optional< Education > findByTituloEdu(String tituloEdu);
}
