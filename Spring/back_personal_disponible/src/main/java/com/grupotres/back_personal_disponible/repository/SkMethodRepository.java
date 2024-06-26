package com.grupotres.back_personal_disponible.repository;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkLenguage;
import com.grupotres.back_personal_disponible.model.SkMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkMethodRepository extends JpaRepository<SkMethod, Integer> {

    @Query("SELECT m.empleado FROM SkMethod m WHERE m.Skmethod = :skMethod") // Corrección aquí
    List<Empleado> findBySkMethod(String skMethod);
    
    @Query("SELECT m.empleado FROM SkMethod m WHERE m.Skmethod = :skMethod AND m.nivel = :nivel") // Corrección aquí
    List<Empleado> findBySkMethodAndNivel(String skMethod, int nivel);

    @Query
	("SELECT m FROM SkMethod m")
    List<SkMethod> selectAllSkMethod();
}
