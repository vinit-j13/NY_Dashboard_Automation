package baseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import invokeTest.InvokeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static String browser = "Chrome";
	public static String urlBap = "https://dashboard.integ.moving.tech/bap/";
	public static void main(String[] args)throws InterruptedException {
		
		if(browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}
		else if(browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browser.equals("Safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();	
		}
		
		driver.get(urlBap);
		System.out.println("Started....launching bap in browser");
		driver.manage().window().maximize();
		System.out.println("Running tests......");
		InvokeTest runTest = new InvokeTest();
		runTest.invokeFlowTests();
		driver.close();
		System.out.println("Tests Ended...");
		      
	}

}