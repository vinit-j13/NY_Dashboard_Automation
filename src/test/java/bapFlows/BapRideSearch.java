package bapFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BapRideSearch extends BaseClass {
	
	public static String OTP = "";
	
	@Test
	public void rideSearchFlow() throws InterruptedException
	{
		String userPhone = "9191919191";
		System.out.println("Starting rideSearch....");
		
        BapRideCancellation ridebook = new BapRideCancellation();
        
        ridebook.goToTaxiBooth();
        
        ridebook.enterPhoneNumber(userPhone);
        
        ridebook.sendOtp();

        ridebook.enterOtp("7891");
        
        ridebook.submitOtp();

        ridebook.searchDestinationForUser();

        ridebook.selectLocation();
        
        ridebook.enterDropLocation("kolkata");
        
        ridebook.getFares();

        ridebook.selectEstimate();

        ridebook.confirmBooking();

		
		Thread.sleep(4500);
		BapRideSearch.OTP = copyOtp();
		System.out.println("Ended rideSearch!!");
		
	}
	@Test
	//Copy ride otp function
	public String copyOtp() throws InterruptedException {
	WebElement rideOtpElement = driver.findElement(By.xpath("//div[@class='font-bold text-fs-20 not-italic dark:text-white']"));
	Thread.sleep(2000);
	String rideOtp = rideOtpElement.getAttribute("textContent");
	return rideOtp;
	
	}
}
