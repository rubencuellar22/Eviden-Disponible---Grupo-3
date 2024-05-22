package com.grupotres.back_personal_disponible.serviceImplMy8;
 
import java.util.ArrayList;
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
	public List<Empleado> findEmpleadosByJobTechnologyProfile(String jobtechnologyprofile) {
		List<JobTechnologyProfile> jobTechnologyProfiles = jobTechnologyProfileRepository.findByJobTechnologyProfile(jobtechnologyprofile);
		List<Empleado> empleados = new ArrayList<Empleado>();
		for(JobTechnologyProfile jobTechnologyProfile : jobTechnologyProfiles) {
			empleados.add(jobTechnologyProfile.getEmpleado());
		}
		return empleados;
	}
	@Override
	public List<Empleado> findEmpleadosByJobTechnologyProfileAndLvl(String jobtechnologyprofile, String nivel) {
		List<JobTechnologyProfile> jobTechnologyProfiles = jobTechnologyProfileRepository.findByJobTechnologyProfileAndLvl(jobtechnologyprofile, nivel);
		List<Empleado> empleados = new ArrayList<Empleado>();
		for(JobTechnologyProfile jobTechnologyProfile : jobTechnologyProfiles) {
			empleados.add(jobTechnologyProfile.getEmpleado());
		}
		return empleados;
	}
 
}