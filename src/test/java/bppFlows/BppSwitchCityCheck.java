package bppFlows;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class BppSwitchCityCheck extends BaseClass {

    @Test
    public void BppSwitchCity() throws InterruptedException {
        BppLogin BppsideLogin = new BppLogin();
        BppsideLogin.bppLoginFlow();

        Thread.sleep(3500);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        // Locate and click the dropdown to open
        WebElement CityDropDown = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@class='flex flex-row gap-2']")));
        CityDropDown.click();

        Thread.sleep(2000); // Ensure dropdown is visible

        // Get the list of dropdown items
        List<WebElement> dropdownOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
            By.xpath("//div[@data-dropdown-numeric]")));

        for (int i = 0; i < dropdownOptions.size(); i++) {
            // Re-fetch the dropdown items to avoid stale element exceptions
            dropdownOptions = driver.findElements(By.xpath("//div[@data-dropdown-numeric]"));

            // Check if dropdownOptions is empty or index exceeds the list size
            if (dropdownOptions.isEmpty() || i >= dropdownOptions.size()) {
                System.out.println("All available cities selected. Ending execution.");
                break;
            }

            // Get the current option
            WebElement option = dropdownOptions.get(i);

            // Ensure the option is visible and interactable
            if (option.isDisplayed() && option.isEnabled()) {
                String optionName = option.getText();
                System.out.println("Going to Check: " + optionName);
                js.executeScript("arguments[0].scrollIntoView(true);", option);
                actions.moveToElement(option).click().perform();
                System.out.println("Selected Sucessfully: " + optionName);
                Thread.sleep(2000);
            } else {
                System.out.println("No More City option Left");
            }

            // Do not reopen the dropdown after selecting the last element
            if (i < dropdownOptions.size() - 1) {
                CityDropDown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@class='flex flex-row gap-2']")));
                CityDropDown.click();
                Thread.sleep(1000); // Allow dropdown options to reload
            }
        }

        System.out.println("Tests Ended...");
    }
}
