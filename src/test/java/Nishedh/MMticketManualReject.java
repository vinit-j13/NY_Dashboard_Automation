package Nishedh;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import utils.NishedhHelper;

public class MMticketManualReject extends BaseClass {

	@Test
	public void mmticketManualReject() throws IOException, InterruptedException {
		NishedhHelper helper = new NishedhHelper();
		helper.merchantMakerLoginFlow();
		Thread.sleep(3000);
		System.out.println("Merchant Maker  Login successful!");
		helper.merchantMakerReport();
		Thread.sleep(3000);
		System.out.println("Merchant Maker Report completed!");
		helper.merchantMakerLogout();
		Thread.sleep(3000);
		System.out.println("Merchant Maker Logout successful!");  
		helper.merchantAdminLoginFlow();
        Thread.sleep(3000);
        System.out.println("Merchant Admin Login successful!");  
        helper.merchantAdminTakeActionReject();
		Thread.sleep(3000);
		System.out.println("Merchant Admin Take Action  Reject  Completed");
		helper.merchantAdminLogout();
		Thread.sleep(3000);
		System.out.println("Merchant Admin Logout completed!");

		
		
	}


}
