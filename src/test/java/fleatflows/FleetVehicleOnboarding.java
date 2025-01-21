package fleatflows;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;

public class FleetVehicleOnboarding extends FleetLogin {
    @Test
    public void vehicleOnboarding() throws IOException {
        FleetLoginFlow();
        // Test data
        String rcNumber = "KA03AB8675";
        String rcFilePath = "/Users/saikrishnatodupunuri/Desktop/Fleet_RC.jpeg";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Click on Vehicle Tab
            WebElement vehicleTab = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div['@class=text-lg dark:text-blue-800']/descendant::div[27]")));
            vehicleTab.click();
            System.out.println("Vehicle tab clicked.");

            // Click on Add Vehicle button
            WebElement addVehicleButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[text()='Add Vehicle']")));
            addVehicleButton.click();
            System.out.println("Add Vehicle button clicked.");

            // Enter RC Number
            WebElement rcNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@placeholder='Enter RC No.']")));
            rcNumberField.sendKeys(rcNumber);
            System.out.println("RC Number entered.");

            // Click on Upload RC button
            WebElement uploadRcButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@class=\"w-full  items-end  \"]//descendant::div[4]/div[01]")));
            uploadRcButton.click();
            System.out.println("Upload RC button clicked.");

            // Locate the file input and upload the file
            WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
            fileInput.sendKeys(rcFilePath);  // Send the absolute path to the file input
            System.out.println("RC file path sent to file input.");

            // Confirm upload
            WebElement confirmUploadButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'cursor-pointer') and contains(@class, 'bg-[#1A1A22]') and text()='Upload RC']")));
            confirmUploadButton.click();
            System.out.println("Upload RC confirm button clicked.");
            WebElement VerifyUploadButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'rounded-full') and contains(@class, 'cursor-pointer') and contains(@class, 'bg-[#1A1A22]') and contains(@class, 'text-center') and text()='Verify RC']")));
          VerifyUploadButton.click();
            System.out.println("Upload RC verify button clicked.");
        } catch (Exception e) {
            System.out.println("An error occurred during vehicle onboarding: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
