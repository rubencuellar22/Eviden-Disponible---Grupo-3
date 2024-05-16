package com.grupotres.back_personal_disponible.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkLenguage;

@Repository
public interface SkLenguageRepository extends JpaRepository<SkLenguage, Integer>{

	@Query
	("SELECT sk FROM SkLenguage sk JOIN sk.empleado e WHERE e.gin = ?1 AND sk.sklenguage = ?2")
	public List<SkLenguage> findByEmpleadoGinAndSklenguage(Integer gin, String sklenguage);

	@Query
	("SELECT sk FROM SkLenguage sk WHERE sk.sklenguage = ?1")
	public List<SkLenguage> findBySkLenguage(String sklenguage);
	
	
	/*@Query
	("SELECT sk from SkLenguage sk where sk.gin = ?1 and sk.sklenguage = ?2 ")
	public List<SkLenguage> findByEmpleadoGinAndSklenguage(Integer gin, String sklenguage);*/

	
}
