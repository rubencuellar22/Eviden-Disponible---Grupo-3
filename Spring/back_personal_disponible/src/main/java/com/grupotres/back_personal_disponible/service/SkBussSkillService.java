package com.grupotres.back_personal_disponible.service;

import java.util.List;

import com.grupotres.back_personal_disponible.model.SkBusSkill;
import org.springframework.stereotype.Service;
import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkBusSkill;

@Service
public interface SkBussSkillService {
	
	List<Empleado> findEmpleadosByBussSkill(String nombreBussSkill);
	
	List<Empleado> findEmpleadosByBussSkillAndNivel(String nombreBussSkill, int nivel);

    void saveAllSkBusSkills(List<SkBusSkill> empSkBussSkills);

    void deleteAllSkBussSkills();
	
	List<SkBusSkill> selectAllSkBusSkills();
}
