package bppFlows;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import utils.BppHelper;

public class BppLogin extends BaseClass {

	@Test
	public void bppLoginFlow() throws InterruptedException, IOException {
		

		FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/config file/config.properties");
		
		Properties properties = new Properties();
		
		properties.load(fr);
		
		BppHelper bppHelper = new BppHelper();

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(properties.getProperty("urlBpp"));
		driver.manage().window().maximize();
		
		System.out.println("Starting bpp login...");
		
		bppHelper.bppLoginEmailPass(properties.getProperty("bppEmail"),properties.getProperty("bppPassword"));
		
		Thread.sleep(4000);

		WebElement ProfileLogo = driver.findElement(By.xpath("//div[@class='relative inline-block text-left']"));
		
		Assert.assertEquals(true, ProfileLogo.isDisplayed());

		System.out.println("User is Logged In Sucessfully");

	}

}
