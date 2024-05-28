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

	@Override
	public List<Role> selectAllRoles() {
		return roleRepository.selectAllRoles();
	}
 
	@Override
	public void saveRole(Role role) {
		roleRepository.save(role);
	}

	@Override
	public Role getRoleById(Long id) {
		return roleRepository.findById(id).orElse(null);
	}

	@Override
	public boolean existsRoleForEmp(Long gin) {
        return roleRepository.findByEmpleadoGin(gin) != null;
    }

	@Override
	public void deleteRole(Role empRole) {
		roleRepository.deleteById(empRole.getIdRole());
	}

	@Override
	public void deleteAllRoles() {
		roleRepository.deleteAllInBatch();
	}

}
