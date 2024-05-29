package com.grupotres.back_personal_disponible.batch.steps;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class ExcelToCsvTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        String inputFilePath = chunkContext.getStepContext().getJobParameters().get("inputFilePath").toString();
        String outputFilePath = chunkContext.getStepContext().getJobParameters().get("outputFilePath").toString();

        ZipSecureFile.setMinInflateRatio(0.001);

        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(inputFilePath))) {
            Sheet sheet = workbook.getSheetAt(2); // Cambia el índice de la hoja según sea necesario
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(outputFilePath);
                for (Row row : sheet) {
                    boolean firstCell = true;
                    int cellNum = 0;
                    // cell == 22
                    for (Cell cell : row) {
                        String cellValue = " ";

                        cellValue = getCellValue(cell);
                        cellValue = cellValue.replace(",", "/");
                        if (firstCell) {
                            writer.print((cellValue));
                        } else {
                            writer.print('§' + ((cellValue.isEmpty() ? " " : (cellValue))));
                        }

                        // esto es una chapuza paro es que en este row y en esta celda no me imprime el §.
                        // Y no se que casústica es.
                        // entra en el else pero no imprime el §.
                        /* if (row.getRowNum() == 35 && cellNum == 22) {
                            writer.print('§');
                            writer.print('§');
                            writer.print('§');
                        } */
                        firstCell = false;
                        cellNum++;
                    }
                    int cellsLeft = 32 - cellNum;
                    for (int i = 0; i < cellsLeft; i++) {
                        writer.print('§');
                    }
                    writer.println();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (writer != null) {
                    writer.close();
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
                // Si no deseas convertir fechas en este punto, simplemente devuelve el valor numérico como string.
                String numberString = String.valueOf(cell.getNumericCellValue());
                if (DateUtil.isCellDateFormatted(cell)) {
                    // En lugar de convertir la fecha, devuélvela como string en el formato original.
                    // Puedes formatear la fecha como tú prefieras o dejarla como está.
                    return new SimpleDateFormat("M/d/yyyy").format(cell.getDateCellValue());
                } else {
                    if (numberString.split("\\.")[1].equals("0")) {
                        return numberString.split("\\.")[0];
                    }
                    return numberString;
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                // Evalúa la fórmula y devuelve el resultado como string
                return cell.getCellFormula();
            default:
                return " ";
        }}
}
