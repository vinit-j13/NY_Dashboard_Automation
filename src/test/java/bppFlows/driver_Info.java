package bppFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class driver_Info extends BaseClass{
	
	@Test
	public void driver_Info() throws InterruptedException , IOException {
		
        BppLogin BppsideLogin = new BppLogin();
        BppsideLogin.bppLoginFlow();

        Thread.sleep(3500);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);
        
        WebElement CityDropDown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='flex flex-row gap-2']")));
            CityDropDown.click();
            
            
            Thread.sleep(4000);
            
            //check if Dropdown have "nammayatripartner merchant"
         
            String NYPbangalorexpath = "//div[@data-text='NAMMA YATRI PARTNER:Bangalore']";

            try {
                // Wait for the Bangalore NYP be present
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(NYPbangalorexpath)));

                
                if (element.isDisplayed()) {
                    System.out.println("bangalore Operating City is validated so continuing the testCase");
                    
                    // Continue with further steps
                    
                    
                    element.click();
                    
                    Thread.sleep(6000);
                    
                 // Validating that the Bangalore operating City is selected 
                    
                    String selectedStateAfterClick = "//button[@aria-label= 'nammaYATRIPARTNER:Bangalore']";
                    boolean isSelected = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selectedStateAfterClick))).isDisplayed();

                    Assert.assertTrue(isSelected, "The Bangalore option is not selected after clicking.");
                    System.out.println("The Bangalore merchant operating city is selected.");
                    
                 // Continue with further TestCase
                    
                    System.out.println("Searching driver Info by using Phone Number");
                    
                    WebElement driverSectionSearch = wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//input[@inputmode='text']")));
                    driverSectionSearch.sendKeys("6378299813");
                    
                    Thread.sleep(3000);
                    
                    WebElement SearchButton = wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[@data-button-text='Search']")));
                    SearchButton.click();
                    
                    Thread.sleep(3000);
                    
                    WebElement DriverDetailText = wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[@class='font-bold text-fs-20 not-italic']")));
                    
                    Thread.sleep(3000);
                    
                    Assert.assertTrue(DriverDetailText.isDisplayed(), "Driver detail text is not displayed.");
                    System.out.println("Driver detail text is validated successfully.");
                    
                    
                    Thread.sleep(3000);
                    
                    // Checking and Storing driverId 
                    
                    WebElement driverIdElement = driver.findElement(By.xpath("//div[@data-label='Driver Id']/div[2]"));
                    
                    String driverId =driverIdElement.getText();
                    System.out.println("provided number driverId is : " + driverId);
                    
                    System.out.println("Navigating back to reuse search info from Person Id");
                    Thread.sleep(2500);
                    driver.navigate().back();
                    Thread.sleep(5000);
                    
                    // Validating if user is again on the search Record screen after navigating back
                    
                    WebElement searchRecord = wait.until(ExpectedConditions.elementToBeClickable(
                    		By.xpath("//div[@class='font-semibold w-fit text-lg md:ml-3 md:ml-0 ']")));
                    Assert.assertTrue(searchRecord.isDisplayed(), "User not navigated back to Search Screen");
                    		
                    Thread.sleep(2500);
                    	
                    WebElement DropDownForSearchInfo = driver.findElement(By.xpath("//div[@data-button-text='Phone Number']"));
                    DropDownForSearchInfo.click();
                    
                    Thread.sleep(3000);
                    
                    
                    
                    
                 // Wait for the "Person Id" element to be visible and clickable
                    WebElement PersonIdElement = wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[@data-text='Person Id']")));

                    // Scroll into view if necessary
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PersonIdElement);

                    PersonIdElement.click();
                    
                    Thread.sleep(3000);
                    System.out.println("Selected 'Person Id' successfully.");
                    
                    
                    WebElement driverSearchPersonId = wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//input[@inputmode='text']")));
                    driverSearchPersonId.sendKeys(driverId);
                    
                    
                    Thread.sleep(5000);
                    
                    WebElement SearchButtonPersonId = wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[@data-button-text='Search']")));
                    SearchButtonPersonId.click();
                    
                    Thread.sleep(2500);
                    
                    WebElement DriverDetailText1 = wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[@class='font-bold text-fs-20 not-italic']")));
                    
                    Thread.sleep(3000);
                    
                    Assert.assertTrue(DriverDetailText1.isDisplayed(), "Driver detail is not validated.");
                    
                    
                    
                    
                    // Checking and storing Driving License Number
                    
                    WebElement driverLicenseIdXpath = driver.findElement(By.xpath("//div[@data-label='License Number']/div[2]/div"));
                    
                    String driverLicenseId =driverLicenseIdXpath.getText();
                    System.out.println("provided number's driverLicenseId is : " + driverLicenseId);
                    
                    System.out.println("Navigating back to reuse driverLicenseId to search driverInfo");
                    Thread.sleep(2500);
                    driver.navigate().back();
                    Thread.sleep(5000);
                    
                    // Validating if user is again on the search screen after navigating back
                    
                    WebElement searchRecord1 = wait.until(ExpectedConditions.elementToBeClickable(
                    		By.xpath("//div[@class='font-semibold w-fit text-lg md:ml-3 md:ml-0 ']")));
                    Assert.assertTrue(searchRecord1.isDisplayed(), "User not navigated back to Search Screen");
                    		
                    Thread.sleep(2500);
                    
                    // reusing driverLicenseId to search driver details again
                  
                    
                    WebElement DropDownForSearchInfo1 = driver.findElement(By.xpath("//div[@data-button-text='Phone Number']"));
                    DropDownForSearchInfo1.click();
                    
                    Thread.sleep(3000);
                    
                    // Wait for the "Person Id" element to be visible and clickable
                    
                    
                       WebElement DLNumber = wait.until(ExpectedConditions.elementToBeClickable(
                               By.xpath("//div[@data-text='DL Number']")));

                       // Scroll into view if necessary
                       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DLNumber);

                       DLNumber.click();
                    
                       Thread.sleep(3000);
                       System.out.println("Selected 'DL Number' successfully.");
                       
                       
                       WebElement driverSearchDLId = wait.until(ExpectedConditions.elementToBeClickable(
                               By.xpath("//input[@inputmode='text']")));
                       driverSearchDLId.sendKeys(driverLicenseId);
                       
                       
                       Thread.sleep(3000);
                       WebElement SearchButtonDLId = wait.until(ExpectedConditions.elementToBeClickable(
                               By.xpath("//div[@data-button-text='Search']")));
                       SearchButtonDLId.click();
                        
                       
                       WebElement DriverDetailText2 = wait.until(ExpectedConditions.elementToBeClickable(
                               By.xpath("//div[@class='font-bold text-fs-20 not-italic']")));
                       
                       Thread.sleep(3000);
                       
                       Assert.assertTrue(DriverDetailText2.isDisplayed(), "Driver detail is not validated.");
                       
                       
                    // Storing Certificate Number and reuse to search the driver info again
                       
                       WebElement VehicleCertificateXpath = driver.findElement(By.xpath("//div[@data-label='Certificate Number']/div[2]/div"));
                       
                       String VehicleCertificateNumber =VehicleCertificateXpath.getText();
                       System.out.println("provided number's VehicleCertificateNumber is : " + VehicleCertificateNumber);
                       
                       System.out.println("Navigating back to reuse VehicleCertificateNumber to search driverInfo");
                       Thread.sleep(2500);
                       driver.navigate().back();
                       Thread.sleep(5000);
                       
                       // Validating if user is again on the search screen after navigating back
                       
                       WebElement searchRecord2 = wait.until(ExpectedConditions.elementToBeClickable(
                       		By.xpath("//div[@class='font-semibold w-fit text-lg md:ml-3 md:ml-0 ']")));
                       Assert.assertTrue(searchRecord2.isDisplayed(), "User not navigated back to Search Screen");
                       		
                       Thread.sleep(2500);
                       
                       WebElement DropDownForSearchInfo2 = driver.findElement(By.xpath("//div[@data-button-text='Phone Number']"));
                       DropDownForSearchInfo2.click();
                       
                       Thread.sleep(3000);
                       
                       // Wait for the "Person Id" element to be visible and clickable
                       
                       
                          WebElement RCNumber = wait.until(ExpectedConditions.elementToBeClickable(
                                  By.xpath("//div[@data-text='RC Number']")));

                          // Scroll into view if necessary
                          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RCNumber);

                          RCNumber.click();
                       
                          Thread.sleep(3000);
                          System.out.println("Selected 'RC Number' successfully.");
                          
                          
                          WebElement driverSearchRCNumber = wait.until(ExpectedConditions.elementToBeClickable(
                                  By.xpath("//input[@inputmode='text']")));
                          driverSearchRCNumber.sendKeys(VehicleCertificateNumber);
                          
                          
                          Thread.sleep(3000);
                          WebElement SearchButtonRCNumber = wait.until(ExpectedConditions.elementToBeClickable(
                                  By.xpath("//div[@data-button-text='Search']")));
                          SearchButtonRCNumber.click();
                           
                          
                          WebElement DriverDetailText3 = wait.until(ExpectedConditions.elementToBeClickable(
                                  By.xpath("//div[@class='font-bold text-fs-20 not-italic']")));
                          
                          Thread.sleep(3000);
                          
                          Assert.assertTrue(DriverDetailText3.isDisplayed(), "Driver detail is not validated.");
                          
                          
                          System.out.println("Validated searching driver details with phone number, PersonID, DL & RC");
                       
                       
                       
                       
                       
                       
                       
                       
                    
                    
                    
                    
                    	
                    
                } else {
                    System.out.println("Bangalore operating City is not visible. Stopping the testcase");
                    Assert.fail("Provided credentials do not have access for bangalore operating access");
                }
            } catch (Exception e) {
                // If Bangalore element is not found, stop the running script
            	
                System.out.println("Bangalore operating City is not present or provided driver number dont belong to Bangalore City. Stopping the testCase");
                Assert.fail("Bangalore operating City is not found on the WebPage.");
            } finally {
                // Close the driver
                driver.quit();
            }
        }
}
