package com.grupotres.back_personal_disponible.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkBusSkill;

@Service
public interface SkBussSkillService {
	
	List<Empleado> findEmpleadosByBussSkill(String nombreBussSkill);
	
	List<Empleado> findEmpleadosByBussSkillAndNivel(String nombreBussSkill, int nivel);

	List<SkBusSkill> selectAllSkBusSkills();
}
