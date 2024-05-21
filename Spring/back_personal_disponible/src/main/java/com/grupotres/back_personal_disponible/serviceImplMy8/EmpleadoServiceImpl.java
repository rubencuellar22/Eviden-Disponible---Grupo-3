package com.grupotres.back_personal_disponible.serviceImplMy8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.grupotres.back_personal_disponible.model.*;
import com.grupotres.back_personal_disponible.model.dto.EmpleadoDTO;
import com.grupotres.back_personal_disponible.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupotres.back_personal_disponible.service.EmpleadoService;


@Service("empleadoServiceImpl")
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	EmpleadoRepository empleadoRepository;

	@Autowired
	GrupoRepository grupoRepository;

	@Autowired
	JobTechnologyProfileRepository jobTechnologyProfileRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	SkLenguageRepository skLenguageRepository;

	@Autowired
	SkMethodRepository skMethodRepository;

	@Autowired
	SkTechSkillRepository skTechSkillRepository;

	@Autowired
	SkCertifRepository skCertifRepository;

	@Autowired
	SkTechnologyRepository skTechnologyRepository;

	@Autowired
	SkBussSkillRepository skBusSkillRepository;

	@Override
	public void createEmpleado(Empleado emp) {
		Grupo grupo = emp.getGrupo();
		grupoRepository.save(grupo);

		empleadoRepository.save(emp);
		Empleado newEmp = empleadoRepository.findById(emp.getGin()).orElse(null);

		List<JobTechnologyProfile> jobTechnologyProfiles = emp.getJobTechnologyProfiles();
		List<JobTechnologyProfile> jobTechnologyProfilesCopy = new ArrayList<>();
		for (JobTechnologyProfile jobTechnologyProfile : jobTechnologyProfiles) {
			JobTechnologyProfile jobTechnologyProfileCopy = new JobTechnologyProfile();
			jobTechnologyProfileCopy.setNivel(jobTechnologyProfile.getNivel());
			jobTechnologyProfileCopy.setJobTechnologyProfile(jobTechnologyProfile.getJobTechnologyProfile());
			jobTechnologyProfileCopy.setEmpleado(newEmp);
			jobTechnologyProfilesCopy.add(jobTechnologyProfileCopy);
		}
        jobTechnologyProfileRepository.saveAll(jobTechnologyProfilesCopy);


        assert newEmp != null;
        Role role = roleRepository.findById(newEmp.getRole().getIdRole()).orElse(null);
        assert role != null;
        role.setEmpleado(newEmp);
		roleRepository.save(role);

		List<SkLenguage> skLenguages = emp.getSkLenguages();
		List<SkLenguage> skLenguagesCopy = new ArrayList<>();
		for (SkLenguage skLenguage : skLenguages) {
			SkLenguage skLenguageCopy = new SkLenguage();
			skLenguageCopy.setNivel(skLenguage.getNivel());
			skLenguageCopy.setSklenguage(skLenguage.getSklenguage());
			skLenguageCopy.setEmpleado(newEmp);
			skLenguagesCopy.add(skLenguageCopy);
		}
		skLenguageRepository.saveAll(skLenguagesCopy);

		List<SkMethod> skMethods = emp.getSkMethods();
		List<SkMethod> skMethodsCopy = new ArrayList<>();
		for (SkMethod skMethod : skMethods) {
			SkMethod skMethodCopy = new SkMethod();
			skMethodCopy.setSkmethod(skMethod.getSkmethod());
			skMethodCopy.setNivel(skMethod.getNivel());
			skMethodCopy.setEmpleado(newEmp);
			skMethodsCopy.add(skMethodCopy);
		}
		skMethodRepository.saveAll(skMethodsCopy);

		List<SkTechSkill> skTechSkills = emp.getSkTechSkills();
		List<SkTechSkill> skTechSkillsCopy = new ArrayList<>();
		for (SkTechSkill skTechSkill : skTechSkills) {
			SkTechSkill skTechSkillCopy = new SkTechSkill();
			skTechSkillCopy.setSkTechSkill(skTechSkill.getSkTechSkill());
			skTechSkillCopy.setNivel(skTechSkill.getNivel());
			skTechSkillCopy.setEmpleado(newEmp);
			skTechSkillsCopy.add(skTechSkillCopy);
		}
		skTechSkillRepository.saveAll(skTechSkillsCopy);

		List<SkCertif> skCertifs = emp.getSkCertifs();
		List<SkCertif> skCertifsCopy = new ArrayList<>();
		for (SkCertif skCertif : skCertifs) {
			SkCertif skCertifCopy = new SkCertif();
			skCertifCopy.setSkcertif(skCertif.getSkcertif());
			skCertifCopy.setExternal(skCertif.getExternal());
			skCertifCopy.setEmpleado(newEmp);
			skCertifsCopy.add(skCertifCopy);
		}
		skCertifRepository.saveAll(skCertifsCopy);

		List<SkTechnology> skTechnologies = emp.getSkTechnologies();
		List<SkTechnology> skTechnologiesCopy = new ArrayList<>();
		for (SkTechnology skTechnology : skTechnologies) {
			SkTechnology skTechnologyCopy = new SkTechnology();
			skTechnologyCopy.setSktechnology(skTechnology.getSktechnology());
			skTechnologyCopy.setNivel(skTechnology.getNivel());
			skTechnologyCopy.setEmpleado(newEmp);
			skTechnologiesCopy.add(skTechnologyCopy);
		}
		skTechnologyRepository.saveAll(skTechnologiesCopy);

		List<SkBusSkill> skBusSkills = emp.getSkBusSkills();
		List<SkBusSkill> skBusSkillsCopy = new ArrayList<>();
		for (SkBusSkill skBusSkill : skBusSkills) {
			SkBusSkill skBusSkillCopy = new SkBusSkill();
			skBusSkillCopy.setSkBusSkill(skBusSkill.getSkBusSkill());
			skBusSkillCopy.setNivel(skBusSkill.getNivel());
			skBusSkillCopy.setEmpleado(newEmp);
			skBusSkillsCopy.add(skBusSkillCopy);
		}
		skBusSkillRepository.saveAll(skBusSkillsCopy);

        assert newEmp != null;
        empleadoRepository.save(newEmp);
	}

	@Override
	public List<Empleado> findbyStatus(String status) {
		// TODO Auto-generated method stub
		return empleadoRepository.findbyStatus(status);
	}
	
	@Override
	public List<Empleado> findByCiudad(String ciudad) {
		// TODO Auto-generated method stub
		return empleadoRepository.findByCiudad(ciudad);
	}
	@Override
	public List<Empleado> findByJornada(BigDecimal jornada) {
		// TODO Auto-generated method stub
		return empleadoRepository.findByJornada(jornada);
	}
	@Override
	public List<Empleado> findbyN4(String n4) {
		return empleadoRepository.findbyN4(n4);
	}
	@Override
	public List<Empleado> findbyCategoria(String categoria) {
		// TODO Auto-generated method stub
		return empleadoRepository.findbyCategoria(categoria);
	}
	/*@Override
	public List<Empleado> findbyCcname(String ccname) {
		// TODO Auto-generated method stub
		return empleadoRepository.findbyCcname(ccname);
	} Commented bc ccname is the name of the group cc in Grupos class*/
	@Override
	public List<Empleado> findbyScr(BigDecimal scr) {
		// TODO Auto-generated method stub
		return empleadoRepository.findbyScr(scr);
	}

	@Override
	public List<Empleado> findbyGrupos(String groups) {
		return empleadoRepository.findByGroups(groups);
	}

	@Override
	public List<EmpleadoDTO> getEmpleadosByStatusFromList(List<EmpleadoDTO> empleadosDTO, String status) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			if (emp.getStatus().equals(status)) {
				empleadosDTOFiltered.add(emp);
			}
		}
		return empleadosDTOFiltered;
	}

	/*@Override
	public List<Empleado> findByBench(String bench) {
		// TODO Auto-generated method stub
		return empleadoRepository.findByBench(bench);
	}*/
	

	
	
	
	
	

}
