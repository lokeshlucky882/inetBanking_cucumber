package stepDefinitions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.ManagerHomePage;
import pageObjects.NewCustomerPage;
import utilities.ReadConfig;

public class Steps extends Base
{
	@Before
	public void initail()
	{
		log = Logger.getLogger("inetBanking");
		PropertyConfigurator.configure("log4j2.properties");
	}
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() throws Exception 
	{
		rc = new ReadConfig(driver);
		if(rc.browser().equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", rc.chromepath());
			driver = new ChromeDriver();
			log.info("*************Chrome browser is launched*******************");
		}
		else if(rc.browser().equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", rc.firefoxpath());
			driver = new FirefoxDriver();
			log.info("*************Firefox browser is launched*******************");
		}
	}

	@When("User opens URL as {string}")
	public void user_opens_url_as(String url) 
	{
		driver.get(url);
		log.info("*************User open the URL*******************");
		driver.manage().window().maximize();
		log.info("*************User maximise the window*******************");
	}

	@When("User login with Username as {string} and Password as {string}")
	public void user_login_with_username_as_and_password_as(String userName, String password) 
	{	
		lp = new LoginPage(driver);
	    lp.setUserName(userName);
	    log.info("*************User enter the User name*******************");
	    lp.setPassword(password);
	    log.info("*************User enter the Password*******************");
	}

	@When("click on Login button")
	public void click_on_login_button() 
	{
	    lp.clickOnLoginBtn();
	    log.info("*************User clicked on Login button*******************");
	}

	@Then("the Page title is displayed as {string}")
	public void the_page_title_is_displayed_as(String pageTitle) 
	{
		String title = driver.getTitle();
		if(title.equals(pageTitle))
		{
			log.info("*************Page title is Matched*******************");
			Assert.assertTrue(true);
		}
		else
		{
			log.info("*************Page title is not Matched*******************");
			Assert.assertTrue(false);
		}
	}
	
	@Then("User close the browser")
	public void user_close_the_browser() 
	{
		log.info("*************User close the browser*******************");
	    driver.close();
	}
	
	@When("User click on NewCustomer button")
	public void user_click_on_new_customer_button() 
	{
		mhp = new ManagerHomePage(driver);
		log.info("*************User clicked on New Customer button*******************");
	    mhp.clickOnNewCustomer();
	}

	@Then("User fill the Add new customer form")
	public void user_fill_the_add_new_customer_form() throws InterruptedException 
	{
		addcust = new NewCustomerPage(driver);
		addcust.custName("LokeshLoki");
		log.info("*************User enter the Customer name*******************");
		addcust.custgender("male");
		log.info("*************User select the Customer gender*******************");
		addcust.custdob("10","15","1995");
		log.info("*************User enter the Customer DOB*******************");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		log.info("*************User enter the Customer address*******************");
		addcust.custcity("HYD");
		log.info("*************User enter the Customer City*******************");
		addcust.custstate("AP");
		log.info("*************User enter the Customer State*******************");
		addcust.custpinno("5000074");
		log.info("*************User enter the Customer PinCode*******************");
		addcust.custtelephoneno("987870091");
		log.info("*************User enter the Customer Phone Number*******************");
		addcust.custemailid(randomString()+"@gmail.com");
		log.info("*************User enter the Customer Email*******************");
		 
	}

	@When("User click on Submit button")
	public void user_click_on_submit_button() 
	{
		addcust.custsubmit();
		log.info("*************User Submit button*******************");
	}

	@Then("New Customer is created with id")
	public void new_customer_is_created_with_id() throws Exception 
	{
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		log.info("*************New Customer created*******************");
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
	}

}
