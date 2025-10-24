package utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import path.Path;

public class ExcelCSV
{
	public int getRowsCount()
	{ 
		String csvFilePath = Path.downloadPath+File.separator+Util.getDownloadedFileName();
	    int rowCount = 0;
	    try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath)))
	    {
	         String[] nextRecord;
	         while ((nextRecord = csvReader.readNext()) != null)
	         {
	              rowCount++;
	         }
	    } 
	    catch (IOException e) 
	    {
	         System.err.println("Error reading CSV file: " + e.getMessage());
	    }
	    
	    return (rowCount-1);
	}
	
	public static void main(String[] args)
	{
		ExcelCSV obj = new ExcelCSV();
		int count = obj.getRowsCount();
		System.out.println("Count:="+count);
	}
}
