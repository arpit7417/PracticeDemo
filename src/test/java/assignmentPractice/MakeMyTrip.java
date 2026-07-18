package assignmentPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTrip {
	
	public static void main(String[] args) {
		
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.makemytrip.com/flights/?cmp=SEM|D|DF|B|Brand|Brand-BrandExact_DT|Brand_MMT_Makemytrip_Search_Exact|Brand_Exact|Sitelink|Flights|&s_kwcid=AL!1631!3!!e!!o!!makemytrip%5C%5C&ef_id=:G:s&msclkid=a5e7d61c9bda1e1b0908bfcf6f021ac8");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement departure = wait.until(
		    ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Departure']"))
		);

		departure.click();
	//	driver.findElement(By.xpath("//span[normalize-space()='Departure']")).click();
		
		String Date="6";
		  wait.until(ExpectedConditions.elementToBeClickable(
		            By.xpath("//p[text()='" + Date + "']")
		        )).click();
	}

}
