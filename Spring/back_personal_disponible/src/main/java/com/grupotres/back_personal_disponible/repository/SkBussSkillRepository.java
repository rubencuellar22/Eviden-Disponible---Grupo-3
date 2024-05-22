package com.grupotres.back_personal_disponible.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupotres.back_personal_disponible.model.SkBusSkill;


public interface SkBussSkillRepository extends JpaRepository<SkBusSkill, Integer>{
	
	@Query("SELECT skb FROM SkBusSkill skb WHERE skb.skBusSkill = ?1")
	List<SkBusSkill> findBySkBussSkill(String skBusSkill);
	

	@Query("SELECT skb FROM SkBusSkill skb WHERE skb.skBusSkill = ?1 and skb.nivel = ?2")
	List<SkBusSkill> findBySkBussSkillAndLvl(String skBusSkill,int nivel);
}
