package com.grupotres.back_personal_disponible.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkBusSkill;

public interface SkBussSkillRepository extends JpaRepository<SkBusSkill, Integer> {
	
	@Query("SELECT s.empleado FROM SkBusSkill s WHERE s.skBusSkill = :nombreBussSkill")
	List<Empleado> findEmpleadosByBussSkill(@Param("nombreBussSkill") String nombre);
	
	@Query("SELECT s.empleado FROM SkBusSkill s WHERE s.skBusSkill = ?1 AND s.nivel = ?2")
	List<Empleado> findEmpleadosByBussSkillAndNivel(String nombre, int nivel);
}
