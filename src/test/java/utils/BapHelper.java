package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;

public class BapHelper extends BaseClass {

		
	public void bapLoginEmailPass(String bapEmail , String bapPassword) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));

		WebElement Email = driver.findElement(By.name("email"));
		Email.sendKeys(bapEmail);
		
		WebElement Password = driver.findElement(By.name("password"));
		Password.sendKeys(bapPassword);

		Thread.sleep(3000);

		WebElement loginButton = driver.findElement(By.xpath("//div[@data-button-text='Login']"));
		loginButton.click();
	}
	
	// Method to go to the Taxi Booth BAP
	public void goToTaxiBooth() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-sidebar-option='Taxi Booth']")).click();
	}

	// Method to enter phone number BAP
	public void enterPhoneNumber(String phoneNumber) throws InterruptedException {
		driver.findElement(By.xpath("//input[@inputmode='text']")).sendKeys(phoneNumber);
		Thread.sleep(2000);
	}

	// Method to send OTP BAP
	public void sendOtp() throws InterruptedException {
		driver.findElement(By.xpath("//button[@data-button-for='sendOTP']")).click();
		Thread.sleep(2500);
	}

	// Method to enter OTP BAP
	public void enterOtp(String otp) throws InterruptedException {
		driver.findElement(By.xpath("//input[@inputmode='text']")).sendKeys(otp);
		Thread.sleep(2000);
	}

	// Method to submit OTP BAP
	public void submitOtp() throws InterruptedException {
		driver.findElement(By.xpath("//div[@data-button-text='Submit OTP']")).click();
		Thread.sleep(2000);
	}

	// Method to search for destination for user BAP
	public void searchDestinationForUser() throws InterruptedException {
		driver.findElement(By.xpath("//button[@aria-label='searchDestinationForUser']")).click();
		Thread.sleep(2000);
	}

	// Method to select location BAP
	public void selectLocationSantargachi() throws InterruptedException {
		driver.findElement(By.xpath("//button[@aria-label='location']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-text='Santragachi']")).click();
		Thread.sleep(2000);
	}
	
	public void selectLocationHowrahStation() throws InterruptedException {
		driver.findElement(By.xpath("//button[@aria-label='location']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-text='Howrah station']")).click();
		Thread.sleep(2000);
	}
	
	public void selectLocationSealdahStation() throws InterruptedException {
		driver.findElement(By.xpath("//button[@aria-label='location']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-text='Sealdah station']")).click();
		Thread.sleep(2000);
	}
	
	public void selectLocationKolkataStation() throws InterruptedException {
		driver.findElement(By.xpath("//button[@aria-label='location']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-text='Kolkata station']")).click();
		Thread.sleep(2000);
	}
	
	public void selectLocationKolkataAirport() throws InterruptedException {
		driver.findElement(By.xpath("//button[@aria-label='location']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-text='Kolkata Airport']")).click();
		Thread.sleep(2000);
	}
	
	public void selectLocationGangasagarMela() throws InterruptedException {
		driver.findElement(By.xpath("//button[@aria-label='location']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-text='Gangasagar Mela']")).click();
		Thread.sleep(2000);
	}

	// Method to enter drop location BAP
	public void enterDropLocation(String location) throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Search Destinations']")).sendKeys(location);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-text='Kolkata, West Bengal, India']")));
		driver.findElement(By.xpath("//div[@data-text='Kolkata, West Bengal, India']")).click();
		Thread.sleep(3000);
	}

	// Method to click on Get Fares BAP
	public void getFares() throws InterruptedException {
		driver.findElement(By.xpath("//button[@data-button-for='getFares']")).click();
	}

	// Method to select estimate BAP
	public void selectEstimate() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='font-bold text-fs-20']/../div[3]/div[1]")));
		driver.findElement(By.xpath("//div[@class='font-bold text-fs-20']/../div[3]/div[1]")).click();
		Thread.sleep(2000);
	}

	// Method to confirm the booking BAP
	public void confirmBooking() throws InterruptedException {
		driver.findElement(By.xpath("//button[@aria-label='yes,BookIt']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@aria-label='cancelBooking']")));
 
	}

	// Method to cancel the booking BAP
	public void cancelBooking() throws InterruptedException {
		driver.findElement(By.xpath("//button[@aria-label='cancelBooking']")).click();
		Thread.sleep(2000);
	}

	// Method to confirm cancellation BAP
	public void cancelBookingPopup() throws InterruptedException {
		driver.findElement(By.xpath("//button[@aria-label='yes,CancelIt']")).click();
		Thread.sleep(3000);
	}

}