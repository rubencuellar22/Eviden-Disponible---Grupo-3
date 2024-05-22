package com.grupotres.back_personal_disponible.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkLenguage;

@Service
public interface SkLenguageService {

	public List<Empleado> findEmpleadosBySkLenguage(String sklenguage);
	
	public List<SkLenguage> getSkLenguagesByLenguageAndLvl(String sklenguage,String nivel);

    void saveAllSkLenguages(List<SkLenguage> empSkLenguages);
}
