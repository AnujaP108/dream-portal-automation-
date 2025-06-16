package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	public static WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		Thread.sleep(5000);
		driver.get("https://arjitnigam.github.io/myDreams/");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
