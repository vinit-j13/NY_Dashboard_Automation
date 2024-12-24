package bapFlows;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;
import baseClass.BaseClass;
import utils.BapHelper;

public class BapLogin extends BaseClass {

	@Test
	public void bapLoginFlow() throws InterruptedException, IOException {
		

		FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/config file/config.properties");
		
		Properties properties = new Properties();
		
		properties.load(fr);
		
		BapHelper bapHelper = new BapHelper();
		
		System.out.println("Started....launching bap in browser");
		
		driver.get(properties.getProperty("urlBap"));
		driver.manage().window().maximize();
		
		System.out.println("Running tests......");
		
		System.out.println("Starting bap login...");
		
		bapHelper.bapLoginEmailPass(properties.getProperty("bapEmail") , properties.getProperty("bapPassword"));

		Thread.sleep(3000);

		System.out.println("Login succesfull!!");
	}
}
