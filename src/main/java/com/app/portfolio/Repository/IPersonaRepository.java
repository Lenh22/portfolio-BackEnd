/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.portfolio.Repository;

import com.app.portfolio.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author suble
 */
@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long> {
    //crtl + click al JpaRepository para ver sus funciones para usar
}
