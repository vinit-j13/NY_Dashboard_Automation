package bppFlows;
import org.openqa.selenium.By;

import baseClass.BaseClass;

public class BppLogin extends BaseClass {
	public static String urlBpp = "https://dashboard.integ.moving.tech/bpp/";
	public void bppLogin() throws InterruptedException {
		
		driver.navigate().to(urlBpp);
		System.out.println("BPP dashboard launched successfully..!");
		Thread.sleep(3000);
		//email
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[1]/div[2]/input")).sendKeys("vinit.j@nammayatri.in");
		Thread.sleep(1000);
		//password
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[2]/div[2]/input")).sendKeys("9370267592");
		Thread.sleep(1000);
		//securely login button
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div/div/div/div[2]/form/div[1]/div/div/div[4]/button[2]")).click();
		Thread.sleep(1000);
	
	}

}
