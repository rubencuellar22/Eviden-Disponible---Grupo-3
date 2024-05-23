package com.grupotres.back_personal_disponible.service;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkTechSkill;

import java.util.List;

public interface SkTechSkillService {
	
    List<Empleado> findBySkTechSkill(String skTechSkill);
    
    List<Empleado> findBySkTechSkillAndNivel(String skTechSkill, int nivel);

    void saveAllSkTechSkills(List<SkTechSkill> empSkTechSkills);

    void deleteAllSkTechSkills();
}
