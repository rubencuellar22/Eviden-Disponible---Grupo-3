package com.grupotres.back_personal_disponible.batch.steps;

import com.grupotres.back_personal_disponible.model.*;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
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
            jobTechnologyProfileList.addAll(jobTechnologyProfiles);

            roleList.add(emp.getRole());

            List<SkLenguage> skLenguages = emp.getSkLenguages();
            skLenguageList.addAll(skLenguages);

            List<SkMethod> skMethods = emp.getSkMethods();
            skMethodList.addAll(skMethods);

            List<SkTechSkill> skTechSkills = emp.getSkTechSkills();
            skTechSkillList.addAll(skTechSkills);

            List<SkCertif> skCertifs = emp.getSkCertifs();
            skCertifList.addAll(skCertifs);

            List<SkTechnology> skTechnologies = emp.getSkTechnologies();
            skTechnologyList.addAll(skTechnologies);

            List<SkBusSkill> skBussSkills = emp.getSkBusSkills();
            skBussSkillList.addAll(skBussSkills);

        }

        ExecutionContext executionContext = chunkContext
                .getStepContext()
                .getStepExecution()
                .getJobExecution()
                .getExecutionContext();

        executionContext.put("grupoList", grupoList);
        executionContext.put("jobTechnologyProfileList", jobTechnologyProfileList);
        executionContext.put("roleList", roleList);
        executionContext.put("skLenguageList", skLenguageList);
        executionContext.put("skMethodList", skMethodList);
        executionContext.put("skTechSkillList", skTechSkillList);
        executionContext.put("skCertifList", skCertifList);
        executionContext.put("skTechnologyList", skTechnologyList);
        executionContext.put("skBussSkillList", skBussSkillList);


        return RepeatStatus.FINISHED;
    }
}
