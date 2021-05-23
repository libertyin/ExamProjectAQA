package utils;

import io.qameta.allure.Step;
import logger.CustomLogger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelWorker {

    @Step
    public void prepareExcelFile(String excelFilePath, String[] headers) throws IOException {
        try (HSSFWorkbook workbook = new HSSFWorkbook()) {
            HSSFSheet sheet = workbook.createSheet("Sheet");
            HSSFRow rowHead = sheet.createRow((short) 0);
            for (int i = 0; i < headers.length; i++) {
                rowHead.createCell(i).setCellValue(headers[i]);
            }
            try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
                workbook.write(outputStream);
            }
        }
    }

    @Step
    public void writeToExistingExcelFile(String excelFilePath, Object[] allData) {
        try (FileInputStream inputStream = new FileInputStream(excelFilePath)) {
            try (Workbook workbook = WorkbookFactory.create(inputStream)) {
                Sheet sheet = workbook.getSheetAt(0);
                Object[][] dataToWrite = {allData};
                int rowCount = sheet.getLastRowNum();
                for (Object[] data : dataToWrite) {
                    Row row = sheet.createRow(++rowCount);
                    int columnCount = 0;
                    Cell cell = row.createCell(columnCount);
                    cell.setCellValue(rowCount);
                    for (Object field : data) {
                        cell = row.createCell(columnCount++);
                        if (field instanceof String) {
                            cell.setCellValue((String) field);
                        } else if (field instanceof Integer) {
                            cell.setCellValue((Integer) field);
                        }
                    }
                }
                inputStream.close();
                try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
                    workbook.write(outputStream);
                    workbook.close();
                }
            }
        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
        CustomLogger.logger.info("ok");
    }

    @Step
    public ArrayList<Object> getDataFromExcel(String excelFilePath) throws IOException {
        ArrayList<Object> allData = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(excelFilePath)) {
            try (Workbook workbook = new HSSFWorkbook(inputStream)) {
                Sheet sheet = workbook.getSheetAt(0);
                DataFormatter dataFormatter = new DataFormatter();
                for (Row row : sheet) {
                    ArrayList<Object> data = new ArrayList<>();
                    for (Cell cell : row) {
                        String cellValue = dataFormatter.formatCellValue(cell);
                        data.add(cellValue);
                    }
                    allData.add(data);
                }
            }
        }
        return allData;
    }


}
