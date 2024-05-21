package com.grupotres.back_personal_disponible.service;

import com.grupotres.back_personal_disponible.model.Empleado;

import java.util.List;

public interface SkTechSkillService {
	
    List<Empleado> findEmpleadosBySkTechSkill(String sktechskill);
    
    List<Empleado> findEmpleadosBySkTechSkillAndLvl(String sktechskill, int nivel);
}
