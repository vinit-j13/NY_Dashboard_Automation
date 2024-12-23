package bapFlows;

import org.testng.annotations.Test;
import baseClass.BaseClass;
import utils.BapHelper;

public class BapRideCancellation extends BaseClass {

	@Test
	public void userRideCancellation() throws InterruptedException {

		BapHelper bapHelper = new BapHelper();
		
		BapRideSearch rideSearch = new BapRideSearch();

		System.out.println("Starting user ride cancellation....");

		//BapRideSearch flow is same till here
		rideSearch.rideSearchFlow();
		Thread.sleep(2000);

		// Proceed with cancellation
		bapHelper.cancelBooking();
		bapHelper.cancelBookingPopup();

		System.out.println("Ride cancellation successful.!");
	}

}
