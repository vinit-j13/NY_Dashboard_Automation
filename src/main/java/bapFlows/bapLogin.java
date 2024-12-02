package bapFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;

public class BapLogin extends BaseClass {
	public void bapLoginFlow() throws InterruptedException{
		
	System.out.println("Starting bap login...");
	Thread.sleep(2500);
	
	WebElement Email = driver.findElement(By.name("email"));
	Email.sendKeys("vinit.jj@nammayatri.in");
	
	WebElement Password = driver.findElement(By.name("password"));
	Password.sendKeys("9370212345");
	
	WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div[1]/div[1]/div/div[1]/div/div/div/div[2]/form/div/div[3]/button[2]/div/div"));
	loginButton.click();
	
	System.out.println("Login succesfull!!");
		}
}
