package assignmentPractice;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartSearch {
	
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.flipkart.com/");
		
		WebElement  searchbox=driver.findElement(By.name("q"));
		searchbox.sendKeys("samsungs24fe");
		searchbox.submit();
		
		String mainpage=driver.getWindowHandle();
		driver.findElement(By.xpath("//div[text()='Samsung Galaxy S24 FE 5G (Graphite, 256 GB)']")).click();
		
		Set<String>  allpages=driver.getWindowHandles();
		System.out.println(allpages.size());
		
		for(String page:allpages) {
			if(!page.equals(mainpage)) {
			   driver.switchTo().window(page);
			   break;
				
			}
		}
		System.out.println(driver.getCurrentUrl());
		
		List<WebElement> details=driver.findElements(By.xpath("//div[@class='xFVion']"));
		System.out.println(details.size());
		for(WebElement detail:details) {
			System.out.println(detail.getText());
		}
		/*WebElement pincode=driver.findElement(By.id("pincodeInputId"));
		pincode.sendKeys("246761");
		pincode.submit();
		*/
		driver.findElement(By.cssSelector("button[class='QqFHMw vslbG+ In9uk2']")).click();
		
		driver.findElement(By.xpath("//button[text()='Enter Delivery Pincode']")).click();
		WebElement pincode =driver.findElement(By.xpath("//input[@placeholder='Enter pincode']"));
		pincode.sendKeys("201301");
		driver.findElement(By.xpath("//div[text()='Submit']")).click();
		
	}

}
