package com.grupotres.back_personal_disponible.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.grupotres.back_personal_disponible.model.Empleado;

@Service
public interface EmpleadoService {

	void createEmpleado(Empleado emp);
	
	List<Empleado> findbyStatus(String status);

	// List<Empleado> findByBench(String bench);

	List<Empleado> findByCiudad(String ciudad);

	List<Empleado> findByJornada(BigDecimal jornada);
	
	List<Empleado> findbyN4(String n4);


	List<Empleado> findbyCategoria(String categoria);

	// List<Empleado> findbyCcname(String ccname);

	List<Empleado> findbyScr(BigDecimal scr);

    List<Empleado> findbyGrupos(String groups);
}
