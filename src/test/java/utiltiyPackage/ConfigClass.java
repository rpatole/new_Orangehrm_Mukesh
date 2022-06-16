package utiltiyPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigClass 
{
	Properties pro;
	
	public ConfigClass()
	{
		File src= new File("./config/config.properties");
		try {
			FileInputStream fis= new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to read the file"+e.getMessage());
		}	
	}
	
	
	public String getData(String keyToSearch)
	{
		return pro.getProperty(keyToSearch);
	}
	
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	
	public String getUrl()
	{
		return pro.getProperty("qaURL");
	}
}
