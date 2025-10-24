package utility;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import path.Path;
import utility.Util;

public class PDFReader
{
	public static boolean isContentPresent(String text)
	{
		PDDocument document = null;
		String output ="";
        boolean flag = false;
        try
        {
        	String fileName = Util.getDownloadedFileName();
        	String filePath=Path.downloadPath+File.separator+fileName;
        	File file = new File(filePath);
        	FileInputStream fis = new FileInputStream(file);
           
            try 
            {
                document = PDDocument.load(fis);
                output = new PDFTextStripper().getText(document);
                System.out.println("pdf output is:= "+output);
            } 
            finally 
            {
            	if(fis != null)
            	{
            		fis.close();
            	}
                if (document != null)
                {
                    document.close();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if(output.contains(text))
        {
            flag =  true;
        }
        return flag;
    }
	
	public static boolean isContentPresent(String path , String text)
	{
		PDDocument document = null;
		String output ="";
        boolean flag = false;
        try
        {
        	String filePath=path;
        	File file = new File(filePath);
        	FileInputStream fis = new FileInputStream(file);
           
            try 
            {
                document = PDDocument.load(fis);
                output = new PDFTextStripper().getText(document);
                System.out.println("pdf output is:= "+output);
            } 
            finally 
            {
            	if(fis != null)
            	{
            		fis.close();
            	}
                if (document != null)
                {
                    document.close();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if(output.contains(text))
        {
            flag =  true;
        }
        return flag;
    }
	
	public static int getPdfLineCount(String filePath)
	{
        PDDocument document = null;
        FileInputStream fis = null;
        try 
        {
            File file = new File(filePath);
            if (!file.exists() || !file.isFile())
            {
                System.err.println("Error: PDF file not found or is not a regular file at: " + filePath);
                return -1;
            }

            fis = new FileInputStream(file);

            document = PDDocument.load(fis);

            if (document.isEncrypted())
            {
                System.err.println("Error: PDF is encrypted and cannot be processed without a password.");
                return -1; // Or handle decryption if you have the password
            }

            // Instantiate PDFTextStripper
            PDFTextStripper pdfStripper = new PDFTextStripper();

            // Crucial: Set sortByPosition to true to ensure text is extracted in visual order
            // This helps in accurately determining lines.
            pdfStripper.setSortByPosition(true);

            // Extract text from the entire document
            String text = pdfStripper.getText(document);

            // Split the text into lines using the system's line separator
            // Trim each line and filter out empty lines to get a more accurate count of actual content lines
            String[] linesArray = text.split(System.getProperty("line.separator"));
            int lineCount = 0;
            for (String line : linesArray)
            {
                if (!line.trim().isEmpty())
                { // Count only non-empty lines
                    lineCount++;
                }
            }

            return lineCount;

        } 
        catch (IOException e)
        {
            System.err.println("Error processing PDF: " + e.getMessage());
            e.printStackTrace();
            return -1; // Indicate an error
        } 
        finally 
        {
            // Ensure resources are closed
            try 
            {
                if (fis != null) 
                {
                    fis.close();
                }
            }
            catch (IOException e)
            {
                System.err.println("Error closing FileInputStream: " + e.getMessage());
            }
            try 
            {
                if (document != null)
                {
                    document.close();
                }
            }
            catch (IOException e) 
            {
                System.err.println("Error closing PDDocument: " + e.getMessage());
            }
        }
    }
	
	 public static void main(String[] args)
	 {
	    
		 String file = Path.downloadPath+File.separator+Util.getDownloadedFileName();
	      int numberOfLines = getPdfLineCount(file);
	      if (numberOfLines != -1)
	      {
	           System.out.println("The PDF file '" + file + "' has " + numberOfLines + " lines of content.");
	      }
	      else 
	      {
	           System.out.println("Failed to determine the number of lines for '" + file + "'. See error messages above.");
	      }
	 }
}
