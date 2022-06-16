package utiltiyPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class PojoClass 
{
	public WebDriver driver;
	public static WebDriver startApplication(WebDriver driver,String browserName, String appUrl)
	{
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "driver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Please declare this browser driver in Pojo Class");
		}
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void tearDown(WebDriver driver)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		
		}
		
		driver.quit();
	}
}
