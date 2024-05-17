package com.batch.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.batch.entities.Person;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ItemProcessorStep implements Tasklet{

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		
		System.out.println("------------> Inicio del paso de PROCESAR <-----------");

		// List<Person> personList = chunkContext.
		
		//recuperar la lista de pesonas		
		List<Person> personList = (List<Person>) chunkContext.getStepContext()
                .getJobExecutionContext()
                .get("personList");
		
				
		//añadir datos a la lista/modificar
		System.out.println("personList: " + personList);
		List<Person> personFinalList =	personList.stream().map(person->{
			DateTimeFormatter fotmat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			person.setInsertionDate(fotmat.format(LocalDateTime.now()));
			return person;
		}).toList();
	
	//enviar la nueva lista al sigueite paso
	
	chunkContext.getStepContext()
		.getStepExecution()
		.getJobExecution()
		.getExecutionContext()
		.put("personFinaleList", personFinalList);
	
	
	
	System.out.println("------------> fIN del paso de PROCESAR <-----------");
		return RepeatStatus.FINISHED;
	}

}
