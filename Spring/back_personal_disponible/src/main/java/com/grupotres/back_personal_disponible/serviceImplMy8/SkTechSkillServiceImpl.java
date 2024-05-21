package com.grupotres.back_personal_disponible.serviceImplMy8;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkLenguage;
import com.grupotres.back_personal_disponible.model.SkTechSkill;
import com.grupotres.back_personal_disponible.repository.SkTechSkillRepository;
import com.grupotres.back_personal_disponible.service.SkTechSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SkTechSkillServiceImpl implements SkTechSkillService {

	@Autowired
    private SkTechSkillRepository skTechSkillRepository;

	@Override
	public List<Empleado> findEmpleadosBySkTechSkill(String sktechskill) {
		List<SkTechSkill> skTechSkills = skTechSkillRepository.findBySkTechSkill(sktechskill);
		List<Empleado> empleados = new ArrayList<Empleado>();
		for(SkTechSkill skTechSkill : skTechSkills) {
			empleados.add(skTechSkill.getEmpleado());
		}
		return empleados;
	}
    
    @Override
    public List<Empleado> findEmpleadosBySkTechSkillAndLvl(String sktechskill, int nivel) {
    	List<SkTechSkill> skTechSkills = skTechSkillRepository.findBySkTechSkillAndLvl(sktechskill,nivel);
		List<Empleado> empleados = new ArrayList<Empleado>();
		for(SkTechSkill skTechSkill : skTechSkills) {
			empleados.add(skTechSkill.getEmpleado());
		}
		return empleados;
    }

}
