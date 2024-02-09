package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import testBase.BaseClass;

public class TC_003_Login extends BaseClass {
	LoginPage lg;

	@Test(priority = 5, groups= {"sanity","regression"})
	public void test_Login() {
		try {
			logger.info("*****Starting TC_003_Login Page*****");
			lg = new LoginPage(driver);
			
			boolean result2 =lg.verifyLogo2();
			Assert.assertEquals(result2, true,"Zigwheels logo is not present");
			lg.clicklogo2();
			logger.info("Clicked on logo zigwheels to go back home page");
			
			
			boolean targetPage2=lg.VerifyZigwheelsPage2();
			if(targetPage2) { 
				System.out.println("Zigwheels Home page has again opened");
				Assert.assertEquals(true,true);
			}
			else {
				System.out.println("Zigwheels Home page has not opened");
				Assert.assertEquals(false, true);
			}
			
			boolean result1 =lg.verifyLogin();
			if(result1) {
				System.out.println("'Login/Signup' is present");
				Assert.assertEquals(true, true);
			}else {
				System.out.println("'Login/Signup' is not present");
				Assert.assertEquals(false, true);
			}
			
			lg.clickLogin();
			logger.info("Clicked on login");
			
			lg.SSOfLoginPage();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority=6, groups= {"regression"})
	public void test_navigateGoogle() {
		try {
			lg = new LoginPage(driver);
			
			boolean result2 = lg.verifyGoogle();
			if (result2) {
				System.out.println("'Google' is present");
				Assert.assertEquals(true, true);
			} else {
				System.out.println("'Google' is not present");
				Assert.assertEquals(false, true);
			}
			
			lg.clickgoogle();
			logger.info("Clicked on google");

			lg.setGmail(randomStrNum());
			logger.info("Provided random email id");

			lg.clickNext();
			logger.info("Clicked on next");

			lg.captureSSOfErrorMsg();

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Test(priority = 7, groups= {"regression"})
	public void excel3ErrorMsg() throws Exception {
		try {
			    lg = new LoginPage(driver);
			    
				lg.storeErrorMsg();
				logger.info("Captured the error message");
		
				logger.info("*****Ending TC_003_Login Page*****");
				
		 }catch (Exception e) {
			 e.printStackTrace();
		 }
	}

}
