package stepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import net.bytebuddy.utility.RandomString;
import pageObjects.LoginPage;
import pageObjects.ManagerHomePage;
import pageObjects.NewCustomerPage;
import utilities.ReadConfig;

public class Base 
{
	public WebDriver driver;
	public Properties properties;
	public LoginPage lp;
	public ManagerHomePage mhp;
	public NewCustomerPage addcust;
	public ReadConfig rc;
	public Logger log;
	
	public String randomString()
	{
		String random = RandomString.make(10);
		return random;
	}
	

}
