package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import base.Base;
import constant.Constants;
import path.Path;

public class ConfigReader extends Base
{
	static File configFilePath;
	static FileInputStream configFileStream;
	static Properties prop;
	
	private static Properties getProperties( String fileType )
	{
		String getEnvDetails = ConfigReader.getPropertiesFromEnvironmentFile("Global","clientName");
		if( getEnvDetails.equalsIgnoreCase("Danville") )
		{
			configFilePath = new File(Path.danvilleConfigFilePath);
		}
		if( getEnvDetails.equalsIgnoreCase("SouthLakeTahoe") )
		{
			configFilePath = new File(Path.southLakeTaohConfigFilePath);
		}
		if( getEnvDetails.equalsIgnoreCase("Camden") )
		{
			configFilePath = new File(Path.camdenConfigFilePath);
		}
		if( getEnvDetails.equalsIgnoreCase("Rutgers") )
		{
			configFilePath = new File(Path.rutgersConfigFilePath);
		}
		if( getEnvDetails.equalsIgnoreCase("HPA") )
		{
			configFilePath = new File(Path.HPAConfigFilePath);
		}
		if( getEnvDetails.equalsIgnoreCase("LAZ") )
		{
			configFilePath = new File(Path.LAZConfigFilePath);
		}
		if( getEnvDetails.equalsIgnoreCase("Chattanooga") )
		{
			configFilePath = new File(Path.ChattanoogaConfigFilePath);
		}
		if( getEnvDetails.equalsIgnoreCase("Fayetteville") )
		{
			configFilePath = new File(Path.FayettevilleConfigFilePath);
		}
		if( getEnvDetails.equalsIgnoreCase("Jacksonville") )
		{
			configFilePath = new File(Path.JacksonvilleConfigFilePath);
		}
		if( getEnvDetails.equalsIgnoreCase("Winpark") )
		{
			configFilePath = new File(Path.WinparkConfigFilePath);
		}
		if( getEnvDetails.equalsIgnoreCase("Volusia") )
		{
			configFilePath = new File(Path.VolusiaConfigFilePath);
		}
		if( getEnvDetails.equalsIgnoreCase("Casper") )
		{
			configFilePath = new File(Path.CasperConfigFilePath);
		}
		if( getEnvDetails.equalsIgnoreCase("Manhattan") )
		{
			configFilePath = new File(Path.ManhattanConfigFilePath);
		}
		if( getEnvDetails.equalsIgnoreCase("Phsa") )
		{
			configFilePath = new File(Path.PhsaConfigFilePath);
		}
		if( getEnvDetails.equalsIgnoreCase("Waterloo") )
		{
			configFilePath = new File(Path.WaterlooConfigFilePath);
		}
		try
		{
			configFileStream = new FileInputStream(configFilePath);
			prop = new Properties();
			prop.load(configFileStream);
		}
		catch(FileNotFoundException e1)
		{
			try
			{
				throw new Exception(Constants.file_Not_found);
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(IOException e2)
		{
			e2.printStackTrace();
		}
		return prop;
	}
	
	private static Properties getEnvironmentProperties( String fileType )
	{
		configFilePath = new File(Path.envConfigFilePath);
		try
		{
			configFileStream = new FileInputStream(configFilePath);
			prop = new Properties();
			prop.load(configFileStream);
		}
		catch(FileNotFoundException e1)
		{
			try
			{
				throw new Exception(Constants.file_Not_found);
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(IOException e2)
		{
			e2.printStackTrace();
		}
		return prop;
	}
	
	private static String getPropertiesFromEnvironmentFile( String fileType , String key )
	{
		String value=null;
		
		try
		{
			value = ConfigReader.getEnvironmentProperties(fileType).getProperty(key);
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		
		if( value == null )
		{
			try 
			{
				throw new Exception(Constants.value_not_found);
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		return value;
	}
	
	public static String getPropertiesFromConfigFile( String fileType , String key )
	{
		String value=null;
		
		try
		{
			value = ConfigReader.getProperties(fileType).getProperty(key);
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		
		if( value == null )
		{
			try 
			{
				throw new Exception(Constants.value_not_found);
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		return value.trim();
	}
}
