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
import com.grupotres.back_personal_disponible.service.SkBussSkillService;

@RestController
@RequestMapping("/empleado/skBussSkill")
public class SkBussSkillRestController {

	@Autowired
	private SkBussSkillService skBussSkillService;

	@GetMapping("/{skBussSkill}")
	public ResponseEntity<?>getEmpleadosByBussSkill(@PathVariable String skBussSkill) {
		List<Empleado> empleados = skBussSkillService.findEmpleadosByBussSkill(skBussSkill);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
	
	
	
}
