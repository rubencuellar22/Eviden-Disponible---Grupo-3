package com.grupotres.back_personal_disponible.repository;
 
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.JobTechnologyProfile;

public interface JobTechnologyProfileRepository extends JpaRepository<JobTechnologyProfile, Integer>{
 
	@Query
	("SELECT jobp.empleado FROM JobTechnologyProfile jobp WHERE jobp.jobTechnologyProfile = ?1")
	List<Empleado> findByJobTechnologyProfile(String jobTechnologyProfile);
 
	@Query
	("SELECT jobp.empleado FROM JobTechnologyProfile jobp WHERE jobp.jobTechnologyProfile = ?1 and jobp.nivel = ?2")
	List<Empleado> findByJobTechnologyProfileAndLvl(String jobTechnologyProfile, int nivel);

	@Query
	("SELECT jobp FROM JobTechnologyProfile jobp")
    List<JobTechnologyProfile> selectAllJobTechnologyProfile();
	
	@Query("SELECT DISTINCT jtp.jobTechnologyProfile FROM JobTechnologyProfile jtp WHERE jtp.jobTechnologyProfile LIKE %:query% AND jtp.jobTechnologyProfile = :profile")
    List<String> findAutocompleteOptions(String profile, String query);



 
	
}
