package bppFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import utils.BppHelper;

public class BppLogin extends BaseClass {

	@Test
	public void bppLoginFlow() throws InterruptedException {
		
		BppHelper bppHelper = new BppHelper();

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(urlBpp);
		driver.manage().window().maximize();
		
		System.out.println("Starting bpp login...");
		
		bppHelper.bppLoginEmailPass();
		
		Thread.sleep(4000);

		WebElement ProfileLogo = driver.findElement(By.xpath("//div[@class='relative inline-block text-left']"));
		;
		Assert.assertEquals(true, ProfileLogo.isDisplayed());

		System.out.println("User is Logged In Sucessfully");

	}

}
