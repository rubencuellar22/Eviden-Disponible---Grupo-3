package com.grupotres.back_personal_disponible.service;

import java.util.List;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.Role;

public interface RoleService {

	public List<Empleado> findEmpleadosByRole(String role);

    void saveRole(Role role);

    public Role getRoleById(Long id);
}
