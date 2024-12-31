package bppFlows;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import baseClass.BaseClass;

public class Bpp_DatePicker_RideDetails extends BaseClass {

    @Test
    public void Bpp_RideDetails_WithMobileNumberAndDate() throws InterruptedException, IOException {
        
        BppLogin BppsideLogin = new BppLogin();
        BppsideLogin.bppLoginFlow();

        Thread.sleep(3500);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);
        
        Thread.sleep(3000);
        WebElement CityDropDown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='flex flex-row gap-2']")));
            CityDropDown.click();
            
            
            Thread.sleep(3000);
            
            //check if Dropdown have "nammayatripartner merchant"
        
        String NYPbangalorexpath = "//div[@data-text='NAMMA YATRI PARTNER:Bangalore']";

        try {
            // Wait for the Bangalore NYP to be present
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(NYPbangalorexpath)));

            if (element.isDisplayed()) {
                System.out.println("Bangalore Operating City is validated so continuing the testCase");
                
                element.click();
                Thread.sleep(3000);
                
                WebElement RideManagement = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@data-sidebar-option='Ride Management']")));
                RideManagement.click();
                
            
                
                Thread.sleep(4000);
                
                
                
                WebElement Drivernumber = driver.findElement(By.xpath("//div[@data-id='Search By Driver Number']//input"));
                Drivernumber.click();
                Thread.sleep(3000);
                Drivernumber.sendKeys("8340834010");
                
                Thread.sleep(2000);
                
                WebElement RideStatusDropDown = driver.findElement(By.xpath("//button[@aria-label='rideStatus']"));
                RideStatusDropDown.click();
                Thread.sleep(3000);
                
                
                Thread.sleep(1500);
                
                WebElement StatusCompleted = driver.findElement(By.xpath("//div[@data-text='Completed']"));
                StatusCompleted.click();
                Thread.sleep(3000);
                
                
                WebElement DatePicker = driver.findElement(By.xpath("//button[@aria-label='[fromDate]➟[ToDate]']"));
                DatePicker.click();
                
                Thread.sleep(2000); // Wait for the date picker to load

                // Ensure the month (December, 2024) is selected
                while (true) {
                    WebElement calendarDateElement = driver.findElement(By.xpath("//div[@data-calendar-date]"));
                    String calendarDate = calendarDateElement.getText();

                    if (calendarDate.equals("December, 2024")) {
                        System.out.println("Expected month selected which is: " + calendarDate);
                        break;
                    } else {
                        WebElement chevronLeft = driver.findElement(By.xpath("//div[@data-icon='chevron-left']"));
                        chevronLeft.click();
                        Thread.sleep(1000); 
                    }
                }

             // Select the start date (December 1)
                WebElement startDateElement = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//tr[@class='transition duration-300 ease-in-out']/../tr[1]/td[1]")));
                startDateElement.click();

                
                Thread.sleep(2500); // Small delay for interaction

                // Select the end date (till 22nd Dec)
                WebElement endDateElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//tr[@class='transition duration-300 ease-in-out']/../tr[4]/td[1]")));
                endDateElement.click();
                Thread.sleep(2500);

                // Tapping on Apply to complete the Search
                WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@data-button-text='Apply']"))); 
                applyButton.click();
                
                Thread.sleep(5000);
                
                
                
                try {
                    // Wait until the element is present
                    WebElement rideCreatedAtHeaderValidation = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//th[@data-table-heading='Ride Created At']")));

                    // Perform assertion to validate element presence
                    Assert.assertTrue(rideCreatedAtHeaderValidation.isDisplayed(), "'Ride Created At' header is not displayed.");
                    System.out.println("Assertion Passed: 'Ride Created At' header is present.Continue case with Searching Short Id");
                    
                } catch (WebDriverException e) {
                    System.out.println("Assertion Failed: 'Ride Created At' header is not present. Error: " + e.getMessage());
                }

            } else {
                System.out.println("Bangalore operating City is not visible. Stopping the testcase");
                Assert.fail("Provided credentials do not have access for Bangalore operating access");
            }
                        // Continue case with taking short Id            
            
            Thread.sleep(1500);
            
            WebElement RideShortId = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//td[@data-table-location='Ride List_tr1_td1']//div//div")));
            
            String ShortIdRide = RideShortId.getText();
            System.out.println(ShortIdRide);
            
            Thread.sleep(2000);
            // clearing driving number 
            WebElement Drivernumber1 = driver.findElement(By.xpath("//div[@data-id='Search By Driver Number']//input"));
            Drivernumber1.sendKeys(Keys.COMMAND + "a"); 
            Drivernumber1.sendKeys(Keys.DELETE);            
            Thread.sleep(5000);
            
            
            WebElement ShortRideIdBox = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@data-input-name='rideShortId']//input")));
            ShortRideIdBox.click();
            Thread.sleep(3000);
            ShortRideIdBox.sendKeys(ShortIdRide);
            
            Thread.sleep(3000);
            
         // Tapping on Apply to complete the Search
            WebElement applyButton1 = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@data-button-text='Apply']"))); 
            applyButton1.click();
            
            Thread.sleep(1500);
            
         // Wait until the element is present
            WebElement ShortIdValidation = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@data-table-location='Ride List_tr1_td1']/..")));
            
            Thread.sleep(1500);
            
            // Perform assertion to validate element presence
            Assert.assertTrue(ShortIdValidation.isDisplayed(), "Provided ShortId's RideSummery is not validated ");
            System.out.println("Assertion Passed: Ride info with Short Id is Validated. Continue case by Taking Customer Phone number_____________");
            
            Thread.sleep(1500);
            
            // Extracting Customer Phone Number in String 'CheckingWithCustomerNumber'
            
            WebElement CustomerNumber = wait.until(ExpectedConditions.presenceOfElementLocated(
            	    By.xpath("//td[@data-table-location='Ride List_tr1_td8']//div//div")));

            	String CheckingWithCustomerNumber = CustomerNumber.getText();
            	System.out.println("Using Customer is: " + CheckingWithCustomerNumber);

            
            Thread.sleep(3500);
            
            WebElement SearchByCustomerNumber = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@data-id='Search By Customer Number']//input"))); 
                      
            Thread.sleep(5000);
            SearchByCustomerNumber.click();
            SearchByCustomerNumber.sendKeys(CheckingWithCustomerNumber);
            
            Thread.sleep(1500);
            
            WebElement SearchByShortId1 = driver.findElement(By.xpath("//div[@data-input-name='rideShortId']//input"));
            SearchByShortId1.sendKeys(Keys.COMMAND + "a"); 
            SearchByShortId1.sendKeys(Keys.DELETE);  
            
            Thread.sleep(2000);
            
            
            WebElement applyButton2 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@data-button-text='Apply']"))); 
                    applyButton2.click();
            Thread.sleep(5000);
            
            System.out.println("Validated Completed Ride Details between date of 'Dec 1 to Dec 22' info via driver number, shortRideId & CustomerNumber");
            
            
            
            
            
            
                    
            
            
            
            
            
            
            
            
            
        } catch (Exception e) {
            // If Bangalore element is not found, stop the running script
            System.out.println("Bangalore operating City is not present or provided driver number doesn't belong to Bangalore City. Stopping the testCase");
            Assert.fail("Bangalore operating City is not found on the WebPage.");
        } finally {
            // Close the driver
            driver.quit();
        }
    }
}
