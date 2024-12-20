package bapFlows;

import org.testng.annotations.Test;
import baseClass.BaseClass;
import utils.BapHelper;

public class BapRideCancellation extends BaseClass {

	@Test
	public void userRideCancellation() throws InterruptedException {

		BapHelper bapHelper = new BapHelper();

		String userPhone = "9191919191";
		System.out.println("Starting user ride cancellation....");

		// Perform the steps up to the "Confirm the booking popup"
		bapHelper.goToTaxiBooth();
		bapHelper.enterPhoneNumber(userPhone);
		bapHelper.sendOtp();
		bapHelper.enterOtp("7891");
		bapHelper.submitOtp();
		bapHelper.searchDestinationForUser();
		bapHelper.selectLocation();
		bapHelper.enterDropLocation("kolkata");
		bapHelper.getFares();
		bapHelper.selectEstimate();

		// Confirm the booking popup
		bapHelper.confirmBooking();
		Thread.sleep(2000);

		// Proceed with cancellation
		bapHelper.cancelBooking();
		bapHelper.cancelBookingPopup();

		System.out.println("Ride cancellation successful.!");
	}

}
