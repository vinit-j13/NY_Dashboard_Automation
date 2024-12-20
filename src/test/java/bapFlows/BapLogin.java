package bapFlows;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import utils.BapHelper;

public class BapLogin extends BaseClass {

	@Test
	public void bapLoginFlow() throws InterruptedException {

		BapHelper bapHelper = new BapHelper();
		
		System.out.println("Started....launching bap in browser");
		
		driver.get(urlBap);
		driver.manage().window().maximize();
		
		System.out.println("Running tests......");
		
		System.out.println("Starting bap login...");
		
		bapHelper.bapLoginEmailPass();

		Thread.sleep(3000);

		System.out.println("Login succesfull!!");
	}
}
