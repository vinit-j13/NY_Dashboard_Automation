package baseClass;
import org.openqa.selenium.chrome.ChromeDriver;

import invokeTest.invokeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static ChromeDriver driver;
	protected static String urlBpp = "https://dashboard.integ.moving.tech/bap/";
	public static void main(String[] args) {
		
		try {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get(urlBpp);
		driver.manage().window().maximize();
		
		invokeTest runTest = new invokeTest();
		runTest.invokeFlowTests();
		
		driver.close();
		}catch(Exception e) {
			 System.out.println("An error occurred: " + e.getMessage());
	          e.printStackTrace();
		}
	}

}