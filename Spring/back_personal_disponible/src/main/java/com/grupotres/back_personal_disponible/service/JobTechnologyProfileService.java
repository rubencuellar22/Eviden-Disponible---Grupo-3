package com.grupotres.back_personal_disponible.service;
 
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.JobTechnologyProfile;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.JobTechnologyProfile;
 
@Service
public interface JobTechnologyProfileService {
	
	List<Empleado> findByJobTechnologyProfile(String jobTechnologyProfile);
 
	List<Empleado> findByJobTechnologyProfileAndLvl(String jobTechnologyProfile, int nivel);

	public void saveAllJobTechnologyProfiles(List<JobTechnologyProfile> jobTechnologyProfiles);

    void deleteAllJobTechnologyProfiles();
	
	List<JobTechnologyProfile> selectAllJobTechnologyProfile();

	List<String> findAutocompleteOptions(String profile, String query);



	
}
