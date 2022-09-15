package com.app.portfolio.Repository;

import com.app.portfolio.Entity.AboutMe;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IAboutMeRepository extends JpaRepository<AboutMe, Integer> {

    public Optional<AboutMe> findByNombreAbout(String nombreAbout);

    public boolean existsByNombreAbout(String nombreAbout);
}
