package com.grupotres.back_personal_disponible.serviceImplMy8;

import java.util.List;

import com.grupotres.back_personal_disponible.model.SkTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.repository.SkTechnologyRepository;
import com.grupotres.back_personal_disponible.service.SkTechnologyService;

@Service
public class TecnologiaServiceImpl implements SkTechnologyService {
	@Autowired
	private SkTechnologyRepository skTechnologyRepository;

	@Override
	public List<Empleado> findEmpleadosByTechnology(String nombreTechnology) {
		return skTechnologyRepository.findEmpleadosByTechnology(nombreTechnology);
	}

	@Override
	public List<Empleado> findEmpleadosByTechnologyAndNivel(String nombreTechnology, int nivel) {
		return skTechnologyRepository.findEmpleadosByTechnologyAndNivel(nombreTechnology, nivel);
	}

	@Override
	public void saveAllSkTechnologies(List<SkTechnology> empSkTechnologies) {
		skTechnologyRepository.saveAll(empSkTechnologies);
	}

	@Override
	public void deleteAllSkTechnologies() {
		skTechnologyRepository.deleteAllInBatch();
	}
}
