package Nishedh;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import utils.NishedhHelper;

public class MerchantAdminFlow extends BaseClass {

	@Test
	public void merchantAdminFlow() throws IOException, InterruptedException {
		NishedhHelper helper = new NishedhHelper();
		helper.merchantAdminLoginFlow();
		Thread.sleep(3000);
		System.out.println("Merchant Admin Login successful!");
		helper.merchantAdminTakeActionApprove();
		Thread.sleep(3000);
		System.out.println("Merchant Admin Take Action successful!"); 
		helper.merchantAdminLogout();
		Thread.sleep(3000);
		System.out.println("Merchant Admin Logout successful!");  
		 
		
	}

}
