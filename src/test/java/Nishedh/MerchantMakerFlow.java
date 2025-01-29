package Nishedh;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import utils.NishedhHelper;

public class MerchantMakerFlow extends BaseClass {
	
	@Test
	public void merchantMakerflow() throws IOException, InterruptedException {
		NishedhHelper helper = new NishedhHelper();
		helper.merchantMakerLoginFlow();
		Thread.sleep(3000);
		System.out.println("Merchant Maker Login successful!");
		helper.merchantMakerReport();
		Thread.sleep(3000);
		System.out.println("Merchant Maker Report completed!");
		/* helper.merchantMakerBulkReport();
		Thread.sleep(5000);
		System.out.println("merchacntMakerBulkReport completed...."); */
        helper.merchantMakerLogout();
        Thread.sleep(5000);
        System.out.println("merchacntMakerLogout completed....");
	}

}
