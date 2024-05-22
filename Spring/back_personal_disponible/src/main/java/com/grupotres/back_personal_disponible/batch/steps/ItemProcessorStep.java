package com.grupotres.back_personal_disponible.batch.steps;

import com.grupotres.back_personal_disponible.model.*;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.ArrayList;
import java.util.List;

public class ItemProcessorStep implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        List<Empleado> empleadoList = (List<Empleado>) chunkContext
                .getStepContext()
                .getJobExecutionContext()
                .get("empleadoList");

        List<Grupo> grupoList = new ArrayList<>();
        List<JobTechnologyProfile> jobTechnologyProfileList = new ArrayList<>();
        List<Role> roleList = new ArrayList<>();
        List<SkLenguage> skLenguageList = new ArrayList<>();
        List<SkMethod> skMethodList = new ArrayList<>();
        List<SkTechSkill> skTechSkillList = new ArrayList<>();
        List<SkCertif> skCertifList = new ArrayList<>();
        List<SkTechnology> skTechnologyList = new ArrayList<>();
        List<SkBusSkill> skBussSkillList = new ArrayList<>();

        for (Empleado emp : empleadoList) {
            grupoList.add(emp.getGrupo());

            List<JobTechnologyProfile> jobTechnologyProfiles = emp.getJobTechnologyProfiles();
            for (JobTechnologyProfile jobTechnologyProfile : jobTechnologyProfiles) {
                jobTechnologyProfile.setEmpleado(emp);
                jobTechnologyProfileList.add(jobTechnologyProfile);
            }

            roleList.add(emp.getRole());

            List<SkLenguage> skLenguages = emp.getSkLenguages();
            for (SkLenguage skLenguage : skLenguages) {
                skLenguage.setEmpleado(emp);
                skLenguageList.add(skLenguage);
            }

            List<SkMethod> skMethods = emp.getSkMethods();
            for (SkMethod skMethod : skMethods) {
                skMethod.setEmpleado(emp);
                skMethodList.add(skMethod);
            }

            List<SkTechSkill> skTechSkills = emp.getSkTechSkills();
            for (SkTechSkill skTechSkill : skTechSkills) {
                skTechSkill.setEmpleado(emp);
                skTechSkillList.add(skTechSkill);
            }

            List<SkCertif> skCertifs = emp.getSkCertifs();
            for (SkCertif skCertif : skCertifs) {
                skCertif.setEmpleado(emp);
                skCertifList.add(skCertif);
            }

            List<SkTechnology> skTechnologies = emp.getSkTechnologies();
            for (SkTechnology skTechnology : skTechnologies) {
                skTechnology.setEmpleado(emp);
                skTechnologyList.add(skTechnology);
            }

            List<SkBusSkill> skBussSkills = emp.getSkBusSkills();
            for (SkBusSkill skBussSkill : skBussSkills) {
                skBussSkill.setEmpleado(emp);
                skBussSkillList.add(skBussSkill);
            }

        }


        return RepeatStatus.FINISHED;
    }
}
