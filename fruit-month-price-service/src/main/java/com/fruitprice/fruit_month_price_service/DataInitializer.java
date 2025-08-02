package com.fruitprice.fruit_month_price_service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private FruitPriceService service;

    @Override
    public void run(String... args) throws Exception {
        try {
            initData();
        } catch (Exception e) {
            System.err.println("Error initializing data: " + e.getMessage());
        }
    }

    private void initData() {
        try {
            ClassPathResource resource = new ClassPathResource("FMP.xlsx");
            InputStream inputStream = resource.getInputStream();
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            List<FruitPrice> fruitPrices = new ArrayList<>();
            String[] months = { "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec" };
            Long idCounter = 1000L;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    String fruit = getCellValueAsString(row.getCell(0));
                    for (int j = 0; j < months.length; j++) {
                        Cell priceCell = row.getCell(j + 1);
                        if (priceCell != null) {
                            double price = getCellValueAsDouble(priceCell);
                            if (price > 0) {
                                fruitPrices.add(new FruitPrice(idCounter, fruit, months[j], price));
                                idCounter++;
                            }
                        }
                    }
                }
            }
            service.saveAll(fruitPrices);
            workbook.close();
            inputStream.close();
        } catch (IOException e) {
            System.err.println("Error reading the Excel file: " + e.getMessage());
        }
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null)
            return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim().toLowerCase();
            case NUMERIC:
                return String.valueOf((long) cell.getNumericCellValue()).toLowerCase();
            case BLANK:
                return "";
            default:
                return cell.toString().trim().toLowerCase();
        }
    }

    private double getCellValueAsDouble(Cell cell) {
        if (cell == null)
            return 0.0;

        switch (cell.getCellType()) {
            case STRING:
                try {
                    String value = cell.getStringCellValue().trim();
                    value = value.replaceAll("[^0-9.]", ""); // Remove non-numeric characters
                    return Double.parseDouble(value);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format in cell: " + e.getMessage());
                    return 0.0;
                }
            case NUMERIC:
                return cell.getNumericCellValue();
            case BLANK:
                return 0.0;
            default:
                return 0.0;
        }
    }
}