package com.grupotres.back_personal_disponible.serviceImplMy8;

import java.util.List;

import com.grupotres.back_personal_disponible.model.SkBusSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.repository.SkBussSkillRepository;
import com.grupotres.back_personal_disponible.service.SkBussSkillService;

@Service
public class SkBussSkillServiceImpl implements SkBussSkillService{
	@Autowired
	private SkBussSkillRepository skBussSkillRepository;

	@Override
	public List<Empleado> findEmpleadosByBussSkill(String nombreBussSkill) {
		return skBussSkillRepository.findEmpleadosByBussSkill(nombreBussSkill);
	}

	@Override
	public void saveAllSkBusSkills(List<SkBusSkill> empSkBussSkills) {
		skBussSkillRepository.saveAll(empSkBussSkills);
	}

	@Override
	public void deleteAllSkBussSkills() {
		skBussSkillRepository.deleteAllInBatch();
	}
}
