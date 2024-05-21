package com.grupotres.back_personal_disponible.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkTechnology;

public interface SkTechnologyRepository extends JpaRepository<SkTechnology, Integer>{
	
	@Query("SELECT skt FROM SkTechnology skt WHERE skt.sktechnology = ?1")
	List<SkTechnology> findEmpleadosByTechnology(String sktechnology);
	
	@Query("SELECT skt FROM SkTechnology skt WHERE skt.sktechnology = ?1 and skt.nivel = ?2")
	List<SkTechnology> findEmpleadosByTechnologyAndLvl(String sktechnology, int nivel);
	
}
