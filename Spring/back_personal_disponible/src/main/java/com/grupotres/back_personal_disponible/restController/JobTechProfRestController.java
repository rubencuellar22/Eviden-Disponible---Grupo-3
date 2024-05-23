package com.grupotres.back_personal_disponible.restController;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.dto.EmpleadoDTO;
import com.grupotres.back_personal_disponible.service.JobTechnologyProfileService;
 
@RestController
@RequestMapping("/empleado/job_technology_profile")
public class JobTechProfRestController {
 
	@Autowired
	private JobTechnologyProfileService jobTechnologyProfileService;
	@GetMapping("/{jobtechnologyprofile}")
	public ResponseEntity<?>getEmpleadosByJobTechnologyProfile(@PathVariable String jobtechnologyprofile) {
		List<Empleado> empleados = jobTechnologyProfileService.findEmpleadosByJobTechnologyProfile(jobtechnologyprofile);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
	@GetMapping("/{jobtechnologyprofile}/{nivel}")
	public ResponseEntity<?>getEmpleadosByJobTechnologyProfileAndLvl(@PathVariable String jobtechnologyprofile, @PathVariable String nivel) {
		List<Empleado> empleados = jobTechnologyProfileService.findEmpleadosByJobTechnologyProfileAndLvl(jobtechnologyprofile, nivel);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
}