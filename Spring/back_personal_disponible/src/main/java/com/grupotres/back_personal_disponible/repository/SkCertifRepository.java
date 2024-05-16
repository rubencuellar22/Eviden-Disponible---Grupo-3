package com.grupotres.back_personal_disponible.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkCertif;


public interface SkCertifRepository extends JpaRepository<SkCertif, Integer> {
	
	@Query("SELECT s.empleado FROM SkCertif s WHERE s.skcertif = :nombreCertif")
	List<Empleado> findEmpleadosByCertifNombre(@Param("nombreCertif") String nombre);
}
	

