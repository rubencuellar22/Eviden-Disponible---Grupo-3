package com.grupotres.back_personal_disponible.serviceImplMy8;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.Role;
import com.grupotres.back_personal_disponible.repository.RoleRepository;
import com.grupotres.back_personal_disponible.service.RoleService;
 
@Service
public class RolServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Empleado> findEmpleadosByRole(String role) {
		return roleRepository.findEmpleadosByRole(role);
	}

	@Override
	public List<Empleado> findEmpleadosByRoleAndNivel(String role, Integer nivel) {
		return roleRepository.findEmpleadosByRoleAndNivel(role, nivel);
	}
 
	
 
}