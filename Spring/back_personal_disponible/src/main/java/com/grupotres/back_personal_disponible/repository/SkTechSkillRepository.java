package com.grupotres.back_personal_disponible.repository;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkTechSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkTechSkillRepository extends JpaRepository<SkTechSkill, Integer> {

    @Query("SELECT t.empleado FROM SkTechSkill t WHERE t.skTechSkill = :skTechSkill")
    List<Empleado> findBySkTechSkill(String skTechSkill);

    // Nueva consulta para buscar por habilidad técnica y nivel
    @Query("SELECT t.empleado FROM SkTechSkill t WHERE t.skTechSkill = :skTechSkill AND t.nivel = :nivel")
    List<Empleado> findBySkTechSkillAndNivel(@Param("skTechSkill") String skTechSkill, @Param("nivel") int nivel);

}
