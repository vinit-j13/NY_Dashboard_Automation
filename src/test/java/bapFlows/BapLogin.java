package bapFlows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class BapLogin extends BaseClass {
	
	@Test
	public void bapLoginFlow() throws InterruptedException{
		
		
		System.out.println("Started....launching bap in browser");
		driver.get(urlBap);
		driver.manage().window().maximize();
		System.out.println("Running tests......");	
		
	String email = "vinit.jj@nammayatri.in";
	String password = "9370212345";
	
	System.out.println("Starting bap login...");
	Thread.sleep(2500);
	
	WebElement Email = driver.findElement(By.name("email"));
	Email.sendKeys(email);
	
	WebElement Password = driver.findElement(By.name("password"));
	Password.sendKeys(password);
	
	Thread.sleep(3000);
	
	WebElement loginButton = driver.findElement(By.xpath("//div[@data-button-text='Submit']"));
	loginButton.click();
	
	Thread.sleep(3000);
	
	System.out.println("Login succesfull!!");
		}
}
