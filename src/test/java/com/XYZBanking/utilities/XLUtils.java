package com.XYZBanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount (String xlFile, String xlSheet) throws IOException
	{
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlSheet);
		int rowCount = sh.getLastRowNum();
		fi.close();
		wb.close();
		return rowCount ;
	}
	
	public static int getCellCount (String xlFile, String xlSheet, int rowNum) throws IOException
	{
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlSheet);
		row = sh.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		fi.close();
		wb.close();
		return cellCount ;
	}
	
	public static String getCellData (String xlFile, String xlSheet, int rowNum, int colNum) throws IOException
	{
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlSheet);
		row = sh.getRow(rowNum);
		cell = row.getCell(colNum);
		String data;
		try
		{
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}
		catch (Exception e)
		{
			data = "";
		}
		fi.close();
		wb.close();
		return data ;
	}
	
	public static void setCellData (String xlFile, String xlSheet, int rowNum, int colNum, String data) throws IOException
	{
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlSheet);
		row = sh.getRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(data);
		fo= new FileOutputStream(xlFile);
		wb.write(fo);

		fi.close();
		wb.close();
		fo.close();
	}

}
