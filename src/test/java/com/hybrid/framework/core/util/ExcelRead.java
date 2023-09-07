package com.hybrid.framework.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	private static XSSFWorkbook workbook;
	
	public static void readExcel() throws Exception {
		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir") + "//Resources//Test_Data.xlsx"));
		workbook = new XSSFWorkbook(fis);		
	}
	
	public static void getStudentDetails(String sheetName) {
		XSSFSheet sheet = workbook.getSheet(sheetName);
		Iterator<Row> rowIterator = sheet.rowIterator();
		readRowsAndColumns(rowIterator);
	}
	
	private static void readRowsAndColumns(Iterator<Row> rowIterator) {
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if(row.getRowNum()==0) {
				continue;
			}
			Iterator<Cell> colIterator = row.cellIterator();
			readColumnDataAndBuildSet(colIterator);
		}
	}
	
	private static void readColumnDataAndBuildSet(Iterator<Cell> cellIterator) {
		Student student = new Student();
		while(cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			switch(cell.getColumnIndex()) {
			case 0: student.setId(cell.getNumericCellValue());
					break;
			case 1: student.setFirstName(cell.getStringCellValue());
					break;
			case 2: student.setLastName(cell.getStringCellValue());
					break;
			case 3: student.setGrade(cell.getStringCellValue());
					break;
			case 4: student.setSection(cell.getStringCellValue());
					break;
			}
		}
		GlobalConstants.studentList.add(student);
	}
}
