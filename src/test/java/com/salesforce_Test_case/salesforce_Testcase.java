package com.salesforce_Test_case;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.salesforce_Test_base.salesforce_login_testbase;

public class salesforce_Testcase extends salesforce_login_testbase {
	
	@Test(dataProvider = "Data_Collections")
	public void Reading_xlsx_files(Hashtable<String, String> testData) throws Exception {

		et = er.startTest("TC001_Create_an_Account3");

		driver.findElement(By.xpath(or.getProperty("xFist_name"))).sendKeys(testData.get("First_Name"));
		screenShots();
		Reporter.log("first name should be entered " + testData.get("First_Name"));
	//ystem.out.println("first name should be entered " + testData.get("First_Name"));

		driver.findElement(By.xpath(or.getProperty("xLast_name"))).sendKeys(testData.get("Last_Name"));
		screenShots();
		Reporter.log("Last name should be entered " + testData.get("Last_Name"));
		//System.out.println("Last name should be entered " + testData.get("Last_Name"));
		
			driver.findElement(By.xpath(or.getProperty("xTitle"))).sendKeys(testData.get("Job_Tittle"));
			screenShots();
			Reporter.log("Job Tittle should be displayed " + testData.get("Job_Tittle"));
			//System.out.println("Job Tittle should be displayed " + testData.get("Job_Tittle"));
			
		driver.findElement(By.xpath(or.getProperty("xEmail"))).sendKeys(testData.get("Address"));
		screenShots();
		Reporter.log("Email id should be entered " + testData.get("Address"));
//		System.out.println("Email id should be entered " + testData.get("Address"));
		
		driver.findElement(By.xpath(or.getProperty("xphone"))).sendKeys(testData.get("Phone_Numer"));
		screenShots();
		Reporter.log("Phone no should be entered " + testData.get("Phone_Numer"));
//		System.out.println("Phone no should be entered " + testData.get("Phone_Numer"));
		
		driver.findElement(By.xpath(or.getProperty("xcompany"))).sendKeys(testData.get("Email_ID"));
		screenShots();
		Reporter.log("Company name should be entered \" + testData.get(\"Email_ID");
	//	System.out.println("Company name should be entered " + testData.get("Email_ID"));

		Select drpemp = new Select(driver.findElement(By.xpath("//select[@id='signup_form_1-CompanyEmployees']")));
		drpemp.selectByValue("150");
		screenShots();
		System.out.println("EMPLOYEES SHOULD BE SELECTED");

		// Thread.sleep(3000);
		Select drplang = new Select(driver.findElement(By.xpath("//select[@id='signup_form_1-CompanyLanguage']")));
		drplang.selectByValue("en_US");
		screenShots();
		System.out.println("Language should be selected");
		Thread.sleep(3000);
	}

}
