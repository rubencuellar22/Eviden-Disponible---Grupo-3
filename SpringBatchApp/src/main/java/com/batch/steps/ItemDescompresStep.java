package com.batch.steps;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;



public class ItemDescompresStep implements Tasklet {

@Autowired
private ResourceLoader resoucerLoader;
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println("------------> Inicio del paso de DESCOMPRES <-----------");
		
		
		Resource resource = resoucerLoader.getResource("classpath:files/person.zip");
		
		//ruta absoluta donde se encuetra nuestro person.zip
		
		String filePath= resource.getFile().getAbsolutePath();		
		
		//Para descomprimir un archivo necesitamos un ZipFile, pasandole la ruta donde se encuentra
		ZipFile zipFile = new ZipFile(filePath);
		
		//Crear el directorio destino donde se guardará nuestro CSV	
		File destDir= new File(resource.getFile().getParent(),"destination" );
		
		//Validamos
		
		if(!destDir.exists()) {
			destDir.mkdir();		
			}
	
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		
		while(entries.hasMoreElements()) {
			ZipEntry zipEntry = entries.nextElement();
			File file = new File(destDir, zipEntry.getName());
			
			if(file.isDirectory()) {
				file.mkdirs();
			}else {
				InputStream inputStream = zipFile.getInputStream(zipEntry);
				FileOutputStream outputStream = new FileOutputStream(file);
				
				byte[] buffer = new byte[1024];
				int lenght;
				
				while((lenght= inputStream.read(buffer))>0) {
					outputStream.write(buffer, 0,lenght); 
				}
				
				outputStream.close();
				inputStream.close();
			}
			
		}
		zipFile.close();
		
		System.out.println("------------> Fin del paso de DECOMPRES <-----------");
		return RepeatStatus.FINISHED;
	}

}
