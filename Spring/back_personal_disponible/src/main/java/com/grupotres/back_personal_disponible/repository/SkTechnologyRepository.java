package com.grupotres.back_personal_disponible.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkTechnology;

public interface SkTechnologyRepository extends JpaRepository<SkTechnology, Integer>{
	@Query("SELECT s.empleado FROM SkTechnology s WHERE s.sktechnology = :nombreTechnology")
	List<Empleado> findEmpleadosByTechnology(@Param("nombreTechnology") String nombre);
}
