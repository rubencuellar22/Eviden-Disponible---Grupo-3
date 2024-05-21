package com.grupotres.back_personal_disponible.repository;

import com.grupotres.back_personal_disponible.model.SkMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkMethodRepository extends JpaRepository<SkMethod, Integer> {

    @Query("SELECT skm FROM SkMethod skm WHERE skm.Skmethod = ?1") // Corrección aquí
    List<SkMethod> findBySkMethod(String skmethod);
    
    @Query("SELECT skm FROM SkMethod skm WHERE skm.Skmethod = ?1 and skm.nivel = ?2") // Corrección aquí
    List<SkMethod> findBySkMethodAndLvl(String skmethod, int nivel);
}
