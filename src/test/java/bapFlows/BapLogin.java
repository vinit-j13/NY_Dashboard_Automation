package bapFlows;
import java.io.IOException;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import utils.BapHelper;

public class BapLogin extends BaseClass {

	@Test
	public void bapLoginFlow() throws InterruptedException, IOException {
		
		BapHelper bapHelper = new BapHelper();
		
		System.out.println("Started....launching bap in browser");
		
		System.out.println("Running tests......");
		
		System.out.println("Starting bap login...");
		
		bapHelper.bapLoginEmailPass();

		Thread.sleep(3000);

		System.out.println("Login succesfull!!");
	}
}