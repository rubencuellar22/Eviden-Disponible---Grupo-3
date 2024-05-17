package com.batch.steps;

import java.util.List;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.batch.entities.Person;
import com.batch.services.IPersonService;

public class ItemWriterStep implements Tasklet {

	
	@Autowired
	private IPersonService personService;
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
	
		
		System.out.println("------------> Inicio del paso de ESCRITURA <-----------");
		
		List<Person> personList = (List<Person>) chunkContext.getStepContext()
                .getJobExecutionContext()
				 .get("personList");
		
		System.out.println("Lista Persona: " + personList);
	//Imprimir los datos antes de insertar
		
		personList.forEach(person ->{
			if(person!=null) {
				System.out.println(person.toString());
			}
		});
		
		personService.saveAll(personList);
		
		System.out.println("------------> FIN del paso de ESCRITURA <-----------");
		return RepeatStatus.FINISHED;
	}

}
