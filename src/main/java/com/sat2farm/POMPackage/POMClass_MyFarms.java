package com.sat2farm.POMPackage;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMClass_MyFarms {
	
	
	private WebDriver driver;
	public Actions act;
	public JavascriptExecutor js;
	
	@FindBy(xpath="//b[normalize-space()='Logout']")
	private WebElement logoutBtn;
	
	public void clickLogoutBtn()
	{
		logoutBtn.click();
	}
	

	
	
// zoom in 
	
	@FindBy(xpath="//button[normalize-space()='+']")
	private WebElement zoomIn;
	
	public void ClickZoomIn()
	{
		zoomIn.click();
	}
	
	@FindBy(xpath="//button[contains(text(),'−')]")
	private WebElement zoomOut;
	
	public void ClickzoomOut()
	{
		zoomOut.click();
	}
	
	
	
	@FindBy(xpath="(//i[@class='fa-solid fa-unlock'])[2]")
	private WebElement lockFarm;
	
	public void ClicklockFarm()
	{
		lockFarm.click();
	}
	
	
	@FindBy(xpath="//div[@id='wrapper']//div[2]//div[2]//div[1]//button[3]//i[1]")
	private WebElement unlockFarm;
	
	public void ClickUnlockFarm()
	{
		unlockFarm.click();
	}
	
	
	@FindBy(xpath="//button[@id='weatherBtn']")
	private WebElement weatherBtn;
	
	@FindBy(xpath="//p[@id='D0']")
	private WebElement weatherDate;
	
	@FindBy(xpath="//button[@id='cropCalBtn']")
	private WebElement cropCalenderBtn;
	
	@FindBy(xpath="//b[@id='datee']")
	private WebElement cropCalenderDate;
	
	@FindBy(xpath="//button[@id='pestDiseaseBtn']")
	private WebElement pestAndDiesaseBtn;
	
	@FindBy(xpath="(//span[contains(text(),'2023-04-19 to 2023-04-23')])[9]")
	private WebElement pestAndDiesaseDate;
	
	@FindBy(xpath="//button[@id='smBtn']")
	private WebElement soilMoistureBtn;
	
	@FindBy(xpath="(//canvas[@class='canvasjs-chart-canvas'])[2]")
	private WebElement soilMoistureImg;
	
	@FindBy(xpath="//button[@id='ndviBtn']")
	private WebElement cropHealthBtn;
	
	@FindBy(xpath="(//img[@class='smimage'])[1]")
	private WebElement cropHealthNDVI_Graph;
	
	@FindBy(xpath="//button[@id='lswiBtn']")
	private WebElement lswiBtn;
	
	@FindBy(xpath="//div[@id='image_div_lswi']//img[@class='smimage']")
	private WebElement lswiGraph;
	
	@FindBy(xpath="//button[@id='irrigationBtn']")
	private WebElement irrigationBtn;
	
	@FindBy(xpath="//button[@id='imageAdvBtn']")
	private WebElement imageAdvisoryBtn;
	
	@FindBy(xpath="//button[@id='soilRepBtn']")
	private WebElement soilreportBTn;
	
	@FindBy(xpath="//button[@id='MoreBtn']")
	private WebElement moreInfoBtn;
	
	@FindBy(xpath="//button[@id='productDisabled']")
	private WebElement productBtn;
	
	
	
	public void ClickWeatherBtn() throws InterruptedException
	{
		
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		weatherBtn.click();
		Thread.sleep(6000);
		
		
	}
	
	public String getTextWeatherDate()
	{
		String WeatherSelected = weatherDate.getText();
		return WeatherSelected;	
	}
	
	
	public void ClickCropCalenderBtn() throws InterruptedException
	{	
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		cropCalenderBtn.click();
		Thread.sleep(9000);
	}
	
	public String getTextCropCalenderDate()
	{
		String CropCalenderSelected = cropCalenderDate.getText();
		return CropCalenderSelected;
	}
	
	
	public void ClickpestAndDiesaseBtn() throws InterruptedException
	{
		
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		pestAndDiesaseBtn.click();
		Thread.sleep(9000);
		
	}
	
	public String getTextPestAndDiesase()
	{
		String PestAndDiesaseSelected = pestAndDiesaseDate.getText();
		return PestAndDiesaseSelected ;
		
	}
	

		
	public void ClickSoilMoisture() throws InterruptedException
	{

		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		soilMoistureBtn.click();
		Thread.sleep(8000);
	}
	
	public boolean getImageSoilMoisture()
	{
		Boolean SoilMoistrueImg = soilMoistureImg.isDisplayed();
        return SoilMoistrueImg;
	}
	
	
	
	
	public void ClickCropHealth() throws InterruptedException
	{
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		cropHealthBtn.click();
		Thread.sleep(8000);
	}
	
	public boolean CropHealthImage()
	{
		boolean NDVI_Graph = cropHealthNDVI_Graph.isDisplayed();
		return NDVI_Graph;
	}
	
	
	public void ClickLSWI() throws InterruptedException
	{
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		lswiBtn.click();
		Thread.sleep(9000);
	}
	
	
	public boolean lswiImage() throws InterruptedException
	{
		Thread.sleep(4000);
		boolean LSWI = lswiGraph.isDisplayed();
		return LSWI;
	}
	
	public void ClickIrrigation() throws InterruptedException
	{
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		irrigationBtn.click();
		Thread.sleep(5000);
	}
	
	public void ClickImageAdvisory() throws InterruptedException
	{
		Thread.sleep(8000);
		imageAdvisoryBtn.click();
	}
	
	public void ClickSoilReport() throws InterruptedException
	{
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		soilreportBTn.click();
		Thread.sleep(10000);
	}
	
	public void ClickMoreInfo() throws InterruptedException
	{
		Thread.sleep(2000);
		moreInfoBtn.click();
	}
	
	
	public void ClickProduct() throws InterruptedException
	{
		Thread.sleep(2000);
		productBtn.click();
	}
	
	
	
	public POMClass_MyFarms(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		act = new Actions(driver);
	    js = (JavascriptExecutor)driver;
	}
	
	

}
