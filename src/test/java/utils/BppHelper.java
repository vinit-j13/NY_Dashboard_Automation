package utils;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bapFlows.BapRideSearch;
import baseClass.BaseClass;

public class BppHelper extends BaseClass {
	
	final Properties properties;

	// package-bpp helper methods starts from here. Please write all BPP methods
	// here.
	public BppHelper() throws IOException {
		FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/config file/config.properties");
		
		properties = new Properties();
		
		properties.load(fr);
	}
	
	public void bppLoginEmailPass() throws InterruptedException {
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(properties.getProperty("urlBpp"));
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='email']")));
		
		WebElement Email = driver.findElement(By.xpath("//input[@name='email']"));
		Email.sendKeys(properties.getProperty("bppEmail"));

		Thread.sleep(3000);

		WebElement Password = driver.findElement(By.xpath("//input[@name='password']"));
		Password.sendKeys(properties.getProperty("bppPassword"));

		Thread.sleep(3000);

		WebElement LogInButton = driver.findElement(By.xpath("//div[@data-button-text='Securely Login']"));
		LogInButton.click();

	}

	// Method to search driver with help of phone number
	public void searchDriverBynumber() throws InterruptedException {
		driver.findElement(By.xpath("//input[@inputmode='text']")).sendKeys(properties.getProperty("driverPhone"));
		Thread.sleep(2000);
		// Search button
		driver.findElement(By.xpath("//button[@data-button-for='search']")).click();
		Thread.sleep(4000);
	}

	// Method for clicking on booking details
	public void clickBookingDetail() throws InterruptedException {
		driver.findElement(By.xpath("//div[@data-sidebar-option='Booking Details']")).click();
		Thread.sleep(2000);
	}

	// Method for entering ride OTP and search
	public void enterOtpAndSearch() throws InterruptedException {
		// Enter OTP box
		driver.findElement(By.xpath("//input[@name='bookingOtp']")).sendKeys(BapRideSearch.OTP);
		Thread.sleep(2000);
		// Search button
		driver.findElement(By.xpath("//button[@aria-label='search']")).click();
		Thread.sleep(2000);
	}

	// Method for searching vehicle
	public void searchVehicleButtonClick() throws InterruptedException {
		// search vehicle button
		driver.findElement(By.xpath("//button[@aria-label='searchVehicle']")).click();
		Thread.sleep(2000);
	}

	// Method for starting ride
	public void startRideScreen(String vehicleNumber) throws InterruptedException {
		// Enter vehicle number
		driver.findElement(By.xpath("//input[@name='vehicleNumber']")).sendKeys(vehicleNumber);
		Thread.sleep(2000);
		// Enter driver phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(properties.getProperty("driverPhone"));
		Thread.sleep(2000);
		// Location drop down
		driver.findElement(By.xpath("//button[@aria-label='location']")).click();
		Thread.sleep(2000);
		// Santragachi location select
		driver.findElement(By.xpath("//div[@data-text='Santragachi']")).click();
		Thread.sleep(2000);
		// start ride
		driver.findElement(By.xpath("//button[@aria-label='startRide']")).click();
		Thread.sleep(2000);

	}

	// Method for Go To Ride Management
	public void goToRideManagement() throws InterruptedException {
		driver.findElement(By.xpath("//div[@data-sidebar-option='Ride Management']")).click();
		Thread.sleep(3000);
	}

	// Method for entering driver number in ride management section
	public void enterDriverInRidemanagement() throws InterruptedException {
		// search by driver name
		driver.findElement(By.xpath("//input[@placeholder='Search By Driver Number']")).sendKeys(properties.getProperty("driverPhone"));
		Thread.sleep(3000);
	}

	// Method for making ride status ongoing
	public void rideStatus() throws InterruptedException {
		// Ride Status button
		driver.findElement(By.xpath("//button[@aria-label='rideStatus']")).click();
		Thread.sleep(2000);
		// ongoing status click
		driver.findElement(By.xpath("//div[@data-text='Ongoing']")).click();
		Thread.sleep(1500);
	}

	// Method to click apply button after date selection
	public void clickApplyButton() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-button-for='apply']")).click();
	}

	// Method to click on entries
	public void clickOnEntries() throws InterruptedException {
		Thread.sleep(3000);
		// click on entries
		driver.findElement(By.xpath("//div[@data-label='ONGOING']")).click();

	}

	// Method to end the ride
	public void endRide() throws InterruptedException {
		Thread.sleep(3500);
		// end ride button
		driver.findElement(By.xpath("//button[@data-button-for='endRide']")).click();
		Thread.sleep(2000);
		// end popup button
		driver.findElement(By.xpath("//button[@data-button-for='end']")).click();
		Thread.sleep(2000);
	}

}
