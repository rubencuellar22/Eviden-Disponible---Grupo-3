package com.grupotres.back_personal_disponible.serviceImplMy8;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.JobTechnologyProfile;
import com.grupotres.back_personal_disponible.repository.JobTechnologyProfileRepository;
import com.grupotres.back_personal_disponible.service.JobTechnologyProfileService;
 
@Service
public class JobTechnologyProfileServiceImpl implements JobTechnologyProfileService {
 
	@Autowired
	private JobTechnologyProfileRepository jobTechnologyProfileRepository;
 
	@Override
	public List<Empleado> findByJobTechnologyProfile(String jobTechnologyProfile) {
		return jobTechnologyProfileRepository.findByJobTechnologyProfile(jobTechnologyProfile);
	}

	@Override
	public List<Empleado> findByJobTechnologyProfileAndLvl(String jobTechnologyProfile, int nivel) {
		return jobTechnologyProfileRepository.findByJobTechnologyProfileAndLvl(jobTechnologyProfile, nivel);
	}
	
	@Override
	public void saveAllJobTechnologyProfiles(List<JobTechnologyProfile> jobTechnologyProfiles) {
		jobTechnologyProfileRepository.saveAll(jobTechnologyProfiles);
	}

	@Override
	public void deleteAllJobTechnologyProfiles() {
		jobTechnologyProfileRepository.deleteAllInBatch();
	}

}
