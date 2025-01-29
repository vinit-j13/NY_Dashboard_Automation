package Nishedh;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import utils.NishedhHelper;

public class MAticketBulkReject extends BaseClass {

	@Test
	public void mAticketBulk() throws IOException, InterruptedException, TimeoutException {
		NishedhHelper helper = new NishedhHelper();
		helper.merchantAdminLoginFlow();
		Thread.sleep(3000);
		System.out.println("Merchant Admin Login successful!");
		helper.merchantAdminBulkReport();
		Thread.sleep(3000);
		System.out.println("Merchant Admin  Bulk Report completed!");
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
