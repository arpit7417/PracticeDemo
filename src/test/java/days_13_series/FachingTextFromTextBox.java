package days_13_series;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FachingTextFromTextBox {
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		
	WebElement	name=driver.findElement(By.id("userName"));
	name.sendKeys("Arpit kumar singh");
	
	String text=name.getAttribute("value");
	System.out.println(text);
	
	}

}
