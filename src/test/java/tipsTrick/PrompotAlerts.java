package tipsTrick;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrompotAlerts {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.xpath("//button[text()='Prompt Alert']")).click();
		Thread.sleep(3000);
/*	Alert myalert=	driver.switchTo().alert();
		myalert.sendKeys("Automation");
		System.out.println(myalert.getText());
		myalert.accept();
	*/
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		Alert alert=	mywait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.sendKeys("Selenium ");
		alert.accept();

	//	driver.quit();
		
	}

}
