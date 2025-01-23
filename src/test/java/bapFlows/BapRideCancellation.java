package bapFlows;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import utils.BapHelper;

public class BapRideCancellation extends BaseClass {

	@Test
	public void userRideCancellationSantargachi() throws InterruptedException, IOException {

		BapHelper bapHelper = new BapHelper();

		System.out.println("Starting rideSearch....");

		bapHelper.goToTaxiBooth();

		bapHelper.enterPhoneNumber();

		bapHelper.sendOtp();

		bapHelper.enterOtp();

		bapHelper.submitOtp();
		
		//Handling new or existing user logic starts here
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			boolean isNewUser = true;

			try {
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='firstName']")));
			}

			catch (TimeoutException e) {
				System.out.println("Not a new user");
				isNewUser = false;
			}

			if (isNewUser) { //if it is a new user this block will run

				System.out.println("entering if else");

				driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("New test user");

				Thread.sleep(2000);

				wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//button[@aria-label='updateUserDetails']")));

				driver.findElement(By.xpath("//button[@aria-label='updateUserDetails']")).click();

				Thread.sleep(2000);

				bapHelper.selectLocationSantargachi();

				bapHelper.enterDropLocation("kolkata");

				bapHelper.getFares();

				bapHelper.selectEstimate();

				bapHelper.confirmBooking();
				
				bapHelper.cancelBooking();
				
				bapHelper.cancelBookingPopup();

			}

			else { //if it is an existing user this block will run

				bapHelper.searchDestinationForUser();

				bapHelper.selectLocationSantargachi();

				bapHelper.enterDropLocation("kolkata");

				bapHelper.getFares();

				bapHelper.selectEstimate();

				bapHelper.confirmBooking();
				
				bapHelper.cancelBooking();
				
				bapHelper.cancelBookingPopup();

			}

		}

		catch (Exception e) {
			System.out.println("Some error accoured. PLease check you xpath or timeouts!");
		}
		
	}
	
	@Test
	public void userRideCancellationHowrahStation() throws InterruptedException, IOException{
		 FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/config file/config.properties");
			
			Properties properties = new Properties();
			
			properties.load(fr);

			BapHelper bapHelper = new BapHelper();

			System.out.println("Starting rideSearch....");

			bapHelper.goToTaxiBooth();

			bapHelper.enterPhoneNumber();

			bapHelper.sendOtp();

			bapHelper.enterOtp();

			bapHelper.submitOtp();
			
			//Handling new or existing user logic starts here
			try {

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				boolean isNewUser = true;

				try {
					
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='firstName']")));
				}

				catch (TimeoutException e) {
					System.out.println("Not a new user");
					isNewUser = false;
				}

				if (isNewUser) { //if it is a new user this block will run

					System.out.println("entering if else");

					driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("New test user");

					Thread.sleep(2000);

					wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//button[@aria-label='updateUserDetails']")));

					driver.findElement(By.xpath("//button[@aria-label='updateUserDetails']")).click();

					Thread.sleep(2000);

					bapHelper.selectLocationHowrahStation();

					bapHelper.enterDropLocation("kolkata");

					bapHelper.getFares();

					bapHelper.selectEstimate();

					bapHelper.confirmBooking();
					
					bapHelper.cancelBooking();
					
					bapHelper.cancelBookingPopup();

				}

				else { //if it is an existing user this block will run

					bapHelper.searchDestinationForUser();

					bapHelper.selectLocationHowrahStation();

					bapHelper.enterDropLocation("kolkata");

					bapHelper.getFares();

					bapHelper.selectEstimate();

					bapHelper.confirmBooking();
					
					bapHelper.cancelBooking();
					
					bapHelper.cancelBookingPopup();

				}

			}

			catch (Exception e) {
				System.out.println("Some error accoured. PLease check you xpath or timeouts!");
			}

		
		
	}
	
	@Test
	public void userRideCancellationSealdahStation() throws InterruptedException, IOException{
		 FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/config file/config.properties");
			
			Properties properties = new Properties();
			
			properties.load(fr);

			BapHelper bapHelper = new BapHelper();

			System.out.println("Starting rideSearch....");

			bapHelper.goToTaxiBooth();

			bapHelper.enterPhoneNumber();

			bapHelper.sendOtp();

			bapHelper.enterOtp();

			bapHelper.submitOtp();
			
			//Handling new or existing user logic starts here
			try {

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				boolean isNewUser = true;

				try {
					
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='firstName']")));
				}

				catch (TimeoutException e) {
					System.out.println("Not a new user");
					isNewUser = false;
				}

				if (isNewUser) { //if it is a new user this block will run

					System.out.println("entering if else");

					driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("New test user");

					Thread.sleep(2000);

					wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//button[@aria-label='updateUserDetails']")));

					driver.findElement(By.xpath("//button[@aria-label='updateUserDetails']")).click();

					Thread.sleep(2000);

					bapHelper.selectLocationSealdahStation();

					bapHelper.enterDropLocation("kolkata");

					bapHelper.getFares();

					bapHelper.selectEstimate();

					bapHelper.confirmBooking();
					
					bapHelper.cancelBooking();
					
					bapHelper.cancelBookingPopup();

				}

				else { //if it is an existing user this block will run

					bapHelper.searchDestinationForUser();

					bapHelper.selectLocationSealdahStation();

					bapHelper.enterDropLocation("kolkata");

					bapHelper.getFares();

					bapHelper.selectEstimate();

					bapHelper.confirmBooking();
					
					bapHelper.cancelBooking();
					
					bapHelper.cancelBookingPopup();

				}

			}

			catch (Exception e) {
				System.out.println("Some error accoured. PLease check you xpath or timeouts!");
			}

		

		
	}
	
	@Test		
	public void userRideCancellationKolkataStation() throws InterruptedException, IOException{
		 FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/config file/config.properties");
			
			Properties properties = new Properties();
			
			properties.load(fr);

			BapHelper bapHelper = new BapHelper();

			System.out.println("Starting rideSearch....");

			bapHelper.goToTaxiBooth();

			bapHelper.enterPhoneNumber();

			bapHelper.sendOtp();

			bapHelper.enterOtp();

			bapHelper.submitOtp();
			
			//Handling new or existing user logic starts here
			try {

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				boolean isNewUser = true;

				try {
					
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='firstName']")));
				}

				catch (TimeoutException e) {
					System.out.println("Not a new user");
					isNewUser = false;
				}

				if (isNewUser) { //if it is a new user this block will run

					System.out.println("entering if else");

					driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("New test user");

					Thread.sleep(2000);

					wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//button[@aria-label='updateUserDetails']")));

					driver.findElement(By.xpath("//button[@aria-label='updateUserDetails']")).click();

					Thread.sleep(2000);

					bapHelper.selectLocationKolkataStation();

					bapHelper.enterDropLocation("kolkata");

					bapHelper.getFares();

					bapHelper.selectEstimate();

					bapHelper.confirmBooking();
					
					bapHelper.cancelBooking();
					
					bapHelper.cancelBookingPopup();

				}

				else { //if it is an existing user this block will run

					bapHelper.searchDestinationForUser();

					bapHelper.selectLocationKolkataStation();

					bapHelper.enterDropLocation("kolkata");

					bapHelper.getFares();

					bapHelper.selectEstimate();

					bapHelper.confirmBooking();
					
					bapHelper.cancelBooking();
					
					bapHelper.cancelBookingPopup();

				}

			}

			catch (Exception e) {
				System.out.println("Some error accoured. PLease check you xpath or timeouts!");
			}		
	}

	@Test
	public void userRideCancellationKolkataAirport() throws InterruptedException, IOException{
		 FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/config file/config.properties");
			
			Properties properties = new Properties();
			
			properties.load(fr);

			BapHelper bapHelper = new BapHelper();

			System.out.println("Starting rideSearch....");

			bapHelper.goToTaxiBooth();

			bapHelper.enterPhoneNumber();

			bapHelper.sendOtp();

			bapHelper.enterOtp();

			bapHelper.submitOtp();
			
			//Handling new or existing user logic starts here
			try {

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				boolean isNewUser = true;

				try {
					
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='firstName']")));
				}

				catch (TimeoutException e) {
					System.out.println("Not a new user");
					isNewUser = false;
				}

				if (isNewUser) { //if it is a new user this block will run

					System.out.println("entering if else");

					driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("New test user");

					Thread.sleep(2000);

					wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//button[@aria-label='updateUserDetails']")));

					driver.findElement(By.xpath("//button[@aria-label='updateUserDetails']")).click();

					Thread.sleep(2000);

					bapHelper.selectLocationKolkataAirport();

					bapHelper.enterDropLocation("kolkata");

					bapHelper.getFares();

					bapHelper.selectEstimate();

					bapHelper.confirmBooking();
					
					bapHelper.cancelBooking();
					
					bapHelper.cancelBookingPopup();

				}

				else { //if it is an existing user this block will run

					bapHelper.searchDestinationForUser();

					bapHelper.selectLocationKolkataAirport();

					bapHelper.enterDropLocation("kolkata");

					bapHelper.getFares();

					bapHelper.selectEstimate();

					bapHelper.confirmBooking();
					
					bapHelper.cancelBooking();
					
					bapHelper.cancelBookingPopup();

				}

			}

			catch (Exception e) {
				System.out.println("Some error accoured. PLease check you xpath or timeouts!");
			}


		
	}

	@Test
	public void userRideCancellationGangasagarMela() throws InterruptedException, IOException{
		 FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/config file/config.properties");
			
			Properties properties = new Properties();
			
			properties.load(fr);

			BapHelper bapHelper = new BapHelper();

			System.out.println("Starting rideSearch....");

			bapHelper.goToTaxiBooth();

			bapHelper.enterPhoneNumber();

			bapHelper.sendOtp();

			bapHelper.enterOtp();

			bapHelper.submitOtp();
			
			//Handling new or existing user logic starts here
			try {

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				boolean isNewUser = true;

				try {
					
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='firstName']")));
				}

				catch (TimeoutException e) {
					System.out.println("Not a new user");
					isNewUser = false;
				}

				if (isNewUser) { //if it is a new user this block will run

					System.out.println("entering if else");

					driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("New test user");

					Thread.sleep(2000);

					wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//button[@aria-label='updateUserDetails']")));

					driver.findElement(By.xpath("//button[@aria-label='updateUserDetails']")).click();

					Thread.sleep(2000);

					bapHelper.selectLocationGangasagarMela();

					bapHelper.enterDropLocation("kolkata");

					bapHelper.getFares();

					bapHelper.selectEstimate();

					bapHelper.confirmBooking();
					
					bapHelper.cancelBooking();
					
					bapHelper.cancelBookingPopup();

				}

				else { //if it is an existing user this block will run

					bapHelper.searchDestinationForUser();

					bapHelper.selectLocationGangasagarMela();

					bapHelper.enterDropLocation("kolkata");

					bapHelper.getFares();

					bapHelper.selectEstimate();

					bapHelper.confirmBooking();
					
					bapHelper.cancelBooking();
					
					bapHelper.cancelBookingPopup();

				}

			}

			catch (Exception e) {
				System.out.println("Some error accoured. PLease check you xpath or timeouts!");
			}


		
	}
	
}
