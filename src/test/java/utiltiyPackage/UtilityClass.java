package utiltiyPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class UtilityClass 
{
	WebDriver driver;
	
	public String excelData(String Sheetname, int Row, int Cell) throws EncryptedDocumentException, IOException, InterruptedException
	{
		String value= null;
		String path=("C:\\Users\\Admin\\Desktop\\test.xlsx\\");
		FileInputStream fis= new FileInputStream(path);
		Thread.sleep(2000);
		value= WorkbookFactory.create(fis).getSheet(Sheetname).getRow(Row).getCell(Cell).getStringCellValue();
		Thread.sleep(2000);
		return value;
	}
	
	
	//screenshot,alert,frames,waits,pop up windows,javascript executor all of this are involved in utility  class


	public String screenshot(WebDriver driver,String method)
	{
		String dateName=Date();
		String Screenshotpath= ("E:\\Workspace_1\\HybridFramework\\screenshots\\"+method+dateName+".png");
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File(Screenshotpath);
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		System.out.println("unable to save the screenshot");
		}
		return Screenshotpath;
	}
	
	public static String Date()
	{
		Date d= new Date();
		SimpleDateFormat display= new SimpleDateFormat("yyyyMMdd_hhmmss");
		String dateName= display.format(d);
		return dateName;
	}






}
	
	

