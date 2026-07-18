package assignmentPractice;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("apple iphone 16");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		// driver.findElement(By.xpath("//h2[@aria-label='Sponsored Ad - iPhone 17 Pro Max 2 TB: 17.42 cm (6.9″) Display with Promotion, A19 Pro Chip, Best Battery Life in Any iPhone Ever, Pro Fusion Camera System, Center Stage Front Camera; Deep Blue']")).click();
		
		String mainpage=driver.getWindowHandle();
		driver.findElement(By.xpath("//h2[@aria-label='Sponsored Ad - iPhone 17 Pro Max 2 TB: 17.42 cm (6.9″) Display with Promotion, A19 Pro Chip, Best Battery Life in Any iPhone Ever, Pro Fusion Camera System, Center Stage Front Camera; Deep Blue']")).click();
	//	driver.findElement(By.xpath("//h2[contains(@aria-label,'Sponsored Ad - iPhone 17 Pro Max 2')]")).click();
		driver.findElement(By.xpath("//h2[contains(@aria-label,'Sponsored Ad - iPhone 16 128 GB: 5G Mobile Phone with Camera Control, A18 Chip and a Big Boost in Battery Life. Works with AirPods; Black')]")).click();
		Set<String> allpages=driver.getWindowHandles();
		for(String page:allpages) {
			if(!page.equals(mainpage)) {
				driver.switchTo().window(page);
				break;
			}
		}
		
		System.out.println(driver.getCurrentUrl());
		
		List<WebElement> details=driver.findElements(By.cssSelector("ul[class='a-unordered-list a-vertical a-spacing-mini']"));
		System.out.println(details.size());
		
		for(WebElement list:details) {
			System.out.println(list.getText());
		}
		//driver.close();
		
		
		
	}

}
