package bapFlows;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import bppFlows.BppEndRide;
import bppFlows.BppLogin;
import bppFlows.BppRideAccept;
import utils.BapHelper;

public class RideBooking_Kolkata_Howrah extends BaseClass {
	
	public static String OTP = "";

	@Test
	public void rideSearchFlowHowrah() throws InterruptedException, IOException {
		
		

		BapHelper bapHelper = new BapHelper();

		
		
		bapHelper.bapLoginEmailPass();


		bapHelper.goToTaxiBooth();

		bapHelper.enterPhoneNumber();

		bapHelper.sendOtp();

		bapHelper.enterOtp();

		bapHelper.submitOtp();
		
		//Handling new or existing user logic starts here
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			boolean isNewUser = true;

			try {
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='firstName']")));
			}

			catch (TimeoutException e) {
				System.out.println("Not a new user");
				isNewUser = false;
			}

			if (isNewUser) { //if it is a new user this block will run

				System.out.println("entering if else");

				driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("New test user");

				Thread.sleep(2000);

				wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//button[@aria-label='updateUserDetails']")));

				driver.findElement(By.xpath("//button[@aria-label='updateUserDetails']")).click();

				Thread.sleep(2000);

				bapHelper.selectLocationHowrahStation();

				bapHelper.enterDropLocation("kolkata");

				bapHelper.getFares();

				bapHelper.selectEstimate();

				bapHelper.confirmBooking();
			}

			else { //if it is an existing user this block will run

				bapHelper.searchDestinationForUser();

				bapHelper.selectLocationHowrahStation();

				bapHelper.enterDropLocation("kolkata");

				bapHelper.getFares();

				bapHelper.selectEstimate();

				bapHelper.confirmBooking();

			}

		}

		catch (Exception e) {
			System.out.println("Some error accoured. PLease check you xpath or timeouts!");
		}

		BapRideSearch.OTP = copyOtp();

		System.out.println("Ended rideSearch!!");
		
		System.out.println("Opening Driver dashboard to start the Ride");

		
		
		
		BppLogin bpplogin = new BppLogin();
		bpplogin.bppLoginFlow();
		

		
		BppRideAccept bppRideAccept = new BppRideAccept();
		bppRideAccept.bppRideAccept();
		
		 BppEndRide bppEndRide = new BppEndRide();
	        bppEndRide.endRideFlow();
	        
			
			Thread.sleep(4000);

	}

	@Test
	// Copy ride otp function
	public String copyOtp() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class='font-bold text-fs-20 not-italic dark:text-white']")));

		WebElement rideOtpElement = driver
				.findElement(By.xpath("//div[@class='font-bold text-fs-20 not-italic dark:text-white']"));

		String rideOtp = rideOtpElement.getAttribute("textContent");

		return rideOtp;

	}
	
	

}
