package com.grupotres.back_personal_disponible.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupotres.back_personal_disponible.model.JobTechnologyProfile;
import com.grupotres.back_personal_disponible.model.SkLenguage;

public interface JobTechnologyProfileRepository extends JpaRepository<JobTechnologyProfile, Integer>{

	@Query
	("SELECT jobp FROM JobTechnologyProfile jobp WHERE jobp.jobTechnologyProfile = ?1")
	public List<JobTechnologyProfile> findByJobTechnologyProfile(String jobTechnologyProfile);

}
