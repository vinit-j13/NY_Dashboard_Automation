package bppFlows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class BppLogin extends BaseClass {

		
		@Test
		public void bppLoginFlow() throws InterruptedException{
		
		
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(urlBpp);
			driver.manage().window().maximize();

			String email = "vinit.j@nammayatri.in";
			String password = "9370267592";
			
			System.out.println("Starting bpp login...");
			Thread.sleep(2500);
			
			WebElement Email = driver.findElement(By.xpath("//input[@name='email']"));
			Email.sendKeys(email);
			
			Thread.sleep(3000);
			
			WebElement Password = driver.findElement(By.xpath("//input[@name='password']"));
			Password.sendKeys(password);
			
			Thread.sleep(3000);
			
			WebElement LogInButton = driver.findElement(By.xpath("//div[@data-button-text='Securely Login']"));
			LogInButton.click();
			
			Thread.sleep(4000);
			
			WebElement ProfileLogo = driver.findElement(By.xpath("//div[@class='relative inline-block text-left']"));;
			Assert.assertEquals(true, ProfileLogo.isDisplayed());
			
			System.out.println("User is Logged In Sucessfully");


	}

}
