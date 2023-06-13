package com.sat2farm.POMPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMClass_Login {
	
	private WebDriver driver;
	private Actions act;
	public JavascriptExecutor js;
	
	public static void slowType(WebElement element, String text, int delayInMillis) throws InterruptedException 
	
	{
	    for (char c : text.toCharArray()) 
	    {
	        element.sendKeys(String.valueOf(c));
	        Thread.sleep(delayInMillis);
	    }
	}

	
	
	
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='typepass']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='submit']")
	private WebElement loginBtn;
	

	
	public void sendUsername() throws InterruptedException
	{
		slowType(username, "8007300900", 200); 
	}
	
	
	public void sendPassword() throws InterruptedException
	{
		slowType(password, "Amar@0900", 200); 
	}
	
	
	
	public void clickLoginBtn()
	{
		loginBtn.click();
		
	}
	
	
	
	public POMClass_Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		act = new Actions(driver);
		 js = (JavascriptExecutor)driver;
	}

	
	
	
}
