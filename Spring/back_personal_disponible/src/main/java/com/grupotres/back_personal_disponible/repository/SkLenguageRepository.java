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
	("SELECT sk FROM SkLenguage sk WHERE sk.sklenguage = ?1")
	public List<SkLenguage> findBySkLenguage(String sklenguage);
	
	
}
