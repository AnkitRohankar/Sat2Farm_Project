package com.sat2farm.TestPackage;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
	import java.util.List;

	public class TC09_All_Functionality extends TestBaseClass
	{
		
		
		public static void slowType(WebElement element, String text, int delayInMillis) throws InterruptedException 
		
		{
		    for (char c : text.toCharArray()) 
		    {
		        element.sendKeys(String.valueOf(c));
		        Thread.sleep(delayInMillis);
		    }
		}

	  
//		public static void main(String[] args) throws InterruptedException
//		{
	      
		@Test
		public void All_Functionality() throws Exception
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
	                
	                
	               
	              // Crop Calender  
	              WebElement cropCalenderBtn = driver.findElement(By.xpath("//button[@id='cropCalBtn']"));
	              executor.executeScript("arguments[0].click();",cropCalenderBtn);
	              Thread.sleep(2000);
	                              
	              WebElement CropCalenderDate = driver.findElement(By.xpath("//b[@id='datee']"));
	              String act_CropCalenderDate = CropCalenderDate.getText();
	              Thread.sleep(4000);
	              System.out.println("Crop Calender Date:"+act_CropCalenderDate);
	              System.out.println();
	              
	              
	              // Pest And Diesase
	              WebElement pestAndDiesaseBtn = driver.findElement(By.xpath("//button[@id='pestDiseaseBtn']"));
	              executor.executeScript("arguments[0].click();",pestAndDiesaseBtn);
	              Thread.sleep(8000);
	                          
	              WebElement pestAndDiesaseText = driver.findElement(By.xpath("(//div[@id='Pest_details'])[1]"));
	              String act_pestAndDiesaseText = pestAndDiesaseText.getText();
	              System.out.println("Pest and Diesase Text:"+ " "+ act_pestAndDiesaseText);
	              System.out.println();
	              
	              
	              // Soil Moisture
	              WebElement soilMoistureBtn = driver.findElement(By.xpath("//button[@id='smBtn']"));
	              executor.executeScript("arguments[0].click();",soilMoistureBtn);
	              Thread.sleep(50000);               
	            
	              WebElement soilMoistureDate = driver.findElement(By.xpath("//b[@id='date']"));
	              String act_soilMoistureDate = soilMoistureDate.getText();
	              System.out.println("Next Soil Moistute Date:"+" "+ act_soilMoistureDate);
	                
	              
	              // Crop Health
	              WebElement cropHealthBtn = driver.findElement(By.xpath("//button[@id='ndviBtn']"));
	              executor.executeScript("arguments[0].click();", cropHealthBtn);
	              Thread.sleep(50000);
	                
	              WebElement cropHealthText = driver.findElement(By.xpath("//b[@id='dateee']"));
	              String act_cropHealthText = cropHealthText.getText();
	              System.out.println("Next Crop Health Date:"+" "+act_cropHealthText);
	              
	              
	              
	              // LSWI
	              WebElement lswiBtn = driver.findElement(By.xpath("//button[@id='lswiBtn']"));
	              executor.executeScript("arguments[0].click();", lswiBtn);
	              Thread.sleep(50000);
	            
	              WebElement lswiDate = driver.findElement(By.xpath("//b[@id='date2']"));
	              String act_lswiDate = lswiDate.getText();
	              System.out.println("Next LSWI Date is:"+" "+act_lswiDate);
	              System.out.println();
	              
	              
	              
	              // Irrigation
	              WebElement irrigationBtn = driver.findElement(By.xpath("//button[@id='irrigationBtn']"));
	              executor.executeScript("arguments[0].click();",irrigationBtn);
	              Thread.sleep(10000);
	            
	              WebElement irrigationTable = driver.findElement(By.xpath("//div[@id='irrigation_table']"));
	              String act_irrigationTable = irrigationTable.getText();
	              System.out.println("Irrigation Table:");
	              System.out.println(act_irrigationTable);
	              System.out.println();
	              
	              
	              // Soil Report
	              WebElement soilReportBtn = driver.findElement(By.xpath("//button[@id='soilRepBtn']"));
	              executor.executeScript("arguments[0].click();", soilReportBtn);
	              Thread.sleep(10000);
	              System.out.println("Click on a Soil Report");
	              System.out.println();
	              
	              WebElement soilReportText = driver.findElement(By.xpath("//div[@id='soilRepError']"));
	              String SoilReportError = soilReportText.getText();
	              System.out.println(SoilReportError);
	              System.out.println();
	              
               	                
	            }

	            driver.navigate().back();
	            Thread.sleep(8000);
	            
	            allFarmers = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='farmerdata']")));
	        }

	        driver.quit();
	        
	    }
	}
	


