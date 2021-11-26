package com.vfs.global.appointment;

import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindAppointment {

	public static void main(String[] args) throws InterruptedException, URISyntaxException {
		boolean blue = false;
		boolean emp = false;

		String shit = "No appointment slots are currently available";
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C://Ashutosh//Selenium//ChromeDriver96//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://visa.vfsglobal.com/ind/en/deu/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='jane.doe@email.com']")).sendKeys("");
		driver.findElement(By.xpath("//input[@placeholder='**********']")).sendKeys("");	
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@aria-label='Close'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();	
		Thread.sleep(8000);
		driver.findElement(By.xpath("(//span[contains(text(),' Start New Booking ')]/parent::button)[2]")).click();
		Thread.sleep(3000);
		WebElement webElement = driver.findElement(By.xpath("//mat-select/div/div"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Germany Visa Application Centre, New Delhi')]")).click();


		for(int i=0;i<270;i++) {
			System.out.println(i);
			Thread.sleep(12*5000*2);
			WebElement webElement1 = driver.findElement(By.xpath("(//mat-select/div/div)[3]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement1);
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//span[contains(text(),'D-Visa Stamping')]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Blue Card and its Dependents')]")).click();
			Thread.sleep(8000);
			//WebElement webElement2 = driver.findElement(By.xpath("(//mat-select/div/div)[5]"));
			//((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement2);
			//Thread.sleep(1000);
			//	driver.findElement(By.xpath("//span[contains(text(),'Blue Card with dependents')]")).click();
			String text = driver.findElement(By.xpath("//form/div[4]/div")).getText();

			if(text.contains(shit)) {
				//System.out.println(Example.getTwilioUnavilable());
				//System.out.println("shit man no Blue card slots! check for Employment visa now.");

				WebElement webElement4 = driver.findElement(By.xpath("(//mat-select/div/div)[3]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement4);
				Thread.sleep(8000);
				driver.findElement(By.xpath("//span[contains(text(),'Employment and dependents')]")).click();
				Thread.sleep(8000);
				String text1 = driver.findElement(By.xpath("//form/div[4]/div")).getText();
				if(text1.contains(shit)) {
					//System.out.println(Example.getTwilioUnavilable());
					//System.out.println("shit man! Go back to Blue card."+java.time.LocalDateTime.now());

				}
				else {
					System.out.println(Example.getTwilioAvailable());
					MakePhoneCall.makePhoneCall();
					System.out.println("Hurray!! Employment visa's slots are open At "+java.time.LocalDateTime.now());

				}
			}
			else {
				System.out.println(Example.getTwilioAvailable());
				MakePhoneCall.makePhoneCall();
				System.out.println("Hurray!! Blue card slots are open At "+java.time.LocalDateTime.now());
			}
		}






	}

}
