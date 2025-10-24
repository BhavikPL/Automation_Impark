package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import path.Path;

public class ExcelReader 
{
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	File file;
	FileInputStream fis;
	Object[][] data;
	DataFormatter formatter;
	
	public Object[][] getData(String filePath , String sheetName) throws Exception
	{
		file = new File(filePath);
		formatter = new DataFormatter();
		if(file.exists())
		{
			try
			{
				fis = new FileInputStream(file);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheet(sheetName);
				data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
				
				for(int row=0;row<sheet.getLastRowNum();row++)
				{
					for(int col=0;col<sheet.getRow(row).getLastCellNum();col++)
					{
						//Cell cell=sheet.getRow(row+1).getCell(col);
						data[row][col]=formatter.formatCellValue(sheet.getRow(row+1).getCell(col));
					}
				}
				fis.close();
				workbook.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return data;
		}
		else
		{
			throw new Exception("file_Not_found");
		}
	}
	
	public List<Map<String, Object>> getData(String path , int sheetNumber ) throws Exception
	{
		file = new File(path);
		formatter = new DataFormatter();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		if(file.exists())
		{
			try
			{
				fis = new FileInputStream(file);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(sheetNumber);
				data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
				
				for(int row=0;row<sheet.getLastRowNum();row++)
				{
					Map<String, Object> map = new HashMap<String,Object>();
					for(int col=0;col<sheet.getRow(row).getLastCellNum();col++)
					{
						map.put(formatter.formatCellValue(sheet.getRow(0).getCell(col)),formatter.formatCellValue(sheet.getRow(row+1).getCell(col)));
						//System.out.println(formatter.formatCellValue(sheet.getRow(0).getCell(col))+"-----------------------"+formatter.formatCellValue(sheet.getRow(row+1).getCell(col)));
					}
					list.add(map);
				}
				fis.close();
				workbook.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			return list;
		}
		else
		{
			throw new Exception("file_Not_found");
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		ExcelReader obj = new ExcelReader();
		/*String file = Path.downloadPath+File.separator+Util.getDownloadedFileName();
		//List<Map<String, Object>> excelData = obj.getData("C:/Users/bhavik.chondager/Downloads/Users (5).xlsx", 0);
		List<Map<String, Object>> excelData = obj.getData(file, 0);
		
		System.out.println("size is:="+excelData.size());
		for(int i=0;i<excelData.size();i++)
		{
			
			System.out.println(excelData.get(i).get("Username/Email").toString().trim());
			System.out.println(excelData.get(i).get("Password").toString().trim());
		}*/
		
		String file = Path.downloadPath+File.separator+Util.getDownloadedFileName();
		List<Map<String, Object>> excelData = obj.getData(file, 0);
		System.out.println(excelData.size());
	}
}
