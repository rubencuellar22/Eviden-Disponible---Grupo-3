package com.grupotres.back_personal_disponible.restController;



import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkTechSkill;
import com.grupotres.back_personal_disponible.model.dto.EmpleadoDTO;
import com.grupotres.back_personal_disponible.service.EmpleadoService;
import com.grupotres.back_personal_disponible.service.SkTechSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empleado/skTechskill")
public class SkTechSkillRestController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
    private SkTechSkillService skTechSkillService;

    @GetMapping("/{skTechSkill}")
    public ResponseEntity<?> findBySkTechSkill(@PathVariable String skTechSkill){
		List<Empleado> empleados = skTechSkillService.findBySkTechSkill(skTechSkill);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
    
    @PostMapping("/{skTechSkill}")
	public ResponseEntity<?> findEmpleadosByCertifNombre(@PathVariable String skTechSkill, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
	    List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosBySkTechSkillFromList(empleadosFiltradosDTO, skTechSkill);
	    return ResponseEntity.ok(empleadosDTOFiltrados);
    }

    @GetMapping("/{skTechSkill}/{nivel}")
    public ResponseEntity<?> findBySkTechSkillAndNivel(@PathVariable String skTechSkill, @PathVariable Integer nivel){
		List<Empleado> empleados = skTechSkillService.findBySkTechSkillAndNivel(skTechSkill, nivel);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
    
    @PostMapping("/{skTechSkill}/{nivel}")
	public ResponseEntity<?> findBySkTechSkillAndNivel(@PathVariable String skTechSkill, @PathVariable Integer nivel, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
	    List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosBySkTechSkillAndNivelFromList(empleadosFiltradosDTO, skTechSkill, nivel);
	    return ResponseEntity.ok(empleadosDTOFiltrados);
    }
}
