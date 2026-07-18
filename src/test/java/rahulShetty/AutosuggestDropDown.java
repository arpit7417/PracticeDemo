package rahulShetty;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestDropDown {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("IND");
		Thread.sleep(3000);
		
		List<WebElement> options=driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		
		System.out.println("Options found: " + options.size());
		for(WebElement option: options) {
		
			if(option.getText().equalsIgnoreCase("India")) {
				System.out.println(option.getText());
				option.click();
				
				break;
			}
		}
		
	}

}
