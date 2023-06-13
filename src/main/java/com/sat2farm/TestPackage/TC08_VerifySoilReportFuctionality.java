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

public class TC08_VerifySoilReportFuctionality extends TestBaseClass {
	
	
	@Test
	public void VerifySoilReportFuctionality() throws InterruptedException, IOException
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
		                	  WebElement soilReportBtn = driver.findElement(By.xpath("//button[@id='soilRepBtn']"));
		   	                  executor.executeScript("arguments[0].click();", soilReportBtn);
		   	                  Thread.sleep(10000);
		   	                  System.out.println("Click on a Soil Report");
		   	                  System.out.println();
		                      executor.executeScript("window.scrollBy(0,1000)");

		                    WebElement soilReportText;
		                    try {
		                    	 soilReportText = driver.findElement(By.xpath("//div[@id='soilRepError']"));
		       	                 String SoilReportError = soilReportText.getText();
		       	                 System.out.println(SoilReportError);
		       	                 System.out.println();
		       	              
		       	              
		                        } 
		                    
		                    catch (org.openqa.selenium.TimeoutException e) 
		                        {
		                            System.out.println("Soil Report is not found");    
		                            System.out.println();
		                        }
		                    
		                   } 
		                
		                catch (org.openqa.selenium.NoSuchElementException e) 
		                {
		                	System.out.println("Soil Report is not found");    
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

