package com.sat2farm.TestPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.sat2farm.POMPackage.POMClass_Login;


public class TestBaseClass {
	
WebDriver driver;	

	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91876\\Downloads\\Selelium Automation\\chromedriver_win32\\chromedriver.exe");	
		
		driver = new ChromeDriver(co);
		System.out.println("Open browser");
		
		driver.manage().window().maximize();
		System.out.println("maximize the browser");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://sat2farm.com/index.php");
		System.out.println("Open URL");
		
		POMClass_Login lp = new POMClass_Login(driver);
		
		lp.sendUsername();
		System.out.println("Enter username");
		
		lp.sendPassword();
		System.out.println("Enter Password");
		
		lp.clickLoginBtn();
		System.out.println("Login Button hit");
		
		System.out.println("Went on Homepage");
		System.out.println();
		
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		System.out.println("Browser is closed");
		System.out.println("End of program");
		
		
	}
	
	
	
	
}
