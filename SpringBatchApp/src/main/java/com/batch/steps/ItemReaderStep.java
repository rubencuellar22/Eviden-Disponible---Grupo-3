package com.batch.steps;

import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import com.batch.entities.Person;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;


@Slf4j
public class ItemReaderStep implements Tasklet {
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println("------------> Inicio del paso de LECTURA <-----------");
		
		//Leer archivo
		Reader reader = new FileReader(resourceLoader.getResource("classpath:files/person1.csv").getFile());
		
		//Declarar Objeto CSVParser, especifica el separador 
		CSVParser parser = new CSVParserBuilder()
				//defino el separador con comillas simples
				.withSeparator(',')
				.build();	
		
		//Definir el objeto que nos ayuda a leer
		
		CSVReader csvReader = new CSVReaderBuilder(reader)
				.withCSVParser(parser)
				//lineas que debe saltarse ya que ka primera linea es el titulo
				.withSkipLines(1)
				.build()
				;
		
		
		//Convertir datos de archivos a objetos tipo person
		List<Person> personList= new ArrayList<>();
		
		String[] actualLine;
		
		while((actualLine = csvReader.readNext())!= null) {
			Person person = new Person();
			person.setName(actualLine[0]);
			person.setLastname(actualLine[1]);
			person.setAge(Integer.parseInt(actualLine[2]));
			
			personList.add(person);
			
			
		}
		
		csvReader.close();
		reader.close();
		System.out.println("PERSON LIST" + personList);
		
		// el chunkContext nos permite acceder al contexto de la ejecución 
		chunkContext.getStepContext()
			.getStepExecution()
			.getJobExecution()
			.getExecutionContext()
			//Aquí es donde pasamos nuestra lista al contexto de ejecución
			.put("personList",personList);
		
		
		System.out.println("------------> FIN del paso de LECTURA <-----------");
		
		return RepeatStatus.FINISHED;
	}

}
