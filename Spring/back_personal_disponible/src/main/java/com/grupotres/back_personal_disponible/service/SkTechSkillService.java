package com.grupotres.back_personal_disponible.service;

import com.grupotres.back_personal_disponible.model.SkTechSkill;

import java.util.List;

public interface SkTechSkillService {
    List<SkTechSkill> findBySkTechSkill(String skTechSkill);
}
