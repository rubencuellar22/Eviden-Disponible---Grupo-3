package com.grupotres.back_personal_disponible.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.service.RoleService;

@RestController
@RequestMapping("/empleado/role")
public class RoleRestController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping("/{role}")
	public List<Empleado> getEmpleadosByRole(@PathVariable String role) {
	    return roleService.findEmpleadosByRole(role);
	}
}
