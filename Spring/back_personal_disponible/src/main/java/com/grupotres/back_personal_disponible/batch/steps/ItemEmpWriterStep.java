package com.grupotres.back_personal_disponible.batch.steps;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.Grupo;
import com.grupotres.back_personal_disponible.service.EmpleadoService;
import com.grupotres.back_personal_disponible.service.GrupoService;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ItemEmpWriterStep implements Tasklet  {

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private EmpleadoService empleadoService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        List<Grupo> grupoList = (List<Grupo>) chunkContext
                .getStepContext()
                .getJobExecutionContext()
                .get("grupoList");

        Set<String> uniqueGrupos = grupoList.stream()
                .map(Grupo::getGrupos)
                .collect(Collectors.toSet());

        List<Grupo> uniqueGrupoList = grupoList.stream()
                .filter(grupo -> uniqueGrupos.remove(grupo.getGrupos()))
                .toList();

        grupoService.saveAllGroups(uniqueGrupoList);

        empleadoService.saveAllEmpleados((List<Empleado>) chunkContext
                .getStepContext()
                .getJobExecutionContext()
                .get("empleadoList"));

        List<Empleado> empleadoListFinal = empleadoService.getAllEmpleados();
        chunkContext
                .getStepContext()
                .getStepExecution()
                .getJobExecution()
                .getExecutionContext()
                .put("empleadoListFinal", empleadoListFinal);

        return RepeatStatus.FINISHED;
    }
}
