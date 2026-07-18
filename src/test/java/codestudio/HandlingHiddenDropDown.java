package codestudio;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingHiddenDropDown {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		// this will click the pim
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//label[contains(text(),'Sub Unit')]/following::div[@class='oxd-select-text-input'][1]")).click();
		
		 WebElement developmentOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
	              By.xpath("//div[@role='option']//span[text()='Development']")
	          ));
	          developmentOption.click();
		
		
		
	}

}
