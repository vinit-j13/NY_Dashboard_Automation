package bapFlows;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class BapRideCancellation extends BaseClass {

    @Test
    public void userRideCancellation() throws InterruptedException {
        String userPhone = "9191919191";
        System.out.println("Starting user ride cancellation....");

        // Perform the steps up to the "Confirm the booking popup"
        goToTaxiBooth();
        enterPhoneNumber(userPhone);
        sendOtp();
        enterOtp("7891");
        submitOtp();
        searchDestinationForUser();
        selectLocation();
        enterDropLocation("kolkata");
        getFares();
        selectEstimate();

        // Confirm the booking popup
        confirmBooking();
        Thread.sleep(2000);

        // Proceed with cancellation
        cancelBooking();
        cancelBookingPopup();

        System.out.println("Ride cancellation successful.!");
    }

    // Method to go to the Taxi Booth
    public void goToTaxiBooth() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@data-sidebar-option='Taxi Booth']")).click();
    }

    // Method to enter phone number
    public void enterPhoneNumber(String phoneNumber) throws InterruptedException {
        driver.findElement(By.xpath("//input[@inputmode='text']")).sendKeys(phoneNumber);
        Thread.sleep(2000);
    }

    // Method to send OTP
    public void sendOtp() throws InterruptedException {
        driver.findElement(By.xpath("//button[@data-button-for='sendOTP']")).click();
        Thread.sleep(2500);
    }

    // Method to enter OTP
    public void enterOtp(String otp) throws InterruptedException {
        driver.findElement(By.xpath("//input[@inputmode='text']")).sendKeys(otp);
        Thread.sleep(2000);
    }

    // Method to submit OTP
    public void submitOtp() throws InterruptedException {
        driver.findElement(By.xpath("//div[@data-button-text='Submit OTP']")).click();
        Thread.sleep(2000);
    }

    // Method to search for destination for user
    public void searchDestinationForUser() throws InterruptedException {
        driver.findElement(By.xpath("//button[@aria-label='searchDestinationForUser']")).click();
        Thread.sleep(2000);
    }

    // Method to select location
    public void selectLocation() throws InterruptedException {
        driver.findElement(By.xpath("//button[@aria-label='location']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@data-text='Santragachi']")).click();
        Thread.sleep(2000);
    }

    // Method to enter drop location
    public void enterDropLocation(String location) throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search Destinations']")).sendKeys(location);
        Thread.sleep(3500);
        driver.findElement(By.xpath("//div[@data-text='Kolkata, West Bengal, India']")).click();
        Thread.sleep(3000);
    }

    // Method to click on Get Fares
    public void getFares() throws InterruptedException {
        driver.findElement(By.xpath("//button[@data-button-for='getFares']")).click();
        Thread.sleep(5000);
    }

    // Method to select estimate
    public void selectEstimate() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='font-bold text-fs-20']/../div[3]/div[1]")).click();
        Thread.sleep(2000);
    }

    // Method to confirm the booking
    public void confirmBooking() throws InterruptedException {
        driver.findElement(By.xpath("//button[@aria-label='yes,BookIt']")).click();
    }

    // Method to cancel the booking
    public void cancelBooking() throws InterruptedException {
        driver.findElement(By.xpath("//button[@aria-label='cancelBooking']")).click();
        Thread.sleep(2000);
    }

    // Method to confirm cancellation
    public void cancelBookingPopup() throws InterruptedException {
        driver.findElement(By.xpath("//button[@aria-label='yes,CancelIt']")).click();
        Thread.sleep(3000);
    }
}
