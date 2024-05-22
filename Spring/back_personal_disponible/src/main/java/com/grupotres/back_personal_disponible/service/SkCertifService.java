package com.grupotres.back_personal_disponible.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grupotres.back_personal_disponible.model.Empleado;

@Service
public interface SkCertifService {
	
	List<Empleado> findEmpleadosBySkCertif(String skcertif);

	List<Empleado> findEmpleadosBySkCertifAndExternal(String skcertif, boolean external); 

} 

	
	
	


