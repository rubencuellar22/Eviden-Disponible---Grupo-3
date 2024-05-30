package com.grupotres.back_personal_disponible.restController;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.JobTechnologyProfile;
import com.grupotres.back_personal_disponible.model.SkBusSkill;
import com.grupotres.back_personal_disponible.model.dto.EmpleadoDTO;
import com.grupotres.back_personal_disponible.model.dto.JobTechnologyProfileDTO;
import com.grupotres.back_personal_disponible.model.dto.SkBusSkillDTO;
import com.grupotres.back_personal_disponible.service.EmpleadoService;
import com.grupotres.back_personal_disponible.service.SkBussSkillService;


@RestController
@RequestMapping("/empleado/skBussskill")
@CrossOrigin(origins = "*")
public class SkBussSkillRestController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
    private SkBussSkillService skBussSkillService;
	
	@GetMapping("/todos")
	public ResponseEntity<List<SkBusSkillDTO>> selectAllSkBusSkills() {
        List<SkBusSkill> skBusSkills = skBussSkillService.selectAllSkBusSkills();
        List<SkBusSkillDTO> skBusSkillsDTO = new ArrayList<>();
        for (SkBusSkill skBusSkill : skBusSkills) {
            skBusSkillsDTO.add(new SkBusSkillDTO(skBusSkill));
        }
        return ResponseEntity.ok(skBusSkillsDTO);
    }
	
	 @GetMapping("/{nombre}")
	 public ResponseEntity<?> findEmpleadosByBussSkill(@PathVariable String nombre) {
	 List<Empleado> empleados = skBussSkillService.findEmpleadosByBussSkill(nombre);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	 }
	 
	 @PostMapping("/{nombre}")
		public ResponseEntity<?> findEmpleadosByBussSkill(@PathVariable String nombre, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
		    List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosBySkBussSkillFromList(empleadosFiltradosDTO, nombre);
		    return ResponseEntity.ok(empleadosDTOFiltrados);
	 }

	 @GetMapping("/{nombre}/{nivel}")
	 public ResponseEntity<?> findEmpleadosByBussSkillAndNivel(@PathVariable String nombre, @PathVariable Integer nivel) {
	 List<Empleado> empleados = skBussSkillService.findEmpleadosByBussSkillAndNivel(nombre, nivel);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	 }

	 @PostMapping("/{nombre}/{nivel}")
		public ResponseEntity<?> findEmpleadosByBussSkillAndNivel(@PathVariable String nombre, @PathVariable Integer nivel, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
		    List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosBySkBussSkillAndNivelFromList(empleadosFiltradosDTO, nombre, nivel);
		    return ResponseEntity.ok(empleadosDTOFiltrados);
	 }
	 
}
