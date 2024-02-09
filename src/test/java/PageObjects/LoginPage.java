package PageObjects;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.ExcelUtils;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"forum_login_title_lg\"]")
	WebElement login;
	
	@FindBy(xpath="//*[@class=\"lgn-sc c-p txt-l pl-30 pr-30 googleSignIn\"]")
	WebElement google;
	
	@FindBy(xpath="//*[@id=\"identifierId\"]")
	WebElement txtEmail;
	
	@FindBy(xpath="//*[@id=\"identifierNext\"]")
	WebElement next;
	
	@FindBy(xpath="//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]/div")
	WebElement error;
	
	@FindBy(xpath="//*[@id=\"Header\"]//a/img")
	WebElement logo2;
	
	public boolean verifyLogo2() {
		boolean ub = logo2.isEnabled();	
		return ub;
	}
	
	public void clicklogo2() throws InterruptedException {
		logo2.click();
		Thread.sleep(3000);
	}
	
	public boolean VerifyZigwheelsPage2() throws InterruptedException {

		String resultWebsite = driver.getTitle();
		String expectedWebsite = "New Cars & Bikes, Prices, News, Reviews, Buy & Sell Used Cars - ZigWheels.com";
		try {
			return(resultWebsite.equals(expectedWebsite));
		}   
		catch(Exception e) {
			return(false);
		}
	}
	
	public boolean verifyLogin() {
		boolean ub = login.isEnabled();	
		return ub;
	}
	
	
	public void clickLogin() throws InterruptedException {
		login.click();
		Thread.sleep(3000);
	}
	
	public void SSOfLoginPage() {
		try {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\2303444\\eclipse-workspace\\HackathonProject\\ScreenShots\\7. LoginPage.png");
		FileUtils.copyFile(screenshotFile,destFile);}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean verifyGoogle() {
		boolean ub = google.isEnabled();	
		return ub;
	}
	
	public void clickgoogle() {
		google.click();
	}
	
	public void setGmail(String email) {
		Set<String> windowIds = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowIds);
		String childWindowId = windowList.get(1);
		driver.switchTo().window(childWindowId);
		txtEmail.sendKeys(email);
	}
	
	public void clickNext() {
		next.click();
	}
	
	public void captureSSOfErrorMsg() throws IOException, InterruptedException {
		Thread.sleep(3000);
		WebElement user = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]//section"));
		File src1 = user.getScreenshotAs(OutputType.FILE);
		File trg1 = new File("C:\\Users\\2303444\\eclipse-workspace\\HackathonProject\\ScreenShots\\8. ErrorMessage.png");
		try {
			FileUtils.copyFile(src1, trg1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void storeErrorMsg() throws IOException {
		ExcelUtils eu=new ExcelUtils(System.getProperty("user.dir")+"\\TestData\\Excel.xlsx");
		System.out.println("The Error message because of invalid email....");
		eu.setCellData("Error message", 0, 0, "Error message");
		String str = "";
		str = error.getText();
		eu.setCellData("Error message", 1, 0, str);
		System.out.println(str);
	}
	
}
