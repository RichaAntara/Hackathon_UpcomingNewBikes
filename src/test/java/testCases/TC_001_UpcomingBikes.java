package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.UpcomingBikesPage;
import testBase.BaseClass;


public class TC_001_UpcomingBikes extends BaseClass{
	UpcomingBikesPage ubp ;
	
	@Test(priority = 1, groups={"sanity", "regression"})
	public void test_UpcomingBikes() {
		try {
			logger.info("*****Starting TC_001_Upcoming Bikes*****");
			ubp = new UpcomingBikesPage(driver);
			
			ubp.SSOfHomePage();
			
			ubp.hoverBikes();
			boolean result1 =ubp.verifyUpcomingBikes();
			if(result1) {
				System.out.println("In New Bikes 'Upcoming Bikes' is present");
				Assert.assertEquals(true, true);
			}else {
				System.out.println("In New Bikes 'Upcoming Bikes' is not present");
				Assert.assertEquals(false, true);
			}
			
			ubp.SSOfNewBikes();
			ubp.clickUpcomingBikes();
			logger.info("Clicked on Upcoming Bikes");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 2, groups= {"regression"})
	public void excel1Bikes() {
		
		 try {
			   ubp = new UpcomingBikesPage(driver);
			 
				// boolean targetPage1=ubp.VerifyUpcomingBikesPage(); 
				// if(targetPage1) {
				// 	System.out.println("Upcoming Bikes page has opened");
				// 	Assert.assertEquals(true,true);
				// }
				// else {
				// 	System.out.println("Upcoming Bikes page has not opened");
				// 	Assert.assertEquals(false, true);
				// }
				
				ubp.SSOfUpcomingNewBikes();
				
				boolean result2 =ubp.verifyHonda();
				if(result2) {
					System.out.println("In manufacturer'Honda' is present");
					Assert.assertEquals(true, true);
				}else {
					System.out.println("In manufacturer 'Honda' is not present");
					Assert.assertEquals(false, true);
				}
				ubp.clickHonda();
				logger.info("Clicked on Honda Bikes");
				
				// boolean targetPage2=ubp.VerifyUpcomingHondaBikesPage();
				// if(targetPage2) {
				// 	System.out.println("Upcoming Honda Bikes page has opened");
				// 	Assert.assertEquals(true,true);
				// }
				// else {
				// 	System.out.println("Upcoming Honda Bikes page has not opened");
				// 	Assert.assertEquals(false, true);
				// }
				
				ubp.SSOfUpcomingHondaBikes();
				
				boolean result3 =ubp.verifyViewMore();
				if(result3) {
					System.out.println("'View More Bikes' is present");
					Assert.assertEquals(true, true);
				}else {
					System.out.println("'View More Bikes' is not present");
					Assert.assertEquals(false, true);
				}
				ubp.clickViewMore();
				logger.info("Clicked on view more Bikes");
				
				ubp.SSOfUpcomingHondaBikes();
				
				ubp.modelDetails();
				logger.info("Captured all Upcoming Bikes under 4 lac");
				
				logger.info("*****Ending TC_001_Upcoming Bikes*****");
				
		  }catch (Exception e) {
		      e.printStackTrace(); 
	      }
     }
}
