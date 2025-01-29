package utils;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;

public class NishedhHelper extends BaseClass {
	
	final Properties properties;
	
	public NishedhHelper() throws IOException {
		FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/config file/config.properties");
		
		properties = new Properties();
		
		properties.load(fr);
	}
	
	public void merchantMakerLoginFlow() {
		driver.get(properties.getProperty("NishedhUrl"));
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		WebElement Email = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Email']")));
		Email.sendKeys(properties.getProperty("merchantMakerLoginEmail"));
		
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys(properties.getProperty("merchantMakerLoginPassword"));
		
		WebElement LoginButton = driver.findElement(By.xpath("//button[@aria-label='login']"));
		LoginButton.click();
	} 
	public void merchantMakerReport() {
		 
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
	       JavascriptExecutor js = (JavascriptExecutor) driver;

	       // Wait until the Report Agent button is present in the DOM
	       WebElement reportAgent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()=' Report Agent']")));

	       // Scroll directly to the Report Agent button
	       js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", reportAgent);

	       // Adding a slight delay to ensure complete visibility
	       try {
	           Thread.sleep(1000); // Wait for 1 second to ensure visibility before clicking
	       } catch (InterruptedException e) {
	           e.printStackTrace();
	       }

	       // Wait until the button is clickable and then click it
	       wait.until(ExpectedConditions.elementToBeClickable(reportAgent)).click(); 
	       

			WebElement ManualEntry = driver.findElement(By.xpath("//div[text()='Individual']"));
			ManualEntry.click();
	       
			WebElement  DrivingLicense = driver.findElement(By.xpath("//input[@placeholder='Enter Driving License']"));
			DrivingLicense.click();
			DrivingLicense.sendKeys(properties.getProperty("DL"));
			
			WebElement AgentName = driver.findElement(By.xpath("//input[@placeholder='Enter Agent Name']"));
			AgentName.click();
			AgentName.sendKeys(properties.getProperty("AgentName"));
			
			WebElement ClickOnFlaggedCategory = driver.findElement(By.xpath("//button[@aria-label='selectCategory']"));
			ClickOnFlaggedCategory.click();
			
			WebElement SelectAbuse = driver.findElement(By.xpath("//div[@data-dropdown-value='abuse']"));
			SelectAbuse.click();
			
			WebElement VoterID = driver.findElement(By.xpath("//input[@placeholder='Enter Voter ID']"));
			VoterID.click();
			VoterID.sendKeys(properties.getProperty("VoterID"));
			
			WebElement ContactNumber = driver.findElement(By.xpath("//input[@placeholder='Enter 10 digit mobile number']"));
			ContactNumber.click();
			ContactNumber.sendKeys(properties.getProperty("ContactNumber"));
			
			WebElement FlaggingReason = driver.findElement(By.xpath("//textarea[@placeholder='Enter exact reason of flagging']"));
			FlaggingReason.click();
			FlaggingReason.sendKeys(properties.getProperty("FlaggingReason"));
			
			WebElement ReportAgentButton = driver.findElement(By.xpath("//div[@data-button-text='Report Agent']"));
			ReportAgentButton.click();
	   } 
	public void merchantMakerBulkReport() {
	       
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	       JavascriptExecutor js = (JavascriptExecutor) driver;

	       // Wait until the Report Agent button is present in the DOM
	       WebElement reportAgent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()=' Report Agent']")));
	       js.executeScript("arguments[0].scrollIntoView({block: 'center'});", reportAgent);
	       
	       // Ensure visibility before clicking
	       try {
	           Thread.sleep(1000); 
	       } catch (InterruptedException e) {
	           e.printStackTrace();
	       }
	       wait.until(ExpectedConditions.elementToBeClickable(reportAgent)).click();  
	       
	       // Click on Bulk Entry
	       WebElement BulkEntry = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-icon='upload_icon_safety']")));
	       BulkEntry.click();
	       
	       // Locate the actual <input type='file'> element
	       WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
	       
	       // Use Paths to dynamically fetch the absolute path
	       String filePath = Paths.get(System.getProperty("user.home"), "Desktop", "NishedhSheett.csv").toString();
	       
	       // Send the file path directly to the file input
	       fileInput.sendKeys(filePath);

	       // Click the Report Agent Button after upload
	       WebElement ReportAgentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-button-text='Report Agent']")));
	       ReportAgentButton.click();
	   }
	public void merchantMakerProfileFlow() throws InterruptedException {  
		  
	   	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
	   	WebElement Profile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-icon='person_profile_icon']")));
	   	Profile.click();
	   	
	      WebElement ClickOnFlagList = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Flag List']")));
	      ClickOnFlagList.click();
	   	
	      WebElement SearchDL = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search']")));
	      SearchDL.click();
	      SearchDL.sendKeys(properties.getProperty("SearchDL"));
	      
	      WebElement DatePicker = driver.findElement(By.xpath("//div[@data-button-text='Select Date Range']"));
	  	 DatePicker.click();
	  	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-date-picker-section='date-picker-calendar']")));
	  	Thread.sleep(2000); // Wait for the date picker to load

	  	// Ensure the month (December, 2024) is selected
	  	while (true) {
	  		WebElement calendarDateElement = driver.findElement(By.xpath("//div[@ data-calendar-date='January, 2025']"));
	  		String calendarDate = calendarDateElement.getText();

	  		if (calendarDate.equals("January, 2025")) {
	  			System.out.println("Expected month selected which is: " + calendarDate);
	  			break;
	  		} else {
	  			WebElement chevronLeft = driver.findElement(By.xpath("//div[@data-icon='chevron-left']"));
	  			chevronLeft.click();
	  			 Thread.sleep(1000);
	  		}
	  	}

	  	// Select the start date (December 1)
	  	WebElement startDateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='01']")));
	  	startDateElement.click();

	  	 Thread.sleep(2500); // Small delay for interaction

	  	// Select the end date (till 22nd Dec)
	  	WebElement endDateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='07']")));
	  	endDateElement.click();
	  	 Thread.sleep(2500);

	  	WebElement ApplyButton= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-button-text='Apply']")));
	  	ApplyButton.click();
	  	  
	  
	  	SearchDL.sendKeys(Keys.RETURN); 
	  	
	  	WebElement Profile1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-icon='person_profile_icon']")));
		Profile1.click(); 
		
		WebElement AuditTrail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Audit Trail']")));
		 AuditTrail.click(); 
		 
		 WebElement SearchDL1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search']")));
	    SearchDL1.click();
	    SearchDL1.sendKeys(properties.getProperty("SearchDL1"));
	    SearchDL1.sendKeys(Keys.RETURN); 
	}
	public void merchantMakerLogout() throws InterruptedException {  
	   	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	   	WebElement Profile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-icon='person_profile_icon']")));
	   	Profile.click();
	   	WebElement Logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Logout']")));
	   	Logout.click();
   }
	public void merchantAdminLoginFlow() {
		driver.get(properties.getProperty("NishedhUrl"));
		driver.manage().window().maximize();
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
	       wait.pollingEvery(Duration.ofMillis(500));
	       
	       try {
	           WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Email']")));
	           emailField.sendKeys(properties.getProperty("merchantAdminLoginEmail"));
	           
	           WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Password']")));
	           passwordField.sendKeys(properties.getProperty("merchantAdminLoginPassword"));
	           
	           WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='login']")));
	           loginButton.click();     
	           
	           System.out.println("Login successful");
	       } catch (Exception e) {
	           System.err.println("Error during login: " + e.getMessage());
	       }
	   }
	public void merchantAdminTakeActionApprove() {
		   
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		 WebElement notificationsButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-icon='notifications']")));
		 notificationsButton.click();

		  WebElement TakeAction = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Take Action']")));
	        TakeAction.click();   

	        WebElement SelectCheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-selected-checkbox='NotSelected']")));
	        SelectCheckBox.click();  
	      
	        WebElement ApproveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Approve']")));
	        ApproveButton.click();   
	      
	        WebElement ApproveYes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Yes']")));
	        ApproveYes.click();   
	}
	public void merchantAdminTakeActionReject() {
		   
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		 WebElement notificationsButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-icon='notifications']")));
		 notificationsButton.click();

		  WebElement TakeAction = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Take Action']")));
	        TakeAction.click();   

	        WebElement SelectCheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-selected-checkbox='NotSelected']")));
	        SelectCheckBox.click();  
	      
	        WebElement RejectButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Reject']")));
	        RejectButton.click();   
	      
	        WebElement ApproveYes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Yes']")));
	        ApproveYes.click();   
	}
   public void merchantAdminLogout() throws InterruptedException {  
	   	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	   	WebElement Profile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-icon='person_profile_icon']")));
	   	Profile.click();
	   	WebElement Logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Logout']")));
	   	Logout.click();
}   
   
   
  public void policeAdminLogin() {
		 
	  driver.get(properties.getProperty("NishedhUrl"));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
		WebElement Email = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Email']")));
		Email.sendKeys(properties.getProperty("policeAdminLoginEmail"));
		
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys(properties.getProperty("policeAdminLoginpasswordField"));
		
		WebElement LoginButton = driver.findElement(By.xpath("//button[@aria-label='login']"));
		LoginButton.click();
	} 
 
 public void PoliceAdminTakeActionApprove() {
	 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		 WebElement notificationsButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-icon='notifications']")));
		 notificationsButton.click();

		  WebElement TakeAction = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Take Action']")));
	        TakeAction.click();   

	        WebElement SelectCheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-selected-checkbox='NotSelected']")));
	        SelectCheckBox.click();   
	      
	        WebElement ConfirmedButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-button-text='Confirmed']")));
	        ConfirmedButton.click();   
	      
	        WebElement ApproveYes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Yes']")));
	        ApproveYes.click();   
	}  
 
 public void PoliceAdminTakeActionReject() {
	 
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	 WebElement notificationsButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-icon='notifications']")));
	 notificationsButton.click();

	  WebElement TakeAction = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Take Action']")));
        TakeAction.click();   

        WebElement SelectCheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-selected-checkbox='NotSelected']")));
        SelectCheckBox.click();   
      
        WebElement NotConfirmedButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-button-text='Not Confirmed']")));
        NotConfirmedButton.click();   
      
        WebElement ApproveYes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Yes']")));
        ApproveYes.click();     
}
 public void PoliceAdminLogout() throws InterruptedException {  
	   	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
	   	WebElement Profile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-icon='person_profile_icon']")));
	   	Profile.click();
	   	WebElement Logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Logout']")));
	   	Logout.click();
}
 public void merchantAdminReport() {
	 
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
     JavascriptExecutor js = (JavascriptExecutor) driver;

     // Wait until the Report Agent button is present in the DOM
     WebElement reportAgent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()=' Report Agent']")));

     // Scroll directly to the Report Agent button
     js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", reportAgent);

     // Adding a slight delay to ensure complete visibility
     try {
         Thread.sleep(1000); // Wait for 1 second to ensure visibility before clicking
     } catch (InterruptedException e) {
         e.printStackTrace();
     }

     // Wait until the button is clickable and then click it
     wait.until(ExpectedConditions.elementToBeClickable(reportAgent)).click(); 
     

		WebElement ManualEntry = driver.findElement(By.xpath("//div[text()='Individual']"));
		ManualEntry.click();
     
		WebElement  DrivingLicense = driver.findElement(By.xpath("//input[@placeholder='Enter Driving License']"));
		DrivingLicense.click();
		DrivingLicense.sendKeys(properties.getProperty("DL"));
		
		WebElement AgentName = driver.findElement(By.xpath("//input[@placeholder='Enter Agent Name']"));
		AgentName.click();
		AgentName.sendKeys(properties.getProperty("AgentName"));
		
		WebElement ClickOnFlaggedCategory = driver.findElement(By.xpath("//button[@aria-label='selectCategory']"));
		ClickOnFlaggedCategory.click();
		
		WebElement SelectAbuse = driver.findElement(By.xpath("//div[@data-dropdown-value='abuse']"));
		SelectAbuse.click();
		
		WebElement VoterID = driver.findElement(By.xpath("//input[@placeholder='Enter Voter ID']"));
		VoterID.click();
		VoterID.sendKeys(properties.getProperty("VoterID"));
		
		WebElement ContactNumber = driver.findElement(By.xpath("//input[@placeholder='Enter 10 digit mobile number']"));
		ContactNumber.click();
		ContactNumber.sendKeys(properties.getProperty("ContactNumber"));
		
		WebElement FlaggingReason = driver.findElement(By.xpath("//textarea[@placeholder='Enter exact reason of flagging']"));
		FlaggingReason.click();
		FlaggingReason.sendKeys(properties.getProperty("FlaggingReason"));
		
		WebElement ReportAgentButton = driver.findElement(By.xpath("//div[@data-button-text='Report Agent']"));
		ReportAgentButton.click(); 
		
		WebElement YesApproveButton= driver.findElement(By.xpath("//div[@data-button-text='Yes, Approve']"));
		YesApproveButton.click(); 
		
 }  
/* public void merchantAdminBulkReport() {
     
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
     JavascriptExecutor js = (JavascriptExecutor) driver;

     // Wait until the Report Agent button is present in the DOM
     WebElement reportAgent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()=' Report Agent']")));
     js.executeScript("arguments[0].scrollIntoView({block: 'center'});", reportAgent);
     
     // Ensure visibility before clicking
     try {
         Thread.sleep(1000); 
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
     wait.until(ExpectedConditions.elementToBeClickable(reportAgent)).click();  
     
     // Click on Bulk Entry
     WebElement BulkEntry = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-icon='upload_icon_safety']")));
     BulkEntry.click();
     
     // Locate the actual <input type='file'> element
     WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
     
     // Use Paths to dynamically fetch the absolute path
     String filePath = Paths.get(System.getProperty("user.home"), "Desktop", "NishedhSheett.csv").toString();
     
     // Send the file path directly to the file input
     fileInput.sendKeys(filePath);

     // Click the Report Agent Button after upload
     WebElement ReportAgentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-button-text='Report Agent']")));
     ReportAgentButton.click();
 }  
 */
 public void merchantAdminBulkReport() throws TimeoutException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    try {
	        // Wait for the 'Report Agent' button to be visible and interactable
	        WebElement reportAgent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()=' Report Agent']")));
	        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", reportAgent);
	        wait.until(ExpectedConditions.elementToBeClickable(reportAgent)).click();
	        System.out.println("'Report Agent' button clicked.");

	        // Wait for the 'Bulk Entry' icon to be present and clickable
	        WebElement BulkEntry = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-icon='upload_icon_safety']")));
	        BulkEntry.click();
	        System.out.println("'Bulk Entry' icon clicked.");

	        // Wait for the file input element to be present
	        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
	        String filePath = Paths.get(System.getProperty("user.home"), "Desktop", "NishedhSheett.csv").toString();
	        fileInput.sendKeys(filePath);
	        System.out.println("File path set: " + filePath);

	        // Wait for the 'Report Agent' button after the file upload and click it
	        WebElement ReportAgentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-button-text='Report Agent']")));
	        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ReportAgentButton);
	        wait.until(ExpectedConditions.elementToBeClickable(ReportAgentButton)).click();
	        System.out.println("'Report Agent' button clicked after file upload.");

	    } catch (Exception e) {
	        System.err.println("An error occurred during the execution of merchantAdminBulkReport.");
	        e.printStackTrace();
	    }
	}

}
