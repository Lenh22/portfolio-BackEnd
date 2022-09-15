/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.portfolio.Repository;

import com.app.portfolio.Entity.Language;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author suble
 */
@Repository
public interface ILanguageRepository extends JpaRepository<Language, Integer> {

    public Optional<Language> findByNombreIdi(String nombreIdi);

    public boolean existsByNombreIdi(String nombreIdi);
}
