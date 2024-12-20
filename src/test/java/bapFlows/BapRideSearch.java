package bapFlows;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import utils.BapHelper;

public class BapRideSearch extends BaseClass {

	public static String OTP = "";

	@Test
	public void rideSearchFlow() throws InterruptedException {
		BapHelper bapHelper = new BapHelper();

		System.out.println("Starting rideSearch....");

		bapHelper.goToTaxiBooth();

		bapHelper.enterPhoneNumber(userPhone);

		bapHelper.sendOtp();

		bapHelper.enterOtp(userOtp);

		bapHelper.submitOtp();

		bapHelper.searchDestinationForUser();

		bapHelper.selectLocation();

		bapHelper.enterDropLocation("kolkata");

		bapHelper.getFares();

		bapHelper.selectEstimate();

		bapHelper.confirmBooking();
		
		BapRideSearch.OTP = copyOtp();
		
		System.out.println("Ended rideSearch!!");

	}

	@Test
	// Copy ride otp function
	public String copyOtp() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='font-bold text-fs-20 not-italic dark:text-white']")));
		
		WebElement rideOtpElement = driver.findElement(By.xpath("//div[@class='font-bold text-fs-20 not-italic dark:text-white']"));
		
		String rideOtp = rideOtpElement.getAttribute("textContent");
		
		return rideOtp;

	}
}
