package assignmentPractice;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonIphone {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[ contains(text(),'iPhone 17 Pro 1 TB: 15.93 cm (6.3″) Display with Promotion up to 120Hz, A19 Pro Chip, Breakthrough Battery Life, Pro Fusion Camera System with Center Stage Front Camera; Cosmic')]")).click();
		
		Set<String> windows = driver.getWindowHandles();
        for (String w : windows) {
            driver.switchTo().window(w);
        }

		WebElement radionbtn=driver.findElement(By.xpath("//i[@class='a-icon a-accordion-radio a-icon-radio-inactive']"));
		if(!radionbtn.isSelected()) {
			radionbtn.click();
		}
		
		driver.findElement(By.xpath("//input[@aria-labelledby='chooseButton-announce']")).click();
		
		WebElement dd=driver.findElement(By.xpath("//span[text()='Select Brand']"));
		//WebElement dd=driver.findElement(By.xpath("//a[text()='Oneplus']"));
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Select sel=new Select(dd);
		
		sel.selectByIndex(12);
		Thread.sleep(3000);
		driver.quit();
	}
	

}
