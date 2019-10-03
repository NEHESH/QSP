package com.projectname.modulename.testcases;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.projectname.modulename.build.TESTBASE1;

public class login_citybank extends TESTBASE1 {
	
	 
	@Test (dataProvider = "Data_Collections")
	public void Reading_xlsx_files(Hashtable <String, String> Testdata) throws Exception {
		
		et1 = er1.startTest("TC_002 Create an Account build");
//		 driver.switchTo().frame(driver.findElement(By.xpath(or2.getProperty("changewind"))));
	//	 driver.switchTo().frame(driver.findElement(By.xpath(Testdata.get("changewind"))));
		 
		 
		 
		 driver.findElement(By.xpath(or2.getProperty("close"))).click();
			driver.switchTo().defaultContent();
		driver.findElement(By.xpath(or2.getProperty("XSIGN"))).click();
		
		
		
		 /*Set<String> new_name = driver.getWindowHandles();
		  Iterator<String> itr = new_name.iterator();
		  String first_win =itr.next();
		  String second_win = itr.next()*/;
		  
		  Set<String> set =driver.getWindowHandles();
		  Iterator<String> itr= set.iterator();
		  String First=itr.next();
		  String second = itr.next();
		  driver.switchTo().window(second);
		  driver.findElement(By.xpath(or2.getProperty("closebtn"))).click();
		 
		  
         driver.findElement(By.xpath(or2.getProperty("Xemailshow"))).sendKeys(Testdata.get("Email_id"));
         screenShots();
 		 Reporter.log("Email_ID should be entered " + Testdata.get("Email_id"));
 		 
		
		driver.findElement(By.xpath(or2.getProperty("Xpasswd"))).sendKeys(Testdata.get("passwd"));
	    screenShots();
	 	Reporter.log("passwd should be entered " + Testdata.get("passwd"));
		
	//	System.out.println("password should be enter");
		/*driver.findElement(By.xpath(or2.getProperty("Xloginbtn"))).click();
		Thread.sleep(4000);
		*/
	}
	{
		
}
}