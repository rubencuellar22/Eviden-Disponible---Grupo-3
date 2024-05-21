package com.grupotres.back_personal_disponible.restController;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.dto.EmpleadoDTO;
import com.grupotres.back_personal_disponible.service.SkTechSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empleado/sk_techskills")
public class SkTechSkillRestController {

	@Autowired
    private SkTechSkillService skTechSkillService;

    @GetMapping("/{skTechSkill}")
    public ResponseEntity<?> getEmpleadoBySkTechSkill(@PathVariable String sktechskill){
		List<Empleado> empleados = skTechSkillService.findEmpleadosBySkTechSkill(sktechskill);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
   
    // Nueva consulta por habilidad técnica y nivel
    @GetMapping("/{skTechSkill}/{nivel}")
    public ResponseEntity<?> getEmpleadoBySkTechSkillAndLvl(@PathVariable String sktechskill, @PathVariable Integer nivel){
		List<Empleado> empleados = skTechSkillService.findEmpleadosBySkTechSkillAndLvl(sktechskill, nivel);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
}
