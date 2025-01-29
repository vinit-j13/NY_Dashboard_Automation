package Nishedh;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import utils.NishedhHelper;

public class MAticketManualReject extends BaseClass {

	@Test
	public void mAticketManual() throws IOException, InterruptedException {
		NishedhHelper helper = new NishedhHelper();
		helper.merchantAdminLoginFlow();
		Thread.sleep(3000);
		System.out.println("Merchant Admin Login successful!");
		helper.merchantAdminReport();
		Thread.sleep(3000);
		System.out.println("Merchant Admin Report completed!");
		helper.merchantAdminLogout();
		Thread.sleep(3000);
		System.out.println("Merchant Admin Logout successful!");  
		helper.policeAdminLogin();
        Thread.sleep(3000);
        System.out.println("Police Admin Login successful!");  
        helper.PoliceAdminTakeActionReject();
		Thread.sleep(3000);
		System.out.println("Police Admin Take Action Completed");
		helper.PoliceAdminLogout();
		Thread.sleep(3000);
		System.out.println("Police Admin Logout completed!");

		
		
	}

}
