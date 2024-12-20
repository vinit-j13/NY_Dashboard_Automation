package bppFlows;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import utils.BppHelper;

public class BppEndRide extends BaseClass {

	@Test
	public void endRideFlow() throws InterruptedException {

		BppHelper bppHelper = new BppHelper();

		

		bppHelper.goToRideManagement();

		bppHelper.enterDriverInRidemanagement(driverPhone);

		bppHelper.rideStatus();

		datePicker(); // Select date

		bppHelper.clickApplyButton();

		bppHelper.clickOnEntries();

		bppHelper.endRide();

		System.out.println("Ride ended succesfully..!");

	}

	@Test
	public void datePicker() throws InterruptedException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd"); // we specify format of date here.
		Date sysDate = new Date(); // create a date object with system's current date and time in it.

		String currentDate = dateFormat.format(sysDate); // format system's date to "dd"

		driver.findElement(By.xpath("//button[@data-custom-value='calendar_button']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("tbody")));
		WebElement dateBody = driver.findElement(By.tagName("tbody"));

		List<WebElement> dateColumns = dateBody.findElements(By.tagName("td"));

		for (WebElement cell : dateColumns) {

			if (cell.getText().equals(currentDate)) {
				System.out.println("Found current date.");
				Actions action = new Actions(driver);
				action.moveToElement(cell).doubleClick().build().perform();
				break;
			}
		}
	}

}