package com.sat2farm.POMPackage;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

public class POMClass_AdminPage {
	
	private WebDriver driver;
	private Actions act;
	public  JavascriptExecutor js ;
	
//	@FindBy(xpath="//input[@id='farmerSearch']")
//	private WebElement searchNameTextbox;
	
//	@FindBy(xpath="(//div[@id='farm_details_section'])[10]")
//	private WebElement allFarmdetails;
	
	@FindBy(xpath="//div[@id='farmerdata']")
	List<WebElement> AllFarmers;
	
	public void clickAllFarmers() throws InterruptedException
	{
		for(int i = 0; i<AllFarmers.size(); i++)
		{
			WebElement farmer = driver.findElements(By.xpath("//div[@id='farmerdata']")).get(i);
			
			    System.out.println();
		        System.out.println("****** Farmer Detail ******");
		        System.out.println();
		        String famerDetails = farmer.getText();
		        System.out.println(famerDetails);
		       
			  JavascriptExecutor executor = (JavascriptExecutor) driver;
		        executor.executeScript("arguments[0].click();", farmer);
		        Thread.sleep(8000);
		        
		        
		       List<WebElement> allFarm = driver.findElements(By.xpath("//div[@id='farmdata']"));
		       
		       for(int j=0; j<allFarm.size();j++)
		       {
		    	   WebElement farm = driver.findElements(By.xpath("//div[@id='farmdata']")).get(j);
		    	    System.out.println();
		   	        System.out.println("****** Farm Deatail ******");
		   	        System.out.println();
		   	        Thread.sleep(8000);
		   	        
			        executor.executeScript("arguments[0].click();", farm);
			        Thread.sleep(8000);
			        
			        
			        WebElement farmID = driver.findElement(By.xpath("//div[@id='details']"));
		   	        System.out.println();
		   	        String farmIDText = farmID.getText();
		   	        System.out.println(farmIDText);
		   	        System.out.println();
		   	        
		   	        
		   	        
			        
			        
		       }
		        
		       driver.navigate().back();
		        Thread.sleep(8000);
			
		}

	
	
	
	}
	

	 public POMClass_AdminPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
		 act = new Actions(driver);
		 
	     js = (JavascriptExecutor)driver;
	 }
	
	
	
}
