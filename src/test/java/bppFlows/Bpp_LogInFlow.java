package bppFlows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import bapFlows.RideSearch;
import baseClass.BaseClass;

public class Bpp_LogInFlow extends BaseClass {

		
	@Test
		public void bppLoginFlow() throws InterruptedException{
			
			driver.get(urlBpp);
			
			String email = "ajay.kumar@juspay.in";
			String password = "8340217370";
			
			System.out.println("Starting bap login...");
			Thread.sleep(2500);
			
			WebElement Email = driver.findElement(By.xpath("//input[@name='email']"));
			Email.sendKeys(email);
			
			Thread.sleep(3000);
			
			WebElement Password = driver.findElement(By.xpath("//input[@name='password']"));
			Password.sendKeys(password);
			
			WebElement LogInButton = driver.findElement(By.xpath("//div[@data-button-text='Securely Login']"));
			LogInButton.click();
			
			Thread.sleep(4000);
			
			WebElement ProfileLogo = driver.findElement(By.xpath("//div[@class='relative inline-block text-left']"));;
			Assert.assertEquals(true, ProfileLogo.isDisplayed());
			
			System.out.println("User is Logged In Sucessfully");

			
			Thread.sleep(3000);
			
			


	}

}
