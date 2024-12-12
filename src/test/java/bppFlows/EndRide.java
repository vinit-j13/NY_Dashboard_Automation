package bppFlows;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class EndRide extends BaseClass {
	
	@Test
	public void endRideFlow() throws InterruptedException {
		String driverPhone = "9519519512";
		//ride management
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a/div/div[2]")).click();
		Thread.sleep(2000);
		//search by driver name
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[1]/div/div/div/form/div[2]/div/div[1]/div[1]/div[2]/input")).sendKeys(driverPhone);
		Thread.sleep(2000);
		//Ride Status button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[1]/div/div/div/form/div[2]/div/div[1]/div[2]/div[2]/div/div/div/button")).click();
		Thread.sleep(2000);
		//ongoing status click
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[1]/div/div/div/form/div[2]/div/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div")).click();
		Thread.sleep(1500);
		//select date
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[1]/div/div/div/form/div[2]/div/div[1]/div[5]/div[2]/div/button")).click();
		Thread.sleep(2000);
		//Select date
		datePicker();
		Thread.sleep(2000);
		//Apply button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[1]/div/div/div/form/div[2]/div/div[2]/button[2]")).click();
		Thread.sleep(3000);
		//click on entries
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[3]/div[2]/div/table/tbody/tr/td[5]/div/div/div/div/div/div")).click();
		Thread.sleep(3500);
		//end ride button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/button")).click();
		Thread.sleep(2000);
		//end popup button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[2]/div[2]/button/div/div")).click();
		Thread.sleep(2000);
		System.out.println("Ride ended succesfully..!");
	
	}
	
	@Test
	public void datePicker() throws InterruptedException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd"); //we specify format of date here.
		Date sysDate = new Date(); // create a date object with system's current date and time in it.
		
		String currentDate = dateFormat.format(sysDate); // format system's date to "dd"
		
		WebElement dateBody = driver.findElement(By.tagName("tbody"));
		List<WebElement> dateColumns = dateBody.findElements(By.tagName("td"));
		
		for(WebElement cell : dateColumns) {
			if(cell.getText().equals(currentDate)) {
				cell.click();
				cell.click();
				break;
			}
		}
	}

}
//By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[1]/div/div/div/form/div[2]/div/div[1]/div[5]/div[2]/div[2]/div/div/div[1]/div/div[2]/table")