package bppFlows;

import org.openqa.selenium.By;

import baseClass.BaseClass;

public class EndRide extends BaseClass {
	public void endRideFlow() throws InterruptedException {
		String driverPhone = "9519519512";
		//ride management
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a/div/div[2]")).click();
		Thread.sleep(1000);
		//search by driver name
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[1]/div/div/div/form/div[2]/div/div[1]/div[1]/div[2]/input")).sendKeys(driverPhone);
		Thread.sleep(1000);
		//Ride Status button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[1]/div/div/div/form/div[2]/div/div[1]/div[2]/div[2]/div/div/div/button")).click();
		Thread.sleep(1000);
		//ongoing status click
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[1]/div/div/div/form/div[2]/div/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div")).click();
		Thread.sleep(1000);
		//Apply button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[1]/div/div/div/form/div[2]/div/div[2]/button[2]")).click();
		Thread.sleep(3000);
		//click on entries
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[3]/div[2]/div/table/tbody/tr/td[5]/div/div/div/div/div/div")).click();
		Thread.sleep(3500);
		//end ride button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/button")).click();
		Thread.sleep(1000);
		//end popup button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[2]/div[2]/button/div/div")).click();
		Thread.sleep(1000);
		System.out.println("Ride ended succesfully..!");
	
	}

}
