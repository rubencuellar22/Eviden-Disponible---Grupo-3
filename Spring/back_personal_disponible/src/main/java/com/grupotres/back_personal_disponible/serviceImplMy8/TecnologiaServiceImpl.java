package com.grupotres.back_personal_disponible.serviceImplMy8;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkTechnology;
import com.grupotres.back_personal_disponible.repository.SkTechnologyRepository;
import com.grupotres.back_personal_disponible.service.SkTechnologyService;

@Service
public class TecnologiaServiceImpl implements SkTechnologyService {
	@Autowired
	private SkTechnologyRepository skTechnologyRepository;

	@Override
	public List<Empleado> findEmpleadosByTechnology(String sktechnology) {
		List<SkTechnology> skTechnologies = skTechnologyRepository.findEmpleadosByTechnology(sktechnology);
		List<Empleado> empleados = new ArrayList<Empleado>();
		for(SkTechnology skTechnology : skTechnologies) {
			empleados.add(skTechnology.getEmpleado());
		}
		return empleados;	
	}

	@Override
	public List<Empleado> findEmpleadosByTechnologyAndLvl(String sktechnology, int nivel) {
		List<SkTechnology> skTechnologies = skTechnologyRepository.findEmpleadosByTechnologyAndLvl(sktechnology, nivel);
		List<Empleado> empleados = new ArrayList<Empleado>();
		for(SkTechnology skTechnology : skTechnologies) {
			empleados.add(skTechnology.getEmpleado());
		}
		return empleados;
	}
}
