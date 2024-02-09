package PageObjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ExcelUtils;

public class UpcomingBikesPage extends BasePage {
	public UpcomingBikesPage(WebDriver driver) {
		super(driver);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	//Elements
	@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]//div/ul/li[3]/a")
	WebElement newBikes;
	
	@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[3]/ul/li[5]/span")
	WebElement upcomingBikes;
	
	@FindBy(xpath="//*[@id=\"makeId\"]")
	WebElement manufacturer;
	
	@FindBy(xpath="//*[@id=\"modelList\"]/li[8]/div/div[2]/img")
	WebElement uptoMoreBikes;
	
	@FindBy(xpath="//*[@id=\"modelList\"]/li[16]/span")
	WebElement viewMoreBikes;
	
	@FindBy(xpath = "//li[contains(@class, 'modelItem')]")
	List<WebElement> bikesPrice;
	
	@FindBy(xpath="//strong[contains(@class, 'h-height')]")
	List<WebElement> modelNames;
	
	@FindBy(xpath="//div[@class='clr-try fnt-14']")
	List<WebElement> launchDates;
	
	
	//Actions
	public void SSOfHomePage() {
		try {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\2303444\\eclipse-workspace\\HackathonProject\\ScreenShots\\1. HomePage.png");
		FileUtils.copyFile(screenshotFile,destFile);}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void hoverBikes() throws InterruptedException {
		Actions act = new Actions (driver);
		act.moveToElement(newBikes).build().perform();
		Thread.sleep(3000);
	}
	
	public boolean verifyUpcomingBikes() {
		boolean ub = upcomingBikes.isEnabled();	
		return ub;
	}
	
	public void SSOfNewBikes() {
		try {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\2303444\\eclipse-workspace\\HackathonProject\\ScreenShots\\2. NewBikes.png");
		FileUtils.copyFile(screenshotFile,destFile);}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void clickUpcomingBikes() throws InterruptedException {
		upcomingBikes.click();
		Thread.sleep(3000);
	}
	
	public void SSOfUpcomingNewBikes() {
		try {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\2303444\\eclipse-workspace\\HackathonProject\\ScreenShots\\3. UpcomingNewBikes.png");
		FileUtils.copyFile(screenshotFile,destFile);}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean VerifyUpcomingBikesPage() throws InterruptedException {

		String resultWebsite = driver.getTitle();
		String expectedWebsite = "Upcoming Bikes in India 2024/25, See Price, Launch Date, Specs @ ZigWheels";
		try {
			return(resultWebsite.equals(expectedWebsite));
		}   catch(Exception e) {
			return(false);
		}
	}

	public boolean verifyHonda() {
		boolean ub = manufacturer.isEnabled();	
		return ub;
	}
	
	public void clickHonda() throws IOException, InterruptedException {
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		myWait.until(ExpectedConditions.elementToBeClickable(manufacturer));
		
		Select select = new Select(manufacturer); 
		select.selectByVisibleText("Honda");
	} 
	
	public boolean VerifyUpcomingHondaBikesPage() throws InterruptedException {

		String resultWebsite = driver.getTitle();
		String expectedWebsite = "Upcoming Honda Bikes in India 2024/25, See Price, Launch Date, Specs @ ZigWheels";
		try {
			return(resultWebsite.equals(expectedWebsite));
		}   catch(Exception e) {
			return(false);
		}
	}

	
	public boolean verifyViewMore() {
		boolean ub = viewMoreBikes.isEnabled();	
		return ub;
	}
	
	public void clickViewMore() throws IOException, InterruptedException {
		js.executeScript("arguments[0].scrollIntoView(true);", uptoMoreBikes); 
		Thread.sleep(3000);
		viewMoreBikes.click(); 
	}
	
	public void SSOfUpcomingHondaBikes() {
		try {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\2303444\\eclipse-workspace\\HackathonProject\\ScreenShots\\4. UpcomingHondaBikes.png");
		FileUtils.copyFile(screenshotFile,destFile);}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void modelDetails() throws Exception {

		ExcelUtils eu=new ExcelUtils(System.getProperty("user.dir")+"\\TestData\\Excel.xlsx");
		
	    System.out.println("Upcoming new Honda bikes which prices are less than 4 lac....");
	    eu.setCellData("Upcoming bike Details", 0, 0, "ModelName");
    	eu.setCellData("Upcoming bike Details", 0, 1, "Price");
    	eu.setCellData("Upcoming bike Details", 0, 2, "launchdate");
	    
	    int k=1;
	    for (int i = 0; i< bikesPrice.size(); i++) {
	    	String modelName = modelNames.get(i).getText();
	        double price = Double.parseDouble(bikesPrice.get(i).getAttribute("data-price"));
	        String launchdate = launchDates.get(i).getText();
	        if (price < 400000) {
	        	eu.setCellData("Upcoming bike Details", k, 0, modelName);
	        	eu.setCellData("Upcoming bike Details", k, 1, String.valueOf( price));
	        	eu.setCellData("Upcoming bike Details", k, 2, launchdate);
	        	
	        	List<String> bikeDetails = new ArrayList<>();
	            bikeDetails.add(modelName);
	            bikeDetails.add(String.valueOf(price));
	            bikeDetails.add(launchdate);
	            System.out.println(bikeDetails);
	            
	            k++;
	        } 
	    }
	} 

}
