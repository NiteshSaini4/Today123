package Utilities_File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data_Driven_Testing 
{
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow rw;
	public static XSSFCell cl;
	public static FileInputStream fn;
	
	public static int getRow(String file_name,String sheetname) throws Exception
	{
		fn=new FileInputStream(file_name);
		wb=new XSSFWorkbook(fn);
		ws=wb.getSheet(sheetname);
		int totalRow=ws.getLastRowNum()+1;
		return totalRow;
	}
	public static int getCol(String file_name,String sheetname) throws Exception
	{
		fn=new FileInputStream(file_name);
		wb=new XSSFWorkbook(fn);
		ws=wb.getSheet(sheetname);
		int totalcol=ws.getRow(0).getLastCellNum();
		return totalcol;
	}
	public static String getCellvalue(String file_name,String sheetname,int row,int col) throws Exception
	{
		
		fn=new FileInputStream(file_name);
		wb=new XSSFWorkbook(fn);
		ws=wb.getSheet(sheetname);
		cl=wb.getSheet(sheetname).getRow(row).getCell(col);
		return cl.getStringCellValue();
		
	}

}
