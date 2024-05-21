package com.grupotres.back_personal_disponible.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.service.JobTechnologyProfileService;

@RestController
@RequestMapping("/empleado/job_technology_profile/jobTechnologyProfile")
public class JobTechProfRestController {


	@Autowired
	private JobTechnologyProfileService jobTechnologyProfileService;
	
	@GetMapping("/{jobTechnologyProfile}")
	public List<Empleado> getEmpleadosByJobTechnologyProfile(@PathVariable String jobTechnologyProfile) {
	    return jobTechnologyProfileService.findEmpleadosByJobTechnologyProfile(jobTechnologyProfile);
	}
}
