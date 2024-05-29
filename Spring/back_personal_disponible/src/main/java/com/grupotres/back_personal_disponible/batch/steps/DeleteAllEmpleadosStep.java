package com.grupotres.back_personal_disponible.batch.steps;

import com.grupotres.back_personal_disponible.model.JobTechnologyProfile;
import com.grupotres.back_personal_disponible.service.*;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteAllEmpleadosStep implements Tasklet {

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private JobTechnologyProfileService jobTechnologyProfileService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private SkBussSkillService skBussSkillService;

    @Autowired
    private SkCertifService skCertifService;

    @Autowired
    private SkLenguageService skLenguageService;

    @Autowired
    private SkMethodService skMethodService;

    @Autowired
    private SkTechnologyService skTechnologyService;

    @Autowired
    private SkTechSkillService skTechSkillService;

    @Autowired
    private EmpleadoService empleadoService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        jobTechnologyProfileService.deleteAllJobTechnologyProfiles();
        roleService.deleteAllRoles();
        skBussSkillService.deleteAllSkBussSkills();
        skCertifService.deleteAllSkCertifs();
        skLenguageService.deleteAllSkLenguages();
        skMethodService.deleteAllSkMethods();
        skTechnologyService.deleteAllSkTechnologies();
        skTechSkillService.deleteAllSkTechSkills();
        empleadoService.deleteAllEmpleados();
        grupoService.deleteAllGrupos();

        return RepeatStatus.FINISHED;
    }
}
