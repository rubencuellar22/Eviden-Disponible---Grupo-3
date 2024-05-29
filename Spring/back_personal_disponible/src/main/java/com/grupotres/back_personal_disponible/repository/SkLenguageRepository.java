package com.grupotres.back_personal_disponible.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupotres.back_personal_disponible.model.SkCertif;
import com.grupotres.back_personal_disponible.model.SkLenguage;

@Repository
public interface SkLenguageRepository extends JpaRepository<SkLenguage, Integer>{

	@Query
	("SELECT sk FROM SkLenguage sk WHERE sk.sklenguage = ?1")
	public List<SkLenguage> findBySkLenguage(String sklenguage);
	
	@Query
	("SELECT sk FROM SkLenguage sk Where sk.sklenguage = ?1 and sk.nivel = ?2")
	public List<SkLenguage> findBySkLenguageAndLvl(String sklenguage, String nivel);

	@Query
	("SELECT sk FROM SkLenguage sk")
    List<SkLenguage> selectAllSkLenguages();
	
	@Query("SELECT s FROM SkLenguage s WHERE s.sklenguage LIKE %:nombre%")
    List<SkLenguage> findByNombreContaining(@Param("nombre") String nombre);
}
