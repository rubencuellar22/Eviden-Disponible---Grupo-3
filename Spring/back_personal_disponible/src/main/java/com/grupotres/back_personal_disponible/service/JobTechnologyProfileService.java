package com.grupotres.back_personal_disponible.service;
 
import java.util.List;

import org.springframework.stereotype.Service;

import com.grupotres.back_personal_disponible.model.Empleado;
 
@Service
public interface JobTechnologyProfileService {
	
	List<Empleado> findByJobTechnologyProfile(String jobTechnologyProfile);
 
	List<Empleado> findByJobTechnologyProfileAndLvl(String jobTechnologyProfile, int nivel);
 
}
