package fleatflows;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LinkDriver_RcStatus extends FleetLogin {

    @Test
    public void LinkDriver_rc() throws IOException {
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
                    By.xpath("//div[text()='Update RC Status' and contains(@class, 'rounded-full')]"))); // Replace with the actual XPath for the Update RC Status button
            updateRcStatusButton.click();
            System.out.println("Clicked on Update RC Status button.");

            // Step 9: Validate the success message or changes
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//xpath_of_success_message"))); // Replace with actual XPath for success message
            System.out.println("Vehicle status updated successfully: " + successMessage.getText());

        }
            catch (Exception e) {
                System.out.println("An error occurred during the Edit Vehicle Details flow: " + e.getMessage());
                e.printStackTrace();
            }
    }
}

            
            
            