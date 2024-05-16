package com.grupotres.back_personal_disponible.restController;



import com.grupotres.back_personal_disponible.model.SkTechSkill;
import com.grupotres.back_personal_disponible.service.SkTechSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empleado/sk_techskills")
public class SkTechSkillRestController {

    private final SkTechSkillService skTechSkillService;

    @Autowired
    public SkTechSkillRestController(SkTechSkillService skTechSkillService) {
        this.skTechSkillService = skTechSkillService;
    }

    @GetMapping("/{skill}")
    public List<SkTechSkill> findBySkill(@PathVariable("skill") String skill) {
        return skTechSkillService.findBySkTechSkill(skill);
    }
    
    // Nueva consulta por habilidad técnica y nivel
    @GetMapping("/{skill}/{nivel}")
    public List<SkTechSkill> findBySkillAndNivel(@PathVariable("skill") String skill, @PathVariable("nivel") int nivel) {
        return skTechSkillService.findBySkTechSkillAndNivel(skill, nivel);
    }
}
