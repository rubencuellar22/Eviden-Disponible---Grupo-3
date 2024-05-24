package com.grupotres.back_personal_disponible.service;

import java.math.BigDecimal;
import java.util.List;

import com.grupotres.back_personal_disponible.model.dto.EmpleadoDTO;
import org.springframework.stereotype.Service;

import com.grupotres.back_personal_disponible.model.Empleado;

@Service
public interface EmpleadoService {

	void createEmpleado(Empleado emp);
	
	List<Empleado> findbyStatus(String status);

	// List<Empleado> findByBench(String bench);

	List<Empleado> findByCiudad(String ciudad);

	List<Empleado> findByJornada(BigDecimal jornada);
	
	List<Empleado> findbyN4(String n4);


	List<Empleado> findbyCategoria(String categoria);

	// List<Empleado> findbyCcname(String ccname);

	List<Empleado> findbyScr(BigDecimal scr);

    List<Empleado> findbyGrupos(String groups);

    
	List<EmpleadoDTO> getEmpleadosByStatusFromList(List<EmpleadoDTO> empleadosDTO, String status);
    List<EmpleadoDTO> getEmpleadosByCiudadFromList(List<EmpleadoDTO> empleadosDTO, String ciudad);
    List<EmpleadoDTO> getEmpleadosByJornadaFromList(List<EmpleadoDTO> empleadosDTO, String jornada);
	List<EmpleadoDTO> getEmpleadosByGroupsFromList(List<EmpleadoDTO> empleadosDTO, String groups);
	List<EmpleadoDTO> getEmpleadosByCategoriaFromList(List<EmpleadoDTO> empleadosDTO, String categoria);
	List<EmpleadoDTO> getEmpleadosByN4FromList(List<EmpleadoDTO> empleadosDTO, String n4);
	List<EmpleadoDTO> getEmpleadosByScrFromList(List<EmpleadoDTO> empleadosDTO, String scr);

	List<EmpleadoDTO> getEmpleadosByRoleFromList(List<EmpleadoDTO> empleadosDTO, String role);
	List<EmpleadoDTO> getEmpleadosBySkBussSkillFromList(List<EmpleadoDTO> empleadosDTO, String nombre);
	List<EmpleadoDTO> getEmpleadosBySkCertifFromList(List<EmpleadoDTO> empleadosDTO, String nombre);
	List<EmpleadoDTO> getEmpleadosBySkLenguageFromList(List<EmpleadoDTO> empleadosDTO, String sklenguage);
	List<EmpleadoDTO> getEmpleadosBySkMethodFromList(List<EmpleadoDTO> empleadosDTO, String skMethods);
	List<EmpleadoDTO> getEmpleadosBySkTechnologyFromList(List<EmpleadoDTO> empleadosDTO, String nombre);
	List<EmpleadoDTO> getEmpleadosBySkTechSkillFromList(List<EmpleadoDTO> empleadosDTO, String skTechSkill);

	List<EmpleadoDTO> getEmpleadosByRoleAndNivelFromList(List<EmpleadoDTO> empleadosDTO, String role, Integer nivel);
	List<EmpleadoDTO> getEmpleadosBySkBussSkillAndNivelFromList(List<EmpleadoDTO> empleadosDTO, String nombre, Integer nivel);
	List<EmpleadoDTO> getEmpleadosBySkCertifAndNivelFromList(List<EmpleadoDTO> empleadosDTO, String nombre, Integer external);
	List<EmpleadoDTO> getEmpleadosBySkLenguageAndNivelFromList(List<EmpleadoDTO> empleadosDTO, String sklenguage, String nivel);
	List<EmpleadoDTO> getEmpleadosBySkMethodAndNivelFromList(List<EmpleadoDTO> empleadosDTO, String skMethods, Integer nivel);
	List<EmpleadoDTO> getEmpleadosBySkTechnologyAndNivelFromList(List<EmpleadoDTO> empleadosDTO, String nombre, Integer nivel);
	List<EmpleadoDTO> getEmpleadosBySkTechSkillAndNivelFromList(List<EmpleadoDTO> empleadosDTO, String skTechSkill, Integer nivel);

	List<EmpleadoDTO> getEmpleadosByJobTechProfileFromList(List<EmpleadoDTO> empleadosDTO,
			String jobTechnologyProfile);

	List<EmpleadoDTO> getEmpleadosByJobTechProfileAndLvlFromList(List<EmpleadoDTO> empleadosDTO,
			String jobTechnologyProfile, Integer nivel);
	
	
}
