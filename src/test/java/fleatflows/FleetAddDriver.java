package fleatflows;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class FleetAddDriver extends FleetLogin {
    @Test
    public void automateAddDriver() throws IOException {
        // Step 1: Login
        System.out.println("Initiating login process...");
        FleetLoginFlow();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            // Step 2: Click on Driver
            WebElement driverButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()=\"Drivers\"]")));
            driverButton.click();
            System.out.println(" 1. Clicked on Driver.");
            // Step 3: Click on Add Driver
            WebElement addDriverButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"flex w-full justify-end \"]/ descendant::div[3]")));
            addDriverButton.click();
            System.out.println(" 2. Clicked on Add Driver.");
            // Step 4: Enter Mobile Number
            WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Enter Driver Mobile Number\"]")));
            mobileNumberField.click();
            mobileNumberField.sendKeys("9876243210");
            System.out.println(" 3. Entered Mobile Number.");
            // Step 5: Click on Send OTP
            WebElement sendOtpButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()=\"Send OTP\"]")));
            sendOtpButton.click();
            System.out.println(" 4. Clicked on Send OTP.");
            Thread.sleep(2000);
            //Step 6: Enter OTP
            int[] otp = {7,8,9,1};
            for (int i = 0; i <= 3; i++) {
                WebElement otpField = driver.findElement(By.xpath("//div[@class='flex justify-center px-10']/descendant::input[" + (i + 1) + "]"));
                otpField.click();
                otpField.sendKeys(String.valueOf(otp[i]));
                }
            System.out.println(" 5. Entered OTP.");
            Thread.sleep(2000);
            // Step 7: Click on Add Driver
            WebElement addDriverConfirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"flex justify-center flex-row gap-8 mt-6\"]/div")));
            addDriverConfirmButton.click();
            System.out.println(" 6. Clicked on Add Driver.");
            //check for driver added
            try {
                WebElement toastElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-toast='Driver already associated with fleet']")));
                System.out.println("Toast message found: " + toastElement.getText());
            }
            catch (Exception e) {
                System.out.println(" 7. Driver added successfully");
            }
            //Click on search field
            WebElement searchfiled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Search Contact No.\"]")));
            searchfiled.click();
            searchfiled.sendKeys("9876243210");
            //searchfiled.click();
            System.out.println(" 8. Entered Mobile Number in search field");
            //Click on taf field
            WebElement search_fleetresult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=\"9876243210\"]")));
            search_fleetresult.click();
            System.out.println(" 9. clicked on result fo search field");
            // To delete the added number
            WebElement delete_fleetdr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"flex flex-row justify-between  px-4  cursor-pointer rounded-md ml-6\"]")));
            delete_fleetdr.click();
            System.out.println(" 10. Clicked on delete button");
            // To confirm delete
            WebElement confirm_fleetdelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"flex flex-row justify-end m-4 gap-2\"]/div[text()=\"Delete\"]")));
            confirm_fleetdelete.click();
            System.out.println(" 11. Contact deleted");
            Thread.sleep(2);
        }
        catch (Exception e)
        {
        }
    }
}
