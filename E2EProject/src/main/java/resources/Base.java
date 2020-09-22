package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public WebDriver driver; // Global variable
	public Properties prop;
	
	// Create a method for browser launching of any kind
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties(); // java.util
		FileInputStream fis = new FileInputStream("C:\\Users\\moche\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		//mvn.test -Dbrowser=chrome
		
		//String browserName = System.getProperty("browser"); // use this when you are parameterizing with Jenkins
		String browserName = prop.getProperty("browser");
		//System.out.println(browserName);
		
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\moche\\drivers-sel\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\moche\\drivers-sel\\GeckoDriver.exe");
			driver = new FirefoxDriver();
		}
		if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver","C:\\Users\\moche\\drivers-sel\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		
		// Time outs setup
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}

}
