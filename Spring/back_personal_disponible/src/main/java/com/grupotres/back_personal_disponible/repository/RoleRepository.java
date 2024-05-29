package com.grupotres.back_personal_disponible.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.Role;
import com.grupotres.back_personal_disponible.model.SkLenguage;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query
	("SELECT r.empleado FROM Role r WHERE r.role = ?1")
	List<Empleado> findEmpleadosByRole(String role);
	
	@Query
	("SELECT r.empleado FROM Role r WHERE r.role = ?1 AND r.nivel = ?2")
	List<Empleado> findEmpleadosByRoleAndNivel(String role, int nivel);
	
	@Query
	("SELECT r FROM Role r WHERE r.role = ?1")
	public List<Role> findByRole(String role);

	@Query("SELECT r FROM Role r WHERE r.empleado.gin = ?1")
	Role findByEmpleadoGin(Long gin);

	@Transactional
	@Modifying
	@Query("DELETE FROM Role r WHERE r.idRole = ?1")
	public void deleteById(Long idRole);
	
	@Query
	("SELECT r FROM Role r")
	List<Role> selectAllRoles();

}
