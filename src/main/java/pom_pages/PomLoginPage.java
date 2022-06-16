package pom_pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PomLoginPage 
{
	WebDriver driver;
	@FindBy (xpath= "//input[@id='txtUsername']") private WebElement uname;
	@FindBy (xpath="//input[@id='txtPassword']") private WebElement pass;
	@FindBy (xpath="//input[@id='btnLogin']") private WebElement button;
	@FindBy (xpath="//b[contains(text(),'Dashboard')]") private WebElement Dashboard;
	
	public PomLoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String usernameApplication,String passwordApplicattion) throws InterruptedException
	{
		System.out.println(usernameApplication);
		System.out.println(passwordApplicattion);
		uname.sendKeys(usernameApplication);
	Thread.sleep(2000);
		pass.sendKeys(passwordApplicattion);
		Thread.sleep(2000);
		button.click();
		Thread.sleep(1000);
	String company= Dashboard.getText();
		Assert.assertEquals(company, "Dashboard");	
		System.out.println(Dashboard);
		
		
	}
}
