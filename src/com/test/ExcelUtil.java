package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUtil {
	
	HSSFSheet sheet;
	Map<String,String> rowvalues = new HashedMap<String, String>();
	private String SheetName;
	private String reference;
	
	 ExcelUtil(String SheetName , String reference) {
		this.SheetName = SheetName;
		this.reference = reference;
	}
	
	@SuppressWarnings("resource")
	public Map<String,String> initialiseRowValue() throws Exception {
			
		    System.getProperty("user.dir");
			File file1 = new File(System.getProperty("user.dir") + "//RequiredFile//" + SheetName + ".xls");
			FileInputStream file = new FileInputStream(file1);
			HSSFWorkbook Workbook = new HSSFWorkbook(file);
			sheet = Workbook.getSheetAt(0);
			return getRowCompleteValue(getRow(reference));
		}
	
	public int getRow(String reference) {
		
		Iterator<Row> it = sheet.rowIterator();
		int rowNum = 0;

		while (it.hasNext()) {
			HSSFRow row = (HSSFRow) it.next();
			 
			if (row.getCell(0).toString().trim().equals(reference)) {
				
				rowNum = row.getRowNum();
				break;
				
			}
		}
		
		return rowNum;
	}
	
	public Map<String,String> getRowCompleteValue(int rowNum) throws Exception{
			
			Iterator<Cell> cell = sheet.getRow(rowNum).cellIterator();
			
			int i=0;
			
			while(cell.hasNext()) {
				HSSFCell cellValue = (HSSFCell) cell.next();
				rowvalues.put(sheet.getRow(0).getCell(i).toString(),cellValue.getStringCellValue());
				i++;
			}
			
			return rowvalues;
		}
	
}
