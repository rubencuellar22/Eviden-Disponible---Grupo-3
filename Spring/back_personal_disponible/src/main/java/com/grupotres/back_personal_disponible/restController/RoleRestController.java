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
import com.grupotres.back_personal_disponible.service.RoleService;
 
@RestController
@RequestMapping("/empleado/role")
public class RoleRestController {
 
	@Autowired
	private RoleService roleService;
	@GetMapping("/{role}")
	public ResponseEntity<?>getEmpleadosByRole(@PathVariable String role) {
		List<Empleado> empleados = roleService.findEmpleadosByRole(role);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
}