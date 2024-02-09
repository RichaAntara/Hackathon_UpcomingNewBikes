package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.UsedCarsPage;
import testBase.BaseClass;



public class TC_002_UsedCars extends BaseClass {
	
	UsedCarsPage ucp ;
	List<String> popularCars;
	
	@Test(priority = 3, groups= {"sanity", "regression"})
	public void test_UsedCarsInChennai() {
		try {
			logger.info("*****Starting TC_002_Used Cars*****");
			ucp = new UsedCarsPage(driver);
			
			boolean result4 =ucp.verifyLogo1();
			Assert.assertEquals(result4, true,"Zigwheels logo is not present");
			
			ucp.clicklogo1();
			logger.info("Clicked on logo zigwheels to go back home page");
			
			boolean targetPage3=ucp.VerifyZigwheelsPage1();
			if(targetPage3) {
				System.out.println("Zigwheels Home page has again opened");
				Assert.assertEquals(true,true);
			}
			else {
				System.out.println("Zigwheels Home page has not opened");
				Assert.assertEquals(false, true);
			}
			
			ucp.hoverUsedCars();
			boolean result5 =ucp.verifyChennai();
			if(result5) {
				System.out.println("In Used Cars 'Chennai' is present");
				Assert.assertEquals(true, true);
			}else {
				System.out.println("In Used Cars 'Chennai' is not present");
				Assert.assertEquals(false, true);
			}
			
			ucp.SSOfUsedCars();
			ucp.clickChennai();
		    logger.info("In Used Cars clicked on Chennai");
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 4, groups= {"regression"})
	public void excel2PopularModels() throws Exception {
	    try {   
	    	    ucp = new UsedCarsPage(driver);
				ucp.captureSSOfModels();
				
				ucp.storePopularModels();
		        logger.info("Captured all Popular models");
				
				logger.info("*****Ending TC_002_Used Cars*****");
				
	    } catch (Exception e) {
			e.printStackTrace();
		}	
				
	}
}
