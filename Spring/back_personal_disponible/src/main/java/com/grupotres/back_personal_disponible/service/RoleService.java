package com.grupotres.back_personal_disponible.service;
 
import java.util.List;

import org.springframework.stereotype.Service;

import com.grupotres.back_personal_disponible.model.Empleado;
 
@Service
public interface RoleService {

	List<Empleado> findEmpleadosByRole(String role);

	List<Empleado> findEmpleadosByRoleAndNivel(String role, Integer nivel);
	
}
