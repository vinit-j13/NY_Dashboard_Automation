package bapFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;

public class RideSearch extends BaseClass {
	public void rideSearchFlow() throws InterruptedException
	{
		String userPhone = "9191919191";
		System.out.println("Starting rideSearch....");
		
		//Taxi Booth
		Thread.sleep(1500);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a/div/div[2]")).click();
		//Enter mobile number
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div[1]/div/div[2]/div[2]/input")).sendKeys(userPhone);
		Thread.sleep(1500);
		//Send otp Button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div[2]/div/button[2]")).click();
		Thread.sleep(1500);
		//Enter otp
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div[1]/div/div/div[2]/input")).sendKeys("7891");
		Thread.sleep(1500);
		//submit otp
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div[2]/button[2]")).click();
		Thread.sleep(1500);
		//search destination for user button 
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div[4]/button")).click();
		Thread.sleep(1500);
		//Location dropdown
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div/form/div[1]/div[1]/div[1]/div/div[2]/div/div/div/button")).click();
		Thread.sleep(1500);		
		//santragachi railway station select from dropdown
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div/form/div[1]/div[1]/div[1]/div/div[2]/div/div[2]/div/div/div[3]/div/div[1]/div/div/div")).click();
		Thread.sleep(1500);
		//Drop location(Search destination)
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div/form/div[1]/div[2]/div[2]/div/input")).sendKeys("kolkata");
		Thread.sleep(2500);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div/form/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/div/div")).click();
		Thread.sleep(1500);
		//Get Fares button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div/form/div[2]/button[2]")).click();
		Thread.sleep(5000);
		//Select estimates
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[3]/div[1]")).click();
		Thread.sleep(1000);
		//Confirm the booking popup
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div/div[3]/div/button[2]")).click();
		Thread.sleep(4500);
		System.out.println("Ended rideSearch!!");
		
	}
	
	//Copy ride otp function
	public String copyOtp() throws InterruptedException {
	WebElement rideOtpElement = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[3]/div/div[1]/div[1]/div/div[2]/div[2]"));
	Thread.sleep(2000);
	String rideOtp = rideOtpElement.getAttribute("textContent");
	return rideOtp;
	
	}
}
