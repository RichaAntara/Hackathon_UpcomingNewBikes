package PageObjects;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Utilities.ExcelUtils;

public class UsedCarsPage extends BasePage {
	public UsedCarsPage(WebDriver driver) {
		super(driver);
	}
	
	
	//Elements
	    @FindBy(xpath="//*[@id=\"Header\"]/div/div[1]/div[1]/a/img")
	    WebElement logo1;
	
		@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]//li[7]/a")
		WebElement usedCars;
		
		@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[7]/ul/li/div[2]/ul/li[4]/span")
		WebElement chennaiCars;
		
		@FindBy(xpath="//*[@id=\"data-set-body\"]/div[1]//div[3]/div[2]/a")
		WebElement uptoPopularModels;
		
		@FindBy(xpath = "//li[contains(@id,'mmvLi')]/label")
		List<WebElement> carsPopularModels;
		
		
		
		public boolean verifyLogo1() {
			boolean ub = logo1.isEnabled();	
			return ub;
		}
		
		public void clicklogo1() throws InterruptedException {
			logo1.click();
			Thread.sleep(3000);
		}
		
		public boolean VerifyZigwheelsPage1() throws InterruptedException {

			String resultWebsite = driver.getTitle();
			String expectedWebsite = "New Cars & Bikes, Prices, News, Reviews, Buy & Sell Used Cars - ZigWheels.com";
			try {
				return(resultWebsite.equals(expectedWebsite));
			}   
			catch(Exception e) {
				return(false);
			}
		}
		
		
		public void hoverUsedCars() throws IOException, InterruptedException {
			Actions act = new Actions (driver);
			act.moveToElement(usedCars).build().perform(); 
			Thread.sleep(3000);		
		}
		
		public boolean verifyChennai() {
			boolean ub = chennaiCars.isEnabled();	
			return ub;
		}
		
		public void SSOfUsedCars() {
			try {
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File("C:\\Users\\2303444\\eclipse-workspace\\HackathonProject\\ScreenShots\\5. UsedCars.png");
			FileUtils.copyFile(screenshotFile,destFile);}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void clickChennai() throws InterruptedException {
			chennaiCars.click();
			Thread.sleep(3000);
		}

		
		public void captureSSOfModels() throws IOException, InterruptedException {
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", uptoPopularModels); 
			Thread.sleep(3000);
			WebElement user = driver.findElement(By.xpath("//li[2]//div[5]"));
			File src = user.getScreenshotAs(OutputType.FILE);
			File trg = new File("C:\\Users\\2303444\\eclipse-workspace\\HackathonProject\\ScreenShots\\6. PopularModels.png");
			try {
				FileUtils.copyFile(src, trg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void storePopularModels() throws IOException {
			ExcelUtils eu=new ExcelUtils(System.getProperty("user.dir")+"\\TestData\\Excel.xlsx");
			System.out.println("For Used cars in Chennai, all the popular models are....");
			eu.setCellData("Popular Models", 0, 0, "Popular Car Models");
			int k=1;
			for (WebElement i : carsPopularModels) {
				String str = "";
				str = i.getText();
				eu.setCellData("Popular Models", k, 0, str);
				System.out.println(str);
				k++;
			}
		} 
		
}
