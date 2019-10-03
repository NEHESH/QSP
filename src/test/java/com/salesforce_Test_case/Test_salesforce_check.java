package com.salesforce_Test_case;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test_salesforce_check {
@Test
	public static void testcase_two()
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.salesforce.com/in/");
		
		driver.findElement(By.xpath("//a[@class='drawer-link-header has-child']//span[@class='linktitle'][contains(text(),'Products')]")).click();
	    driver.findElement(By.xpath("//a[@class='drawer-link-header has-child']//span[@class='linktitle'][contains(text(),'Sales')]")).click();
	}
	
	
}
