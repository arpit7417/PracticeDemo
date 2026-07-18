package assignmentPractice;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkarImageCapture {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.flipkart.com/");
		
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		WebElement  electronic=driver.findElement(By.xpath("//span[text()='Electronics']"));
		action.moveToElement(electronic).perform();
		
		Thread.sleep(3000);
		WebElement camera=driver.findElement(By.xpath("//a[text()='Cameras & Accessories']"));
		action.moveToElement(camera).perform();
		
		driver.findElement(By.xpath("//a[text()='DSLR & Mirrorless']")).click();
		
		List<WebElement>  img=driver.findElements(By.xpath("//div[@data-id='DLLGKGWYBQWCRPAY']//img"));
		System.out.println(img.size());
		
		
	}

}
