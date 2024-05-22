package com.grupotres.back_personal_disponible.service;

import java.util.List;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.JobTechnologyProfile;

public interface JobTechnologyProfileService {
	
	public List<Empleado> findEmpleadosByJobTechnologyProfile(String jobTechnologyProfile);

	public void saveAllJobTechnologyProfiles(List<JobTechnologyProfile> jobTechnologyProfiles);

}
