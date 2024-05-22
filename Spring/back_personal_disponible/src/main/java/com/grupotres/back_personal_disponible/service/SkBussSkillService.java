package com.grupotres.back_personal_disponible.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.grupotres.back_personal_disponible.model.Empleado;

@Service
public interface SkBussSkillService {

	List<Empleado> findEmpleadosBySkBussSkill(String skbussskill);

	List<Empleado> findEmpleadosBySkBussSkillAndLvl(String skbussskill,int nivel);
	
}
