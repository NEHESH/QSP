package com.salesforce_Test_base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class salesforce_login_testbase {

	public static WebDriver driver;

	public static Properties or;
	public static Properties config;
	public static ExcelReader e1 = new ExcelReader("C:\\Users\\Nehesh Sakpal\\eclipse-workspace\\com.salesforce_build\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
	
	public static ExtentReports er;	
	public static ExtentTest et;
	
	static String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(Calendar.getInstance().getTime());
	
	@BeforeMethod
	public void testsite() throws IOException {
		
		er=new ExtentReports(System.getProperty("user.dir") +"\\src\\test\\resources\\extentReports\\ExtentReport_" + timeStamp + ".html");
				
		config = new Properties();
		FileInputStream s1 = new FileInputStream(
				"C:\\Users\\Nehesh Sakpal\\eclipse-workspace\\com.salesforce_build\\src\\test\\resources\\properties\\config.properties");
		config.load(s1);

		or = new Properties();
		FileInputStream s2 = new FileInputStream(
				"C:\\Users\\Nehesh Sakpal\\eclipse-workspace\\com.salesforce_build\\src\\test\\resources\\properties\\or.properties");
		or.load(s2);

		if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Nehesh Sakpal\\eclipse-workspace\\com.salesforce_build\\src\\test\\resources\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		}
		driver.get(config.getProperty("link_url"));
		System.out.println("salesforce login page should be open ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	@AfterSuite
	public static void writeToExtentReport() {
		
		er.endTest(et);
		er.flush();
		}
	@DataProvider
	public static Object[][] Data_Collections() {
		DataCollection d1 = new DataCollection(e1, "New_sheet", "TC001_Create_an_Account3");
		return d1.dataArray();
	}
	
	public static void screenShots() throws Exception {
		
		File scrFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(Calendar.getInstance().getTime());
		
		String ReportDirectory=new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\test\\resources\\ScreenShots__" + timeStamp + ".png";
		
		File destFile=new File(ReportDirectory);
		
		FileHandler.copy(scrFile, destFile);
		
		et.log(LogStatus.PASS, et.addScreenCapture(ReportDirectory));
	}
}
