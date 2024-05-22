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
		List<Role> roles = roleRepository.findByRole(role);
		List<Empleado> empleados = new ArrayList<Empleado>();
		for(Role role2 : roles) {
			empleados.add(role2.getEmpleado());
		}
		return empleados;
	}

	@Override
	public void saveRole(Role role) {
		roleRepository.save(role);
	}

	@Override
	public Role getRoleById(Long id) {
		return roleRepository.findById(id).orElse(null);
	}

}
