package com.grupotres.back_personal_disponible.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.Role;
import com.grupotres.back_personal_disponible.model.SkLenguage;

public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query
	("SELECT r.empleado FROM Role r WHERE r.role = ?1")
	List<Empleado> findEmpleadosByRole(String role);
	
	@Query
	("SELECT r.empleado FROM Role r WHERE r.role = ?1 AND r.nivel = ?2")
	List<Empleado> findEmpleadosByRoleAndNivel(String role, int nivel);

}
