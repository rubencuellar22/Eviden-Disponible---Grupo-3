package com.grupotres.back_personal_disponible.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkBusSkill;
import com.grupotres.back_personal_disponible.model.SkCertif;


public interface SkCertifRepository extends JpaRepository<SkCertif, Integer> {
	
	@Query("SELECT s.empleado FROM SkCertif s WHERE s.skcertif = :nombreCertif")
	List<Empleado> findEmpleadosByCertifNombre(@Param("nombreCertif") String nombre);

	/*@Query("SELECT s.empleado FROM SkCertif s WHERE s.skCertif = ?1 AND s.external = ?2")
	List<Empleado> findEmpleadosByCertifNombreAndNivel(String nombre, boolean external);*/
	
	@Query("SELECT s.empleado FROM SkCertif s WHERE s.skcertif = :nombre AND " +
	           "s.external = CASE WHEN :external = 1 THEN true ELSE false END")
	    List<Empleado> findEmpleadosByCertifNombreAndNivel(@Param("nombre") String nombre, @Param("external") int external);

	@Query
	("SELECT s FROM SkCertif s")
    List<SkCertif> selectAllSkCertifs();
	
	@Query("SELECT s FROM SkCertif s WHERE s.skcertif LIKE %:nombre%")
    List<SkCertif> findByNombreContaining(@Param("nombre") String nombre);

}

