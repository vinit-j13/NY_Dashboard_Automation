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
		
		switch(browser) {
		case "Chrome":
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
			break;
		}
		case "Firefox": 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		case "Edge":
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}
		case "Safari" :
		{
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		}
		default:
		{
			System.out.println("No Browser selected!");
			break;
		}
		
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