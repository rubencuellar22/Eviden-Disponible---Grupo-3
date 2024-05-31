package com.grupotres.back_personal_disponible.serviceImplMy8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.grupotres.back_personal_disponible.model.*;
import com.grupotres.back_personal_disponible.model.dto.EmpleadoDTO;
import com.grupotres.back_personal_disponible.model.dto.JobTechnologyProfileDTO;
import com.grupotres.back_personal_disponible.model.dto.RoleDTO;
import com.grupotres.back_personal_disponible.model.dto.SkBusSkillDTO;
import com.grupotres.back_personal_disponible.model.dto.SkCertifDTO;
import com.grupotres.back_personal_disponible.model.dto.SkLenguageDTO;
import com.grupotres.back_personal_disponible.model.dto.SkMethodDTO;
import com.grupotres.back_personal_disponible.model.dto.SkTechSkillDTO;
import com.grupotres.back_personal_disponible.model.dto.SkTechnologyDTO;
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
	public void saveAllEmpleados(List<Empleado> empleados) {
		empleadoRepository.saveAll(empleados);
	}

	@Override
	public List<Empleado> getAllEmpleados() {
		return empleadoRepository.findAll();
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
	
	 @Override
	    public List<EmpleadoDTO> getEmpleadosByCiudadFromList(List<EmpleadoDTO> empleadosDTO, String ciudad) {
	        List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
	        for (EmpleadoDTO emp : empleadosDTO) {
	            if (emp.getCiudad().equalsIgnoreCase(ciudad)) {
	                empleadosDTOFiltered.add(emp);
	            }
	        }
	        return empleadosDTOFiltered;
	    }
	 
	 @Override
		public List<EmpleadoDTO> getEmpleadosByJornadaFromList(List<EmpleadoDTO> empleadosDTO, String jornada) {
			List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
			double jornadaDouble = Double.parseDouble(jornada);
			for (EmpleadoDTO emp : empleadosDTO) {
				if (emp.getJornada() == jornadaDouble) {
					empleadosDTOFiltered.add(emp);
				}
			}
			return empleadosDTOFiltered;
		}

	@Override
		public List<EmpleadoDTO> getEmpleadosByGroupsFromList(List<EmpleadoDTO> empleadosDTO, String groups) {
			List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
			for (EmpleadoDTO emp : empleadosDTO) {
				if (emp.getGrupo().getGrupos().contains(groups)) {
					empleadosDTOFiltered.add(emp);
				}
			}
			return empleadosDTOFiltered;
		}
	
	@Override
	public List<EmpleadoDTO> getEmpleadosByCategoriaFromList(List<EmpleadoDTO> empleadosDTO, String categoria) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			if (emp.getCategoria().equals(categoria)) {
				empleadosDTOFiltered.add(emp);
			}
		}
		return empleadosDTOFiltered;
	}
	
	
	@Override
	public List<EmpleadoDTO> getEmpleadosByN4FromList(List<EmpleadoDTO> empleadosDTO, String n4) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			if (emp.getN4().equals(n4)) {
				empleadosDTOFiltered.add(emp);
			}
		}
		return empleadosDTOFiltered;
	}
	
	@Override
	public List<EmpleadoDTO> getEmpleadosByScrFromList(List<EmpleadoDTO> empleadosDTO, String scr) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		double scrDouble = Double.parseDouble(scr);
		for (EmpleadoDTO emp : empleadosDTO) {
			if (emp.getScr() == scrDouble) {
				empleadosDTOFiltered.add(emp);
			}
		}
		return empleadosDTOFiltered;
	}
	
	@Override
	public List<EmpleadoDTO> getEmpleadosByRoleFromList(List<EmpleadoDTO> empleadosDTO, String role) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			if (emp.getRole().getRole().equals(role)) {
				empleadosDTOFiltered.add(emp);
			}
		}
		return empleadosDTOFiltered;
	}

	@Override
	public List<EmpleadoDTO> getEmpleadosBySkBussSkillFromList(List<EmpleadoDTO> empleadosDTO, String nombre) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			for (SkBusSkillDTO skbuss : emp.getSkBusSkills()) {
				if (skbuss.getSkBusSkill().contains(nombre)) {
					empleadosDTOFiltered.add(emp);
					break;
				}
			}
			
		}
		return empleadosDTOFiltered;
	}

	@Override
	public List<EmpleadoDTO> getEmpleadosBySkCertifFromList(List<EmpleadoDTO> empleadosDTO, String nombre) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			for (SkCertifDTO skcert : emp.getSkCertifs()) {
				if (skcert.getSkCertif().contains(nombre)) {
					empleadosDTOFiltered.add(emp);
					break;
				}
			}
			
		}
		return empleadosDTOFiltered;
	}

	@Override
	public List<EmpleadoDTO> getEmpleadosBySkLenguageFromList(List<EmpleadoDTO> empleadosDTO, String sklenguage) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			for (SkLenguageDTO skleng : emp.getSkLenguages()) {
				if (skleng.getSklenguage().contains(sklenguage)) {
					empleadosDTOFiltered.add(emp);
					break;
				}
			}
		}
		return empleadosDTOFiltered;
	}

	@Override
	public List<EmpleadoDTO> getEmpleadosBySkMethodFromList(List<EmpleadoDTO> empleadosDTO, String skMethods) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			for (SkMethodDTO skmeth : emp.getSkMethods()) {
				if (skmeth.getSkmethod().contains(skMethods)) {
					empleadosDTOFiltered.add(emp);
					break;
				}
			}
		}
		return empleadosDTOFiltered;
	}

	@Override
	public List<EmpleadoDTO> getEmpleadosBySkTechnologyFromList(List<EmpleadoDTO> empleadosDTO, String nombre) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			for (SkTechnologyDTO sktech : emp.getSkTechnologies()) {
				if (sktech.getSktechnology().contains(nombre)) {
					empleadosDTOFiltered.add(emp);
					break;
				}
			}
		}
		return empleadosDTOFiltered;
	}

	@Override
	public List<EmpleadoDTO> getEmpleadosBySkTechSkillFromList(List<EmpleadoDTO> empleadosDTO, String skTechSkill) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			for (SkTechSkillDTO sktechSkill : emp.getSkTechSkills()) {
				if (sktechSkill.getSkTechSkill().contains(skTechSkill)) {
					empleadosDTOFiltered.add(emp);
					break;
				}
			}
		}
		return empleadosDTOFiltered;
	}
	
	@Override
	public List<EmpleadoDTO> getEmpleadosByRoleAndNivelFromList(List<EmpleadoDTO> empleadosDTO, String role,
			Integer nivel) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			if (emp.getRole().getRole().equals(role) && (emp.getRole().getNivel() == nivel)) {
				empleadosDTOFiltered.add(emp);
			}
		}
		return empleadosDTOFiltered;
	}

	@Override
	public List<EmpleadoDTO> getEmpleadosBySkBussSkillAndNivelFromList(List<EmpleadoDTO> empleadosDTO, String nombre,
			Integer nivel) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			for (SkBusSkillDTO skbuss : emp.getSkBusSkills()) {
				if (skbuss.getSkBusSkill().contains(nombre) && (skbuss.getNivel() == nivel)) {
					empleadosDTOFiltered.add(emp);
					break;
				}
			}
		}
		return empleadosDTOFiltered;
	}

	@Override
	public List<EmpleadoDTO> getEmpleadosBySkCertifAndNivelFromList(List<EmpleadoDTO> empleadosDTO, String nombre,
			Integer external) {
		boolean isExternal = (external == 1);
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			for (SkCertifDTO skcert : emp.getSkCertifs()) {
				if (skcert.getSkCertif().contains(nombre) && (skcert.isExternal() == isExternal)) {
					empleadosDTOFiltered.add(emp);
					break;
				}
			}
			
		}
		return empleadosDTOFiltered;
	}

	@Override
	public List<EmpleadoDTO> getEmpleadosBySkLenguageAndNivelFromList(List<EmpleadoDTO> empleadosDTO, String sklenguage,
			String nivel) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			for (SkLenguageDTO skleng : emp.getSkLenguages()) {
				if (skleng.getSklenguage().contains(sklenguage) && (skleng.getNivel().contains(nivel))){
					empleadosDTOFiltered.add(emp);
					break;
				}
			}
		}
		return empleadosDTOFiltered;
	}

	@Override
	public List<EmpleadoDTO> getEmpleadosBySkMethodAndNivelFromList(List<EmpleadoDTO> empleadosDTO, String skMethods,
			Integer nivel) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			for (SkMethodDTO skmeth : emp.getSkMethods()) {
				if (skmeth.getSkmethod().contains(skMethods) && (skmeth.getNivel() == nivel)) {
					empleadosDTOFiltered.add(emp);
					break;
				}
			}
		}
		return empleadosDTOFiltered;
	}

	@Override
	public List<EmpleadoDTO> getEmpleadosBySkTechnologyAndNivelFromList(List<EmpleadoDTO> empleadosDTO, String nombre,
			Integer nivel) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			for (SkTechnologyDTO sktech : emp.getSkTechnologies()) {
				if (sktech.getSktechnology().contains(nombre) && (sktech.getNivel() == nivel)) {
					empleadosDTOFiltered.add(emp);
					break;
				}
			}
		}
		return empleadosDTOFiltered;
	}

	@Override
	public List<EmpleadoDTO> getEmpleadosBySkTechSkillAndNivelFromList(List<EmpleadoDTO> empleadosDTO,
			String skTechSkill, Integer nivel) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			for (SkTechSkillDTO sktechSkill : emp.getSkTechSkills()) {
				if (sktechSkill.getSkTechSkill().contains(skTechSkill ) && (sktechSkill.getNivel() == nivel)) {
					empleadosDTOFiltered.add(emp);
					break;
				}
			}
		}
		return empleadosDTOFiltered;
	}

	@Override
	public List<EmpleadoDTO> getEmpleadosByJobTechProfileFromList(List<EmpleadoDTO> empleadosDTO,
			String jobTechnologyProfile) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			for (JobTechnologyProfileDTO jobtech : emp.getJobTechnologyProfiles()) {
				if (jobtech.getJobTechnologyProfile().contains(jobTechnologyProfile)) {
					empleadosDTOFiltered.add(emp);
					break;
				}
			}
		}
		return empleadosDTOFiltered;
	}
	

	@Override
	public List<EmpleadoDTO> getEmpleadosByJobTechProfileAndLvlFromList(List<EmpleadoDTO> empleadosDTO,
			String jobTechnologyProfile, Integer nivel) {
		List<EmpleadoDTO> empleadosDTOFiltered = new ArrayList<>();
		for (EmpleadoDTO emp : empleadosDTO) {
			for (JobTechnologyProfileDTO jobtech : emp.getJobTechnologyProfiles()) {
				if (jobtech.getJobTechnologyProfile().contains(jobTechnologyProfile) && (jobtech.getNivel() == nivel)) {
					empleadosDTOFiltered.add(emp);
					break;
				}
			}
		}
		return empleadosDTOFiltered;
	}
	
	
	public void deleteAllEmpleados() {
		empleadoRepository.deleteAllInBatch();
	}

	  @Override
	    public List<Empleado> findByCiudadContaining(String ciudad) {
	        return empleadoRepository.findByCiudadContaining(ciudad);
	    }

	@Override
	public List<Empleado> findByFilters(String status, BigDecimal jornada, String ciudad, String n4, String categoria,
			BigDecimal scr) {
		return empleadoRepository.findByFilters(status, jornada, ciudad, n4, categoria, scr);
	}

}
