package com.durgasoft.selenium.apachi.poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class mahesh {
	public FileInputStream fis=null;
	public FileOutputStream fos=null;
	public XSSFWorkbook workbook=null;
	public XSSFSheet sheet=null;
	public XSSFRow row=null;
	public XSSFCell cell=null;
	public String filepath;
	public mahesh(String file) throws Exception
	{
		this.filepath=file;
		fis=new FileInputStream(filepath);
		workbook=new XSSFWorkbook(fis);
		fis.close();
	}
	//reading cell data from excel by using column number

	public String getcelldata(String sheetname,int colnum,int rownum)
  {
	try {
     sheet=workbook.getSheet(sheetname);
	row=sheet.getRow(rownum);
	cell=row.getCell(colnum);
	if(cell.getCellType()==CellType.STRING)
	{
		return cell.getStringCellValue();
	}
	else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA)
	{
		String cellvalue=String.valueOf(cell.getNumericCellValue());
		return cellvalue;
	}
	else if(cell.getCellType()==CellType.BLANK)
	{
		return "";
	}
	else
		return String.valueOf(cell.getBooleanCellValue());
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return "no matching value";
	}
   }
    
	//Reading cell data from excel by using column name
	public String getcelldata(String sheetname,String colname,int rownum)
	{
		try
	{
		int colnum=-1;
		 sheet=workbook.getSheet(sheetname);
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().equals(colname))
				{
					colnum=i;
				}
			}
			row=sheet.getRow(rownum);
			cell=row.getCell(colnum);
			if(cell.getCellType()==CellType.STRING)
			{
				return cell.getStringCellValue();
			}
			else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA)
			{
				String cellvalue=String.valueOf(cell.getNumericCellValue());
				return cellvalue;
			}
			else if(cell.getCellType()==CellType.BLANK)
			{
				return "";
			}
			else
				return String.valueOf(cell.getBooleanCellValue());
		}catch(Exception e)
		{
			e.printStackTrace();
			return "no matching value";
		}
   }
	//writing cell data in excel file by using column index
	public boolean setcelldata(String sheetname,int colnum,int rownum,String value)
	{
		try {
			sheet=workbook.getSheet(sheetname);
			row=sheet.getRow(rownum);
			if(row==null)
			{
				row=sheet.createRow(rownum);
			}
			cell=row.getCell(colnum);
			if(cell==null)
			{
				cell=row.createCell(colnum);
			}
			cell.setCellValue(value);
			fos=new FileOutputStream(filepath);
			workbook.write(fos);
			fos.close();
		}catch(Exception e)
		{
        e.printStackTrace();
        return false;
		}
		return true;
	}
	//add the cell data in excel file by using column name
	public boolean setcelldata(String sheetname,String colname,int rownum,String value) throws Exception
	{
		try {
		int colnum=-1;
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().equals(value))
			{
				colnum=i;
			}
		}
		row=sheet.getRow(rownum);
		if(row==null)
		{
			row=sheet.createRow(rownum);
		}
		cell=row.getCell(colnum);
		if(cell==null)
		{
			cell=row.createCell(colnum);
		}
		cell.setCellValue(value);
		fos=new FileOutputStream(filepath);
		workbook.write(fos);
		fos.close();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//identify the number of rows and columns in a excel file
	public int getrows(String sheetname)
	{
		sheet=workbook.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum()+1;
		return rowcount;
	}
	public int getcolumns(String sheetname)
	{
		sheet=workbook.getSheet(sheetname);
		int columncount=row.getLastCellNum();
		return columncount;
	}
	
}


