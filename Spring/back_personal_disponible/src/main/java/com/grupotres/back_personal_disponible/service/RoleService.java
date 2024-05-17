package com.grupotres.back_personal_disponible.service;

import java.util.List;

import com.grupotres.back_personal_disponible.model.Empleado;

public interface RoleService {

	public List<Empleado> findEmpleadosByRole(String role);
	
}
