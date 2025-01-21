package fleatflows;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LinkDriver_MobileNumber extends FleetLogin {

    @Test
    public void automateEditVehicleDetails() throws IOException {
        // Step 1: Login
        System.out.println("Initiating login process...");
        FleetLoginFlow();

        try {
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
                    By.xpath("//div[contains(text(), 'Link Driver') and @class='rounded-full cursor-pointer bg-[#1A1A22] intems-center opacity-50 pt-3 text-center h-12 w-28 text-white']")));
            linkDriverButton.click();
            System.out.println("Clicked on Link Driver.");

            // Step 8: Validate the success message or changes
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//xpath_of_success_message"))); // Replace with actual XPath for success message
            System.out.println("Vehicle details updated successfully: " + successMessage.getText());

        } catch (Exception e) {
            System.out.println("An error occurred during the Edit Vehicle Details flow: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
