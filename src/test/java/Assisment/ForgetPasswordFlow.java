package Assisment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgetPasswordFlow {
	
	WebDriver driver;
	
	@Test
	public void forgetPasswordTest() {
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		try {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://example.com");
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		
		driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
		
		driver.findElement(By.id("rest pass")).click();
		
		String  messgae=driver.findElement(By.id("succesmsg")).getText();
		Assert.assertTrue(messgae.contains("RestPass"));
		
		} catch(Exception e) {
			 System.out.println("Test FAiled");
		}
		finally
		{
			driver.quit();
		}
		
	}
	

}
