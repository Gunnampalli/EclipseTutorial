package com.UIFrameWork.Motivity.TestFrame.HelpersClass.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Logger.LoggerHelper;
import com.UIFrameWork.Motivity.TestFrame.HelpersClass.Resource.ResourceHelper;

import freemarker.core.StringArraySequence;

public class ExcelHelper {
	private static Logger log = LoggerHelper.getlogger(ExcelHelper.class);

	public Object[][] getExcelData(String excelLocation, String sheetName) {

		try {
			Object dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(excelLocation));

			// Create WorkbookInstance
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// get SheetName from workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);

			// count number of active rows in excel sheet
			int totalRow = sheet.getLastRowNum();

			// count active columns in a row
			int totalColumn = sheet.getRow(0).getLastCellNum();

			dataSets = new Object[totalRow + 1][totalColumn];

			// Iterate through each rows one by one.
			Iterator<Row> rowiterator = sheet.iterator();
			int i = 0;
			while (rowiterator.hasNext()) {
				i++;
				// For Every Row we need to iterate over columns
				Row row = rowiterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				int j = 0;
				while (cellIterator.hasNext()) {
					j++;
					Cell cell = cellIterator.next();

					switch (cell.getCellTypeEnum()) {
					case STRING:
						dataSets[i - 1][j - 1] = cell.getStringCellValue();
						break;
					case NUMERIC:
						dataSets[i - 1][j - 1] = cell.getNumericCellValue();
						break;
					case BOOLEAN:
						dataSets[i - 1][j - 1] = cell.getBooleanCellValue();
						break;
					case FORMULA:
						dataSets[i][j] = cell.getCellFormula();
						break;

					default:
						System.out.println("no matching enum data found");
						break;

					}
				}

			}
			return dataSets;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	public void updateResult(String excelLocation, String sheetName, String testCaseName, String testStatus) {
		try {

			FileInputStream file = new FileInputStream(new File(excelLocation));

			// Create WorkbookInstance
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// get SheetName from workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// count number of active rows in excel sheet
			int totalRow = sheet.getLastRowNum() + 1;
			for (int i = 1; i < totalRow; i++) {
				XSSFRow r = sheet.getRow(i);
				String ce = r.getCell(0).getStringCellValue();
				
				if (ce.contains(testCaseName)) {
					r.createCell(1).setCellValue(testStatus);
					file.close();
					log.info("result Updated");
					FileOutputStream out = new FileOutputStream(new File(excelLocation));
					workbook.write(out);
					out.close();
					break;
				}
			}

		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		ExcelHelper excelhelper = new ExcelHelper();
		String excelLocation = ResourceHelper.getResourcePath("src/main/Resources/ConfigFile/TestData.xlsx");
		excelhelper.updateResult(excelLocation, "TestScripts", "Login", "pass");
		excelhelper.updateResult(excelLocation, "TestScripts", "Registration", "Fail");
	}

}
