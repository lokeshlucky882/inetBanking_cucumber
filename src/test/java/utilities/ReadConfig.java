package utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ReadConfig 
{
	WebDriver driver;
	public Properties properties;
	public ReadConfig(WebDriver driver) throws Exception 
	{
		this.driver=driver;
		properties = new Properties();
		FileInputStream fis = new FileInputStream(".//config.properties");
		properties.load(fis);
	}
	public String browser()
	{
		return properties.getProperty("browser");
	}
	public String chromepath()
	{
		return properties.getProperty("chromePath");
	}
	public String firefoxpath()
	{
		return properties.getProperty("firefoxPath");
	}

}
