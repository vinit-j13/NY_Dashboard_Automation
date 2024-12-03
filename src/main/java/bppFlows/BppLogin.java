package bppFlows;
import org.openqa.selenium.By;

import bapFlows.RideSearch;
import baseClass.BaseClass;

public class BppLogin extends BaseClass {
	public static String urlBpp = "https://dashboard.integ.moving.tech/bpp/";
	public void bppLogin() throws InterruptedException {
		
		RideSearch otp = new RideSearch();
		String OTP = otp.copyOtp();
		Thread.sleep(3000);
		driver.navigate().to(urlBpp);
		System.out.println("BPP dashboard launched successfully..!");
		Thread.sleep(3000);
		//email
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[1]/div[2]/input")).sendKeys("vinit.j@nammayatri.in");
		Thread.sleep(1000);
		//password
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[2]/div[2]/input")).sendKeys("9370267592");
		Thread.sleep(1000);
		//securely login button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[4]/button[2]")).click();
		Thread.sleep(1000);
		//Booking Details
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/a/div/div[2]")).click();
		Thread.sleep(1000);
		//Enter otp box
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[2]/div/form/div[1]/div/div/div[2]/input")).sendKeys(OTP);
		Thread.sleep(1000);
		
	}

}
