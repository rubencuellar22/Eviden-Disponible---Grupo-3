package com.grupotres.back_personal_disponible.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grupotres.back_personal_disponible.model.Empleado;

@Service
public interface SkCertifService {
	
	List<Empleado> findEmpleadosByCertifNombre(String nombreCertif);

	List<Empleado> findEmpleadosByCertifNombreAndNivel(String nombre, int external); 
	
} 

	
	
	


