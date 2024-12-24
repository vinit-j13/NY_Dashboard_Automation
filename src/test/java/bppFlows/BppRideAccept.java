package bppFlows;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import utils.BppHelper;


public class BppRideAccept extends BaseClass {

	@Test
	public void bppRideAccept() throws InterruptedException, IOException {
		
		FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/config file/config.properties");
		
		Properties properties = new Properties();
		
		properties.load(fr);

		BppHelper bppHelper = new BppHelper();

		bppHelper.searchDriverBynumber(properties.getProperty("driverPhone"));

		
		String vehicleNumber = copyVehicleNumber(); // Copy vehicle number

		bppHelper.clickBookingDetail();

		bppHelper.enterOtpAndSearch();

		bppHelper.searchVehicleButtonClick();

		bppHelper.startRideScreen(properties.getProperty("driverPhone"), vehicleNumber);

	}

	// copy vehicle number function
	public String copyVehicleNumber() {
		
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-label='Vehicle Number']/div[2]")));
		
		WebElement vehicleNumberElement = driver.findElement(By.xpath("//div[@data-label='Vehicle Number']/div[2]"));
		String vehicleNumber = vehicleNumberElement.getText();
		return vehicleNumber;
	}

}
