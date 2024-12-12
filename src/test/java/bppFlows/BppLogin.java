package bppFlows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import bapFlows.RideSearch;
import baseClass.BaseClass;

public class BppLogin extends BaseClass {
	@Test
	public void bppLoginFlow() throws InterruptedException {
		String urlBpp = "https://dashboard.integ.moving.tech/bpp/";
		String driverPhone = "9519519512";
		String email = "vinit.j@nammayatri.in";
		String password = "9370267592";
		
		RideSearch otp = new RideSearch();
		String OTP = otp.copyOtp();
		//Thread.sleep(2000);
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(urlBpp);
		
		//driver.navigate().to(urlBpp);
		System.out.println("BPP dashboard launched successfully..!");
		Thread.sleep(3000);
		//email
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[1]/div[2]/input")).sendKeys(email);
		Thread.sleep(2000);
		//password
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[2]/div[2]/input")).sendKeys(password);
		Thread.sleep(2000);
		//securely login button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[4]/button[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[2]/div/form/div/div[1]/div/span[2]/div/input")).sendKeys(driverPhone);
		Thread.sleep(2000);
		//Search button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[2]/div/form/div/div[2]/div/button[2]")).click();
		Thread.sleep(4000);
		//Copy vehicle number
		String vehicleNumber = copyVehicleNumber();
		Thread.sleep(2000);
		//Booking Details
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/a/div/div[2]")).click();
		Thread.sleep(2000);
		//Enter OTP box
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[2]/div/form/div[1]/div/div/div[2]/input")).sendKeys(OTP);
		Thread.sleep(2000);
		//Search button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[2]/div/form/div[2]/button[2]")).click();
		Thread.sleep(2000);
		//search vehicle button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[3]/button")).click();
		Thread.sleep(2000);
		//Enter vehicle number
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[4]/div/div[2]/div/form/div[1]/div[1]/div[2]/input")).sendKeys(vehicleNumber);
		Thread.sleep(2000);
		//Enter driver phone number
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[4]/div/div[2]/div/form/div[1]/div[2]/div[2]/input")).sendKeys(driverPhone);
		Thread.sleep(2000);
		//Location dropdown 
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[4]/div/div[2]/div/form/div[1]/div[3]/div[2]/div/div/div/button")).click();
		Thread.sleep(2000);
		//santragachi location select
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[4]/div/div[2]/div/form/div[1]/div[3]/div[2]/div/div[2]/div/div/div[3]/div/div[1]/div/div/div")).click();
		Thread.sleep(2000);
		//start ride
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[4]/div/div[2]/div/form/div[2]/button[2]")).click();
		Thread.sleep(2000);
	}
	
	//copy vehicle number function
	public String copyVehicleNumber() {
		WebElement vehicleNumberElement = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[4]/div[2]/div/div/div[9]/div[1]/div[2]/div"));
		String vehicleNumber = vehicleNumberElement.getText();
		return vehicleNumber;
	}

}
