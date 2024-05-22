package com.grupotres.back_personal_disponible.batch.steps;

import com.grupotres.back_personal_disponible.model.*;
import com.grupotres.back_personal_disponible.service.*;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemWriterStep implements Tasklet {

    @Autowired
    private JobTechnologyProfileService jobTechnologyProfileService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private SkLenguageService skLenguageService;

    @Autowired
    private SkMethodService skMethodService;

    @Autowired
    private SkTechSkillService skTechSkillService;

    @Autowired
    private SkCertifService skCertifService;

    @Autowired
    private SkTechnologyService skTechnologyService;

    @Autowired
    private SkBussSkillService skBusSkillService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        List<Empleado> empleadoListFinal = (List<Empleado>) chunkContext
                .getStepContext()
                .getJobExecutionContext()
                .get("empleadoListFinal");

        List<Empleado> empleadoList = (List<Empleado>) chunkContext
                .getStepContext()
                .getJobExecutionContext()
                .get("empleadoList");

        for (Empleado empleado : empleadoList) {
            Empleado empleadoFinal = empleadoListFinal.stream()
                    .filter(emp -> emp.getGin().equals(empleado.getGin()))
                    .findFirst()
                    .orElse(null);

            List<JobTechnologyProfile> empJobTechnologyProfiles = empleado.getJobTechnologyProfiles();
            for (JobTechnologyProfile jobTechnologyProfile : empJobTechnologyProfiles) {
                jobTechnologyProfile.setEmpleado(empleadoFinal);
            }
            jobTechnologyProfileService.saveAllJobTechnologyProfiles(empJobTechnologyProfiles);

            assert empleadoFinal != null;
            Role empRole = roleService.getRoleById(empleadoFinal.getRole().getIdRole());
            empRole.setEmpleado(empleadoFinal);
            roleService.saveRole(empRole);

            List<SkLenguage> empSkLenguages = empleado.getSkLenguages();
            for (SkLenguage skLenguage : empSkLenguages) {
                skLenguage.setEmpleado(empleadoFinal);
            }
            skLenguageService.saveAllSkLenguages(empSkLenguages);

            List<SkMethod> empSkMethods = empleado.getSkMethods();
            for (SkMethod skMethod : empSkMethods) {
                skMethod.setEmpleado(empleadoFinal);
            }
            skMethodService.saveAllSkMethods(empSkMethods);

            List<SkTechSkill> empSkTechSkills = empleado.getSkTechSkills();
            for (SkTechSkill skTechSkill : empSkTechSkills) {
                skTechSkill.setEmpleado(empleadoFinal);
            }
            skTechSkillService.saveAllSkTechSkills(empSkTechSkills);

            List<SkCertif> empSkCertifs = empleado.getSkCertifs();
            for (SkCertif skCertif : empSkCertifs) {
                skCertif.setEmpleado(empleadoFinal);
            }
            skCertifService.saveAllSkCertifs(empSkCertifs);

            List<SkTechnology> empSkTechnologies = empleado.getSkTechnologies();
            for (SkTechnology skTechnology : empSkTechnologies) {
                skTechnology.setEmpleado(empleadoFinal);
            }
            skTechnologyService.saveAllSkTechnologies(empSkTechnologies);

            List<SkBusSkill> empSkBussSkills = empleado.getSkBusSkills();
            for (SkBusSkill skBusSkill : empSkBussSkills) {
                skBusSkill.setEmpleado(empleadoFinal);
            }
            skBusSkillService.saveAllSkBusSkills(empSkBussSkills);
        }
        
        return RepeatStatus.FINISHED;
    }
}
