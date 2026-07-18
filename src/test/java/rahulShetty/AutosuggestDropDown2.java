package rahulShetty;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestDropDown2 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("sel");
		Thread.sleep(3000);
		
		List<WebElement> options=driver.findElements(By.xpath("//div[@class='erkvQe']//li"));
		
		System.out.println("Options found: " + options.size());
		for(WebElement option: options) {
		
			if(option.getText().equalsIgnoreCase("Selenium")) {
				System.out.println(option.getText());
				option.click();
				
				break;
			}
		}
		
	}

}
