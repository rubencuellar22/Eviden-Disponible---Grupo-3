package com.grupotres.back_personal_disponible.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.grupotres.back_personal_disponible.model.Empleado;

@Service
public interface SkLenguageService {

	public List<Empleado> findEmpleadosBySkLenguage(String sklenguage);
	
	public List<Empleado> findEmpleadosBySkLenguageAndLvl(String sklenguage,String nivel);
}
