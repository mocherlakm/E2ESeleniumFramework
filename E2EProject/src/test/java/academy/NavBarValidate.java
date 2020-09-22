package academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class NavBarValidate extends Base {
	
	@BeforeTest
	public void browserUrlLaunch() throws IOException
	{
		driver=initializeDriver();  // by inheritance 
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	@Test()
	public void basePageNavigation() throws IOException
	{
		LandingPage l = new LandingPage(driver);
		System.out.println(l.getbar().isDisplayed());
		Assert.assertTrue(l.getbar().isDisplayed());
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}

}
