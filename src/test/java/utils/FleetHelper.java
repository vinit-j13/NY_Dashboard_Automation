package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import baseClass.BaseClass;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class FleetHelper extends BaseClass {

    private Properties properties;

    public FleetHelper() throws IOException {
        // Load the configuration file
        FileReader fr = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config file/config.properties");
        properties = new Properties();
        properties.load(fr);
    }
    // Method for Fleet Login
    public void fleetLogin() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.pollingEvery(Duration.ofMillis(500));
        driver.get(properties.getProperty("urlfleet"));
        driver.manage().window().maximize();

        try {
            // Retrieve dynamic values from config
            String mobileNumber = properties.getProperty("fleetLoginMobileNumber");
            String cityName = properties.getProperty("fleetCity");

            // Verify the login page is loaded
            
            Assert.assertTrue(driver.getCurrentUrl().contains("fleet"), "Login page URL does not contain 'fleet'.");

            WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class=\" w-full h-screen grid md:grid-cols-2 md:gap-[10%]\"]/descendant::div[11]/input")));
            Assert.assertTrue(mobileNumberField.isDisplayed(), "Mobile number field is not visible.");
            mobileNumberField.sendKeys(mobileNumber);

            WebElement cityDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@class=\" w-full h-screen grid md:grid-cols-2 md:gap-[10%]\"]/descendant::button[01]")));
            Assert.assertTrue(cityDropdown.isDisplayed(), "City dropdown is not visible.");
            cityDropdown.click();

            WebElement citySelect = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@data-text='" + cityName + "']")));
            Assert.assertTrue(citySelect.isDisplayed(), "City option is not visible.");
            citySelect.click();

            WebElement otpButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@class=\" w-full h-screen grid md:grid-cols-2 md:gap-[10%]\"]/descendant::div[12]/div")));
            Assert.assertTrue(otpButton.isDisplayed(), "Send OTP button is not visible.");
            otpButton.click();
            // Enter OTP
            enterOtp("7891");

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@class=\" w-full h-screen grid md:grid-cols-2 md:gap-[10%]\"]/descendant::button[03]")));
            Assert.assertTrue(loginButton.isDisplayed(), "Login button is not visible.");
            loginButton.click();

//            WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                    By.xpath("//div[@class='dashboard']")));
//            Assert.assertTrue(dashboardElement.isDisplayed(), "Dashboard is not displayed after login.");
//            System.out.println("Login successful!");

        } catch (Exception e) {
            Assert.fail("An error occurred during login: " + e.getMessage());
        }
    }

    // Method to enter OTP
    
    public void enterOtp(String otp) {
        try {
            Assert.assertEquals(otp.length(), 4, "OTP must be exactly 4 digits.");

            WebElement otpField1 = driver.findElement(By.xpath("//div[@class='flex items-center h-20 w-20 border-none'][1]/input"));
            otpField1.sendKeys(String.valueOf(otp.charAt(0)));

            WebElement otpField2 = driver.findElement(By.xpath("//div[@class='flex items-center h-20 w-20 border-none'][2]/input"));
            otpField2.sendKeys(String.valueOf(otp.charAt(1)));

            WebElement otpField3 = driver.findElement(By.xpath("//div[@class='flex items-center h-20 w-20 border-none'][3]/input"));
            otpField3.sendKeys(String.valueOf(otp.charAt(2)));

            WebElement otpField4 = driver.findElement(By.xpath("//div[@class='flex items-center h-20 w-20 border-none'][4]/input"));
            otpField4.sendKeys(String.valueOf(otp.charAt(3)));

            System.out.println("OTP entered successfully.");
        } catch (Exception e) {
            Assert.fail("Failed to enter OTP: " + e.getMessage());
        }
    }

    // Method for Fleet Signup
    
    public void fleetSignUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(properties.getProperty("urlfleet"));
        driver.manage().window().maximize();

        try {
            // Retrieve dynamic values from config
            String name = properties.getProperty("fleetSignUpName");
            String mobileNumber = properties.getProperty("fleetSignUpMobileNumber");
            String email = properties.getProperty("fleetSignUpEmail");
            String cityName = properties.getProperty("fleetCity");

            // Verify the signup page is loaded
            Assert.assertTrue(driver.getCurrentUrl().contains("fleet"), "Signup page URL does not contain 'fleet'.");

            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));
            Assert.assertTrue(nameField.isDisplayed(), "Name field is not visible.");
            nameField.sendKeys(name);

            WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class=\"flex flex-row gap-40\"]/descendant::div[26]/input")));
            Assert.assertTrue(mobileNumberField.isDisplayed(), "Mobile number field is not visible.");
            mobileNumberField.sendKeys(mobileNumber);

            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
            Assert.assertTrue(emailField.isDisplayed(), "Email field is not visible.");
            emailField.sendKeys(email);

            WebElement cityDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@class=\"flex flex-row gap-40\"]/descendant::button[01]")));
            Assert.assertTrue(cityDropdown.isDisplayed(), "City dropdown is not visible.");
            cityDropdown.click();

            WebElement citySelect = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@data-text='" + cityName + "']")));
            Assert.assertTrue(citySelect.isDisplayed(), "City option is not visible.");
            citySelect.click();

            WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@data-button-for='signUp']")));
            Assert.assertTrue(signUpButton.isDisplayed(), "Sign-up button is not visible.");
            signUpButton.click();

            System.out.println("Signup successful!");

        } catch (Exception e) {
            Assert.fail("An error occurred during signup: " + e.getMessage());
        }
    }
        /**
         * Vehicle onboarding method.
         *
         * @param rcNumber   The RC number of the vehicle.
         * @param rcFilePath The file path of the RC document.
         */
    public void onboardVehicle(String rcNumber, String rcFilePath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Re-locate and click on Vehicle Tab (retry only for this element)
            WebElement vehicleTab = retryFindElement(By.xpath("//div[text()='Vehicles']"));
            vehicleTab.click();
            System.out.println("Vehicle tab clicked.");

            // Wait for Add Vehicle button to be clickable and click it
            WebElement addVehicleButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Add Vehicle']")));
            addVehicleButton.click();
            System.out.println("Add Vehicle button clicked.");
            Assert.assertTrue(addVehicleButton.isDisplayed(), "Add Vehicle button is not displayed.");

            // Re-locate and enter RC Number
            WebElement rcNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter RC No.']")));
            rcNumberField.sendKeys(rcNumber);
            System.out.println("RC Number entered.");
            Assert.assertEquals(rcNumberField.getAttribute("value"), rcNumber, "RC number does not match the entered value.");

            // Re-locate and click on Upload RC button
            WebElement uploadRcButton = retryFindElement(By.xpath("//div[@class='w-full  items-end  ']//descendant::div[4]/div[01]"));
            uploadRcButton.click();
            System.out.println("Upload RC button clicked.");
            Assert.assertTrue(uploadRcButton.isDisplayed(), "Upload RC button is not displayed.");

            // Wait for file input element and upload the file
            WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
            fileInput.sendKeys(rcFilePath);
            System.out.println("RC file path sent to file input.");
            Assert.assertTrue(fileInput.getAttribute("value").contains(rcFilePath), "File path not correctly set in the file input.");

            // Re-locate and click on confirm upload button
            WebElement confirmUploadButton = retryFindElement(By.xpath("//div[contains(@class, 'cursor-pointer') and text()='Upload RC']"));
            confirmUploadButton.click();
            System.out.println("Upload RC confirm button clicked.");
            Assert.assertTrue(confirmUploadButton.isDisplayed(), "Upload RC confirm button is not displayed.");

            // Re-locate and click on verify RC button
            WebElement verifyUploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'rounded-full') and text()='Verify RC']")));
            verifyUploadButton.click();
            System.out.println("Upload RC verify button clicked.");
            Assert.assertTrue(verifyUploadButton.isDisplayed(), "Upload RC verify button is not displayed.");

        } catch (Exception e) {
            System.out.println("An error occurred during vehicle onboarding: " + e.getMessage());
            Assert.fail("Vehicle onboarding failed: " + e.getMessage());
        }
    }

    // Retry function to find elements, if the element is stale, it will retry
    public WebElement retryFindElement(By by) {
        WebElement element = null;
        int attempts = 0;
        while (attempts < 3) {  // Retry 3 times
            try {
                element = driver.findElement(by);
                if (element.isDisplayed()) {
                    return element; // Return the element once it's visible
                }
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) {
                    throw e;  // Rethrow after 3 attempts
                }
            }
            try {
                Thread.sleep(500);  // Optionally add a small delay to let the page settle
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return element;
    }
    // Method to add LinkDriverRcStatus(
    public void LinkDriverRcStatus() {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         WebElement vehicleTab = wait.until(ExpectedConditions.elementToBeClickable(
                 By.xpath("//div['@class=text-lg dark:text-blue-800']/descendant::div[27]")));
         vehicleTab.click();
         System.out.println("Vehicle tab clicked.");
         // Step 2: Wait for the row containing the "VALID" text to be visible
         WebElement validRow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                 By.xpath("//div[@data-desc='VALID']")));
         System.out.println("Row with VALID text found.");

         // Step 3: Hover over the row to reveal the 3 dots menu
         Actions actions = new Actions(driver);
         actions.moveToElement(validRow).perform(); // Hover over the row
         System.out.println("Hovered over the row to reveal the options menu.");
         // Step 4: Wait for the options menu (three dots) to be clickable
         WebElement optionsMenu = wait.until(ExpectedConditions.elementToBeClickable(
                 By.xpath("(//div[@data-icon='more-verticle' and contains(@class, 'flex')])[1]"))); // XPath for the 3-dot icon
         optionsMenu.click();
         System.out.println("Clicked on the options menu.");
         // Step 5: Click on the Edit option
         WebElement editOption = wait.until(ExpectedConditions.elementToBeClickable(
                 By.xpath("//div[@class='flex flex-row gap-6 hover:bg-[#F7F7FA] px-4 pt-4 pb-2 cursor-pointer rounded-md m-1']//div[@data-icon='edit-3']//following-sibling::div[contains(text(), 'Edit')][1]")));
         editOption.click();
         System.out.println("Clicked on Edit.");
         
      // Step 6: Click on Vehicle Status dropdown
         WebElement vehicleStatusDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                 By.xpath("//button[@data-value='active' and contains(@class, 'cursor-pointer')]"))); // Replace with the actual XPath for the vehicle status dropdown
         vehicleStatusDropdown.click();
         System.out.println("Clicked on Vehicle Status dropdown.");

         // Step 7: Select Active or Inactive from the dropdown
         WebElement statusOption = wait.until(ExpectedConditions.elementToBeClickable(
                 By.xpath("//div[@data-text='ACTIVE' and @value='ACTIVE']"))); // Replace with the actual XPath for either "Active" or "Inactive"
         statusOption.click();
         System.out.println("Selected status from the dropdown.");

         // Step 8: Click on the Update RC Status button
         WebElement updateRcStatusButton = wait.until(ExpectedConditions.elementToBeClickable(
                 By.xpath("//div[text()='Update RC Status' and contains(@class, 'rounded-full')]"))); 
         updateRcStatusButton.click();
         System.out.println("Clicked on Update RC Status button.");

//         // Step 9: Validate the success message or changes
//         WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                 By.xpath("//xpath_of_success_message"))); // Replace with actual XPath for success message
//         System.out.println("Vehicle status updated successfully: " + successMessage.getText());

    }
    // method for linking mobile number 
    public void LinkDriverMobilenumber() {
    	//String fleetLinkDriverMobileNumberme = properties.getProperty("fleetLinkDriverMobileNumber"); 
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         WebElement vehicleTab = wait.until(ExpectedConditions.elementToBeClickable(
                 By.xpath("//div['@class=text-lg dark:text-blue-800']/descendant::div[27]")));
         vehicleTab.click();            
         System.out.println("Vehicle tab clicked.");
         // Step 2: Wait for the row containing the "VALID" text to be visible
         WebElement validRow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                 By.xpath("//div[@data-desc='VALID']")));
         System.out.println("Row with VALID text found.");

         // Step 3: Hover over the row to reveal the 3 dots menu
         Actions actions = new Actions(driver);
         actions.moveToElement(validRow).perform(); // Hover over the row
         System.out.println("Hovered over the row to reveal the options menu.");

         // Step 4: Wait for the options menu (three dots) to be clickable
         WebElement optionsMenu = wait.until(ExpectedConditions.elementToBeClickable(
                 By.xpath("(//div[@data-icon='more-verticle' and contains(@class, 'flex')])[1]"))); // XPath for the 3-dot icon
         optionsMenu.click();
         System.out.println("Clicked on the options menu.");

         // Step 5: Click on the Edit option
         WebElement editOption = wait.until(ExpectedConditions.elementToBeClickable(
                 By.xpath("//div[@class='flex flex-row gap-6 hover:bg-[#F7F7FA] px-4 pt-4 pb-2 cursor-pointer rounded-md m-1']//div[@data-icon='edit-3']//following-sibling::div[contains(text(), 'Edit')][1]")));
         editOption.click();
         System.out.println("Clicked on Edit.");

         // Step 6: Enter driver mobile number
         WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                 By.xpath("//input[@placeholder='Driver Mobile No' and @maxlength='10']")));
         mobileNumberField.clear(); // Clear the field if necessary
         mobileNumberField.sendKeys("9347842365");
         System.out.println("Entered driver mobile number.");

         // Step 7: Click on Link Driver
         WebElement linkDriverButton = wait.until(ExpectedConditions.elementToBeClickable(
                 By.xpath("/div[@class=\"flex justify-center mt-4 \"]/div[text()=\"Link Driver\"]")));
         linkDriverButton.click();
         System.out.println("Clicked on Link Driver.");
//         // Step 8: Validate the success message or changes
//         WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                 By.xpath("//xpath_of_success_message"))); // Replace with actual XPath for success message
//         System.out.println("Vehicle details updated successfully: " + successMessage.getText());

    	
    }}
    

    

    


    

        
    

    

