package com.grupotres.back_personal_disponible.batch.steps;


import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;

@Component
public class ExcelToCsvTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        String inputFilePath = chunkContext.getStepContext().getJobParameters().get("inputFilePath").toString();
        String outputFilePath = chunkContext.getStepContext().getJobParameters().get("outputFilePath").toString();
        
        ZipSecureFile.setMinInflateRatio(0.001);

        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(inputFilePath))) {
            Sheet sheet = workbook.getSheetAt(2); // Cambia el índice de la hoja según sea necesario
            try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
                for (Row row : sheet) {
                    boolean firstCell = true;
                    for (Cell cell : row) {
                        if (!firstCell) {
                            writer.print(',');
                        }
                        String cellValue = getCellValue(cell);
                        writer.print(cellValue);
                        firstCell = false;
                    }
                    writer.println();
                }
            }
        }
        return RepeatStatus.FINISHED;
    }

    private String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                      return cell.getDateCellValue().toString();
                } else {
                	String numberString = String.valueOf(cell.getNumericCellValue());
                	System.out.println("NumberStirng: " + numberString);
                	if (numberString.split("\\.")[1].equals("0")) {
                		return numberString.split("\\.")[0];
                	}
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}
