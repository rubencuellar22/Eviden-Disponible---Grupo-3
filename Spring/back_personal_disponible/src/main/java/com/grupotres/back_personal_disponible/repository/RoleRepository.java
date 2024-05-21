package com.grupotres.back_personal_disponible.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.grupotres.back_personal_disponible.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query
	("SELECT r FROM Role r WHERE r.role = ?1")
	public List<Role> findByRole(String role);
	
}
