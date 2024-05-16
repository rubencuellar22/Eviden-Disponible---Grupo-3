package com.grupotres.back_personal_disponible.repository;

import com.grupotres.back_personal_disponible.model.SkMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkMethodRepository extends JpaRepository<SkMethod, Integer> {

    @Query("SELECT m FROM SkMethod m WHERE m.Skmethod = :skMethod") // Corrección aquí
    List<SkMethod> findBySkMethod(String skMethod);
}
