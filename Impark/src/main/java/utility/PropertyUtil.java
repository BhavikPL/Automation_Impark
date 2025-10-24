package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import path.Path;

public class PropertyUtil 
{
	public static void updateIntoProperty( String filePath, String key, String value ) throws IOException
	{
		File file = new File(filePath);
		 
        PropertiesConfiguration config = null;
        try 
        {
            config = new PropertiesConfiguration(file);
            config.setListDelimiter('\0');
            config.setDelimiterParsingDisabled(true);
            config.setProperty(key, value);
            
            OutputStream out = new FileOutputStream(file);
            config.save(out);
            //System.out.println(key+"--------------------->"+value);
        }
        catch (ConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try { Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	
	public static String getFromTempPropertyFile( String filePath , String key ) throws IOException
	{
		FileInputStream fis = new FileInputStream(filePath);
		Properties prop = new Properties();
		prop.load(fis);
		return (String) prop.get(key);
	}

	public static void removeFromTempPropertyFile( String filePath , String key ) throws IOException
	{
		File file = new File(filePath);
		
		FileInputStream fis = new FileInputStream(filePath);
		Properties prop = new Properties();
		prop.load(fis);
		prop.remove(key);
        
		FileWriter wr = new FileWriter(file);
		prop.store(wr, "removed");
	}
	
	public static void updateEnvironmentProperty( String key, String value ) throws IOException
	{
		String filePath = Path.envConfigFilePath;
		File file = new File(filePath);
		 
        PropertiesConfiguration config = null;
        try 
        {
            config = new PropertiesConfiguration(file);
            config.setListDelimiter('\0');
            config.setDelimiterParsingDisabled(true);
            config.setProperty(key, value);
            
            OutputStream out = new FileOutputStream(file);
            config.save(out);
            //System.out.println(key+"--------------------->"+value);
        }
        catch (ConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try { Thread.sleep(1000);}catch(InterruptedException e) {}
	}
	
	public static void clearProperty() throws IOException
	{
		String filePath = Path.dataProperty;
		 
		Properties properties = new Properties();
        FileInputStream input = new FileInputStream(filePath);
        properties.load(input);
        input.close();
        properties.clear();
        
        FileOutputStream output = new FileOutputStream(filePath);
        properties.store(output, "Cleared all properties");
        output.close();
        System.out.println("All data removed from " + filePath);
	}
	
	public static void main(String[] args) throws IOException 
	{
		/*PropertyUtil.updateIntoProperty(Path.tempconfigDir+File.separator+"My.properties", "DataTest", "EU Passes Law to 'Rein In' Big Tech's 2019s Domination Over Smaller Players");
		System.out.println(PropertyUtil.getFromTempPropertyFile(Path.tempconfigDir+File.separator+"My.properties", "DataTest"));
		
		PropertyUtil.updateIntoProperty(Path.tempconfigDir+File.separator+"My.properties", "DataTest", "Projetos de inovação em demência de iniciativa Roche vão ser implementados");
		System.out.println(PropertyUtil.getFromTempPropertyFile(Path.tempconfigDir+File.separator+"My.properties", "DataTest"));
		
		PropertyUtil.updateIntoProperty(Path.tempconfigDir+File.separator+"My.properties", "DataTest", "OVER 11,000 LOUISIANA RESIDENTS HAVE ACCESSED HEPATITIS C LIFE-SAVING MEDICATION");
		System.out.println(PropertyUtil.getFromTempPropertyFile(Path.tempconfigDir+File.separator+"My.properties", "DataTest"));
		System.out.println(PropertyUtil.getFromTempPropertyFile(Path.dataProperty, "name"));
		System.out.println(PropertyUtil.getFromTempPropertyFile(Path.dataProperty, "lname"));
		PropertyUtil.removeFromTempPropertyFile(Path.dataProperty, "name");
		System.out.println(PropertyUtil.getFromTempPropertyFile(Path.dataProperty, "name"));
		System.out.println(PropertyUtil.getFromTempPropertyFile(Path.dataProperty, "lname"));
		PropertyUtil.updateIntoProperty(Path.dataProperty, "wife", "Dhara");*/
		
		PropertyUtil.clearProperty();
	}
}
