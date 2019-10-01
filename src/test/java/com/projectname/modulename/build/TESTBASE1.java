package com.projectname.modulename.build;




import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.AutomationWorldByRahul.SeleniumTraining.DataCollection;
import com.AutomationWorldByRahul.SeleniumTraining.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TESTBASE1 {
	public static WebDriver driver;
	public static Properties config1;
	public static Properties or2;
	
	public static ExcelReader exc = new ExcelReader(
			"C:\\Users\\Nehesh Sakpal\\eclipse-workspace\\CITYBANKTESTNG\\src\\test\\resources\\testDATA\\NEW_DATA_EXCEL.xlsx");
	public static ExtentReports er1;
	public static ExtentTest et1;
	
	static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(Calendar.getInstance().getTime());
	
@BeforeMethod
	public void loadfiles() throws IOException
		{
	
	er1 = new ExtentReports(System.getProperty("user.dir") + "\\src\\test\\resources\\extentReports\\ExtentReport_"
			+ timeStamp + ".html");
		config1=new Properties();
		FileInputStream f1=new FileInputStream("C:\\Users\\Nehesh Sakpal\\eclipse-workspace\\CITYBANKTESTNG\\src\\test\\resources\\Properties_files\\config1.properties");
		config1.load(f1);
		
		or2=new Properties();
		FileInputStream f2=new FileInputStream("C:\\Users\\Nehesh Sakpal\\eclipse-workspace\\CITYBANKTESTNG\\src\\test\\resources\\Properties_files\\or2.properties");
		or2.load(f2);
		
		if(config1.getProperty("browser").equalsIgnoreCase("chrome"))
			
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nehesh Sakpal\\eclipse-workspace\\AutomationPractice\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(config1.getProperty("browser").equalsIgnoreCase("ie"))
		{
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\Nehesh Sakpal\\eclipse-workspace\\CITYBANKTESTNG\\src\\test\\resources\\drivers\\IEDriverServer.exe");
		
			driver=new InternetExplorerDriver();
		}		
		driver.get(config1.getProperty("app_link"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
  @AfterMethod
  public void close()
  {
   driver.quit();    
   }
  
	@AfterSuite
	public static void writeToExtentReport() {

		er1.endTest(et1);
		er1.flush();
   }
	@DataProvider
	public static Object[][] Data_Collections() {
		DataCollection d1 = new DataCollection(exc, "Sheet1", "TC_002 Create an Account build");
		return d1.dataArray();
	} 
	public static void screenShots() throws Exception {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(Calendar.getInstance().getTime());

		String ReportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
				+ "\\src\\test\\resources\\screenShots\\screenShot__" + timeStamp + ".png";

		File destFile = new File(ReportDirectory);

		FileHandler.copy(scrFile, destFile);

		et1.log(LogStatus.PASS, et1.addScreenCapture(ReportDirectory));
	}		
}
