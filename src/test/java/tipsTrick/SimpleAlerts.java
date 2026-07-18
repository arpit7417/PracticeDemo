package tipsTrick;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleAlerts {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver() ;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
		
		 Thread.sleep(3000);
		 //1
	//	Alert alert=driver.switchTo().alert();
	//	alert.accept();
		//2 by Explicit wait
		/* WebDriverWait  mywait=new WebDriverWait(driver,Duration.ofSeconds(15));
		 
		Alert alert= mywait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
		*/
		 // 3 javaScript executor
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 try {
			 
		 
		 js.executeScript("window.alert=function{};");
		 }catch(Exception e) {
			 
		 }
	}

}
