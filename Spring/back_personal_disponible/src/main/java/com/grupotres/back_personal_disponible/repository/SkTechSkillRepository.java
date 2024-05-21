package com.grupotres.back_personal_disponible.repository;

import com.grupotres.back_personal_disponible.model.SkTechSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkTechSkillRepository extends JpaRepository<SkTechSkill, Integer> {

    @Query("SELECT sts FROM SkTechSkill sts WHERE sts.skTechSkill = ?1")
    List<SkTechSkill> findBySkTechSkill(String sktechskill);

    @Query("SELECT sts FROM SkTechSkill sts WHERE sts.skTechSkill = ?1 and sts.nivel = ?2")
	List<SkTechSkill> findBySkTechSkillAndLvl(String sktechskill, int nivel);

}
