package com.grupotres.back_personal_disponible.serviceImplMy8;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkBusSkill;
import com.grupotres.back_personal_disponible.repository.SkBussSkillRepository;
import com.grupotres.back_personal_disponible.service.SkBussSkillService;

@Service
public class SkBussSkillServiceImpl implements SkBussSkillService{
	@Autowired
	private SkBussSkillRepository skBussSkillRepository;

	@Override
	public List<Empleado> findEmpleadosBySkBussSkill(String skbussskill) {
		List<SkBusSkill> skBussSkills = skBussSkillRepository.findBySkBussSkill(skbussskill);
		List<Empleado> empleados = new ArrayList<Empleado>();
		for(SkBusSkill skBussSkill : skBussSkills) {
			empleados.add(skBussSkill.getEmpleado());
		}
		return empleados;	
	}

	@Override
	public List<Empleado> findEmpleadosBySkBussSkillAndLvl(String skbussskill, int nivel) {
		List<SkBusSkill> skBussSkills = skBussSkillRepository.findBySkBussSkillAndLvl(skbussskill,nivel);
		List<Empleado> empleados = new ArrayList<Empleado>();
		for(SkBusSkill skBussSkill : skBussSkills) {
			empleados.add(skBussSkill.getEmpleado());
		}
		return empleados;	
	}

}
