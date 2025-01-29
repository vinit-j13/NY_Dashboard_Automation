package Nishedh;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import utils.NishedhHelper;

public class PoliceAdminFlow extends BaseClass {
 
	@Test
	public void policeAdminflow() throws IOException, InterruptedException {
		NishedhHelper helper = new NishedhHelper();
		helper.policeAdminLogin();
        Thread.sleep(3000);
        System.out.println("Police Admin Login successful!");
		helper.PoliceAdminTakeActionApprove();
		Thread.sleep(3000);
		System.out.println("Police Admin Take Action Completed");
		helper.PoliceAdminLogout();
		Thread.sleep(3000);
		System.out.println("Police Admin Logout completed!");
	}
}
