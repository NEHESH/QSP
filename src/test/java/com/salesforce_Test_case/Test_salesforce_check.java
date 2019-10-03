package com.salesforce_Test_case;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test_salesforce_check {
	@Test
	public static void testcase_two() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.salesforce.com/in/");
		System.out.println("link should be open");

		driver.findElement(By.xpath(
				"//a[@class='drawer-link-header has-child']//span[@class='linktitle'][contains(text(),'Products')]"))
				.click();
		System.out.println("products should be selected");
		driver.findElement(By.xpath(
				"//a[@class='drawer-link-header has-child']//span[@class='linktitle'][contains(text(),'Sales')]"))
				.click();
	}

}
