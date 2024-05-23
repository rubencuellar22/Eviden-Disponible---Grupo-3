package com.grupotres.back_personal_disponible.serviceImplMy8;


import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkTechSkill;
import com.grupotres.back_personal_disponible.repository.SkTechSkillRepository;
import com.grupotres.back_personal_disponible.service.SkTechSkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkTechSkillServiceImpl implements SkTechSkillService {

	@Autowired
    private SkTechSkillRepository skTechSkillRepository;

	@Override
	public List<Empleado> findBySkTechSkill(String skTechSkill) {
		return skTechSkillRepository.findBySkTechSkill(skTechSkill);
	}
    
    @Override
    public List<Empleado> findBySkTechSkillAndNivel(String skTechSkill, int nivel) {
        return skTechSkillRepository.findBySkTechSkillAndNivel(skTechSkill, nivel);
    }

    @Override
    public void saveAllSkTechSkills(List<SkTechSkill> empSkTechSkills) {
        skTechSkillRepository.saveAll(empSkTechSkills);
    }

    @Override
    public void deleteAllSkTechSkills() {
        skTechSkillRepository.deleteAllInBatch();
    }

}
