package academy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
/*	
	@BeforeTest
	public void browserUrlLaunch() throws IOException
	{
		driver=initializeDriver();  // by inheritance 
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
*/
	@Test(dataProvider="getData")
	//@Test
	public void basePageNavigation(String Username, String password, String txt) throws IOException
	//public void basePageNavigation() throws IOException
	{
		driver=initializeDriver();  // by inheritance 
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();  // l.getLogin() is similar to driver.findElement(By.cssSelector("....")

		LoginPage lp = new LoginPage(driver);
		lp.getemail().sendKeys(Username);
		lp.getpwd().sendKeys(password);
		//System.out.println(txt);
		lp.getlogin().click();
		driver.close();
		
	}
/*
	@AfterTest
	public void teardown() {
		driver.close();
	}
*/
	@DataProvider
	public Object[][] getData() {
		// Row stands for how many idifferent data types test should run
		// column stands for how many values per test
		Object[][] data = new Object[2][3];
		
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "1234";
		data[0][2] = "NonRestricted User";
		
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "1234";
		data[1][2] = "Restricted User";
		
		return data;
	}

}
