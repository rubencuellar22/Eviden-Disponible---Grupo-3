package com.batch.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.batch.services.IPersonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1")
public class BatchController {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	
	@Autowired
	private IPersonService personService;
	
	
	@PostMapping("/uploadFile")
	public ResponseEntity<?> recivefile(@RequestParam(name="file") MultipartFile multipartFile){
		String fileName = multipartFile.getOriginalFilename();
		
		try {
			
		Path path = Paths.get("src"+ File.separator + "main" + File.separator + "resources" + File.separator + "files" +
								File.separator + fileName );
		Files.createDirectories(path.getParent());
		Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING );
		
		JobParameters jobParameters = new JobParametersBuilder()
				.addDate("fecha", new Date())
				.addString("fileName", fileName)
				.toJobParameters();
		
	
		jobLauncher.run(job, jobParameters);
		
		
		Map<String, String> response = new HashMap<String, String>();
		System.out.println( "Responde: " + response);
		response.put("archivo", fileName);
		response.put("estado", "recibido");
		// response.
		// response.put("Lista Empleados", personService.getAll().to);

		
		return ResponseEntity.ok(personService.getAll());
			
		} catch (Exception e) {
	        System.err.printf("Error al iniciar el proceso batch", e);  // Registra la excepción real
	        throw new RuntimeException("Error al iniciar el proceso batch", e);  // Propaga la excepción real
	    
		}
		
	}

}
