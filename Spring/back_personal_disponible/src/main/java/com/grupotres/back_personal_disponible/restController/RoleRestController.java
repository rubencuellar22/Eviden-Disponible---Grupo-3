package com.grupotres.back_personal_disponible.restController;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.dto.EmpleadoDTO;
import com.grupotres.back_personal_disponible.service.EmpleadoService;
import com.grupotres.back_personal_disponible.service.RoleService;
 
@RestController
@RequestMapping("/empleado/role")
public class RoleRestController {
 
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("/{role}")
	public ResponseEntity<?> findEmpleadosByRole(@PathVariable String role) {
		List<Empleado> empleados = roleService.findEmpleadosByRole(role);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}

	@PostMapping("/{role}")
	public ResponseEntity<?> findEmpleadosByRole(@PathVariable String role, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
	    List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosByRoleFromList(empleadosFiltradosDTO, role);
	    return ResponseEntity.ok(empleadosDTOFiltrados);
	}
	
	@GetMapping("/{role}/{nivel}")
	public ResponseEntity<?> findEmpleadosByRoleAndNivel(@PathVariable String role, @PathVariable Integer nivel) {
		List<Empleado> empleados = roleService.findEmpleadosByRoleAndNivel(role, nivel);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
	
	@PostMapping("/{role}/{nivel}")
	public ResponseEntity<?> findEmpleadosByRoleAndNivel(@PathVariable String role, @PathVariable Integer nivel, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
	    List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosByRoleAndNivelFromList(empleadosFiltradosDTO, role, nivel);
	    return ResponseEntity.ok(empleadosDTOFiltrados);
	}
}