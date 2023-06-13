package com.sat2farm.TestPackage;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


  
public class TC01_VerifyWeatherFunctionality extends TestBaseClass {
	
	
	
	@Test
	public void VerifyWeatherFunctionality() throws InterruptedException, IOException
	{
	
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		 List<WebElement> allFarmers = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='farmerdata']")));

	      
	        for (int i = 0; i < allFarmers.size(); i++) 
	        {  
	        	
	        	WebElement farmer = allFarmers.get(i);
	            System.out.println("************************ Farmer Detail *************************");
	            String farmerDetails = farmer.getText();
	            System.out.println(farmerDetails);
	            System.out.println();

	            JavascriptExecutor executor = (JavascriptExecutor) driver;
	            executor.executeScript("arguments[0].click();", farmer);
	            Thread.sleep(8000);
	          
	          

	            List<WebElement> allFarm = driver.findElements(By.xpath("//div[@id='farmdata']"));

	            for (int j = 0; j < allFarm.size(); j++) {
	                WebElement farm = allFarm.get(j);
	                executor.executeScript("arguments[0].click();", farm);
	                System.out.println("************** Farm Detail ****************");
	                System.out.println();
	                Thread.sleep(6000);
	                
	                WebElement farmID = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='details']")));
	                String farmIDText = farmID.getText();
	                Thread.sleep(6000);
	                System.out.println(farmIDText);
	                System.out.println();


	                try {
	                    WebElement weatherBtn = driver.findElement(By.xpath("//button[@id='weatherBtn']"));
	                    executor.executeScript("arguments[0].click();", weatherBtn);
	                    Thread.sleep(2000);
	                    executor.executeScript("window.scrollBy(0,1000)");

	                    WebElement WeatherDate;
	                    try {
	                            WeatherDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='D0']")));
	                            String act_WeatherDate = WeatherDate.getText();
	                            Thread.sleep(4000);
	                            System.out.println("Weather Date: " + act_WeatherDate);
	                            System.out.println();
	                        } 
	                    
	                    catch (org.openqa.selenium.TimeoutException e) 
	                        {
	                            System.out.println("Weather is not found");    
	                            System.out.println();
	                        }
	                    
	                   } 
	                
	                catch (org.openqa.selenium.NoSuchElementException e) 
	                {
                     System.out.println("Weather is not found");	
                     System.out.println();
	                }


	                
	                
	                catch (org.openqa.selenium.StaleElementReferenceException e)
	                {
	                    System.out.println("StaleElementReferenceException occurred while accessing farm details.");
	                    e.printStackTrace();
	                    allFarm = driver.findElements(By.xpath("//div[@id='farmdata']"));
	                    j--; 
	                    
	                }
            
        }

       
             driver.navigate().back();
             Thread.sleep(8000);
             allFarmers = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='farmerdata']")));
       }

    
	}  
   
}

	
	

	



