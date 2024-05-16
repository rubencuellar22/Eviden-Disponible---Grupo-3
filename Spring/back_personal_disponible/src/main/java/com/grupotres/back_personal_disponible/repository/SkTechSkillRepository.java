package com.grupotres.back_personal_disponible.repository;

import com.grupotres.back_personal_disponible.model.SkTechSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkTechSkillRepository extends JpaRepository<SkTechSkill, Integer> {

    @Query("SELECT t FROM SkTechSkill t WHERE t.skTechSkill = :skTechSkill")
    List<SkTechSkill> findBySkTechSkill(String skTechSkill);
}
