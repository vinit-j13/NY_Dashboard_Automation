package Nishedh;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import utils.NishedhHelper;

public class MerchantMakerProfile extends BaseClass { 
	@Test
	public void merchantMakerprofile() throws IOException, InterruptedException {
		NishedhHelper helper = new NishedhHelper();
		helper.merchantMakerLoginFlow();
		Thread.sleep(3000);
		System.out.println("Merchant Admin Login successful!");
	 helper.merchantMakerProfileFlow();
     Thread.sleep(5000);
     System.out.println("merchacntMakerProfile completed....");
}
}