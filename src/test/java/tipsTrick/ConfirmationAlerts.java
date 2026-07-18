package tipsTrick;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationAlerts {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.xpath("//button[text()='Confirmation Alert']")).click();
		
		Thread.sleep(3000);
	/*	Alert alert=driver.switchTo().alert();
		//alert.accept();
		alert.dismiss();
		*/
		//2
		
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		Alert alert=	mywait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.accept();
		
	}

}
