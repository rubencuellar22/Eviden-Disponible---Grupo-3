package com.grupotres.back_personal_disponible.restController;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BatchRestController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @PostMapping("/uploadFile")
    public ResponseEntity<?> receiveFile(@RequestParam(name = "file") MultipartFile multipartFile) {
        try {
            // Nombre del archivo de entrada
            String fileName = "personal_disponible.xlsx";

            // Guardar el archivo Excel
            Path excelPath = Paths.get("src" + File.separator + "main" + File.separator + "resources" + File.separator + "files" +
                    File.separator + fileName);
            System.out.println("Ruta del archivo Excel: " + excelPath);

            Files.createDirectories(excelPath.getParent());
            Files.copy(multipartFile.getInputStream(), excelPath, StandardCopyOption.REPLACE_EXISTING);

            // Ajustar el límite de ZipSecureFile
            ZipSecureFile.setMinInflateRatio(0.00001);

            // Nombre del archivo de salida
            String outputFileName = "personal_disponible.csv";

            // Crear parámetros para el Job
            JobParameters jobParameters = new JobParametersBuilder()
                    .addDate("fecha", new Date())
                    .addString("inputFilePath", excelPath.toString())
                    .addString("outputFilePath", excelPath.getParent().resolve(outputFileName).toString())
                    .toJobParameters();

            // Ejecutar el Job
            System.out.println("Iniciando el proceso batch...");
            jobLauncher.run(job, jobParameters);
            System.out.println("Proceso batch completado.");

            // Preparar la respuesta con la ubicación del archivo CSV
            Map<String, Object> response = new HashMap<>();
            response.put("archivo", fileName);
            response.put("estado", "recibido");
            response.put("csvPath", excelPath.getParent().resolve(outputFileName).toString());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.err.printf("Error al iniciar el proceso batch: %s%n", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al iniciar el proceso batch: " + e.getMessage());
        }
    }
}