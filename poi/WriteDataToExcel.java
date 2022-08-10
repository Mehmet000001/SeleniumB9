package poi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class WriteDataToExcel {
    @Test
    public  void writeDataTest1() throws IOException, InvalidFormatException {
        File excelFile=new File("src/test/resources/testData.xlsx");
        FileInputStream fileInputStream=new FileInputStream(excelFile);

        XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet=workbook.getSheetAt(0);
        XSSFRow row1=sheet.getRow(0);
        XSSFCell cell1=row1.getCell(0);
        cell1.setCellValue("Execution Test Name");
        FileOutputStream fileOutputStream=new FileOutputStream(excelFile);
        workbook.write(fileOutputStream);
        XSSFCell updateCell=sheet.getRow(0).getCell(0);
        Assert.assertEquals(updateCell.getStringCellValue(),"Execution Test Name");

    }
    @Test
    public  void writeDataTest() throws IOException {
        File excelFile=new File("src/test/resources/testData.xlsx");
        FileInputStream fileInputStream=new FileInputStream(excelFile);
        XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet1=workbook.getSheet("Sheet1");
        XSSFRow row5=sheet1.createRow(4);
        XSSFCell cell1=row5.createCell(0);
        cell1.setCellValue("Return product test");
        FileOutputStream fileOutputStream=new FileOutputStream(excelFile);
        workbook.write(fileOutputStream);

    }
}
