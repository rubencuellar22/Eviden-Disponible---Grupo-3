package com.grupotres.back_personal_disponible.service;

import java.util.List;

import com.grupotres.back_personal_disponible.model.SkTechnology;
import org.springframework.stereotype.Service;
import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkTechnology;

@Service
public interface SkTechnologyService {
	
	List<Empleado> findEmpleadosByTechnology(String nombreTechnology);
	
	List<Empleado> findEmpleadosByTechnologyAndNivel(String nombreTechnology, int nivel);

    void saveAllSkTechnologies(List<SkTechnology> empSkTechnologies);

    void deleteAllSkTechnologies();
	
	List<SkTechnology> selectAllSkTechnologies();
}
