package com.grupotres.back_personal_disponible.serviceImplMy8;


import com.grupotres.back_personal_disponible.model.SkTechSkill;
import com.grupotres.back_personal_disponible.repository.SkTechSkillRepository;
import com.grupotres.back_personal_disponible.service.SkTechSkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkTechSkillServiceImpl implements SkTechSkillService {

    private final SkTechSkillRepository skTechSkillRepository;

    @Autowired
    public SkTechSkillServiceImpl(SkTechSkillRepository skTechSkillRepository) {
        this.skTechSkillRepository = skTechSkillRepository;
    }

    @Override
    public List<SkTechSkill> findBySkTechSkill(String skTechSkill) {
        return skTechSkillRepository.findBySkTechSkill(skTechSkill);
    }
    
    @Override
    public List<SkTechSkill> findBySkTechSkillAndNivel(String skTechSkill, int nivel) {
        return skTechSkillRepository.findBySkTechSkillAndNivel(skTechSkill, nivel);
    }
}
