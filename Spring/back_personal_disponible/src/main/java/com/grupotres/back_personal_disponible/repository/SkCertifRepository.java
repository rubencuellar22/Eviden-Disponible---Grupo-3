package com.grupotres.back_personal_disponible.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.grupotres.back_personal_disponible.model.SkCertif;


public interface SkCertifRepository extends JpaRepository<SkCertif, Integer> {
	
	@Query("SELECT skc FROM SkCertif skc WHERE skc.skcertif = ?1")
	List<SkCertif> findBySkCertif(String skcertif);
	
	@Query("SELECT skc FROM SkCertif skc WHERE skc.skcertif = ?1 and skc.external = ?2")
	List<SkCertif> findBySkCertifAndExternal(String skcertif, boolean external);
	
}


