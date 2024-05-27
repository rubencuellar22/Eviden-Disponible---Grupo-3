package com.grupotres.back_personal_disponible.service;
 
import java.util.List;

import org.springframework.stereotype.Service;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.Role;
 
@Service
public interface RoleService {

	List<Empleado> findEmpleadosByRole(String role);

	List<Empleado> findEmpleadosByRoleAndNivel(String role, Integer nivel);

	List<Role> selectAllRoles();
	
}
