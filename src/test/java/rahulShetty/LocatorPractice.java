package rahulShetty;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorPractice {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//a[text()='Forgot your password?']")).click();
		
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Rohan");
	   
	   driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
	  String value= driver.findElement(By.cssSelector("p.infoMsg")).getText();
	   
	  // Please use temporary password 'rahulshettyacademy' to Login.
	 String[] passwordArray = value.split("'");
	String[] passwordArray2= passwordArray[1].split("'");
	
	String password=passwordArray2[0];
	System.out.println(password);
	 // 0 index =Please use temporary password
	 // 1 index = rahulshettyacademy' to Login
	 
	 //0 index=rahulshettyacademy
	 //1 th index=to Login
		
		
		
		
	}

}
