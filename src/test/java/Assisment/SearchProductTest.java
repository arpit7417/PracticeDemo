package Assisment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest {
	
	WebDriver driver;
	@Test
	public void searchProductTest() {
		
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(17));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		WebElement  search=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		search.sendKeys("laptop");
		
		driver.findElement(By.id("searchBtn")).click();
		
		String title=driver.findElement(By.xpath("//")).getText();
		
		Assert.assertTrue(title.contains("Laptop"));
		
		driver.quit();
		 
		
		
		
	}
	

}
