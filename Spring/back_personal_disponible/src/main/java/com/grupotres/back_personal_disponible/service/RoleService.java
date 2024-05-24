package com.grupotres.back_personal_disponible.service;
 
import java.util.List;

import org.springframework.stereotype.Service;
import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.Role;

import com.grupotres.back_personal_disponible.model.Empleado;
 
@Service
public interface RoleService {

	List<Empleado> findEmpleadosByRole(String role);

	List<Empleado> findEmpleadosByRoleAndNivel(String role, Integer nivel);
	
	public List<Empleado> findEmpleadosByRole(String role);

    void saveRole(Role role);

    public Role getRoleById(Long id);

    boolean existsRoleForEmp(Long gin);

    void deleteRole(Role empRole);

    void deleteAllRoles();
}
