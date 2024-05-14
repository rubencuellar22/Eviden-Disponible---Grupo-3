package com.grupotres.back_personal_disponible.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupotres.back_personal_disponible.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
	
	@Query
	("SELECT e from Empleado e WHERE e.status=?1")
	public List<Empleado> findbyStatus(String status);

}
