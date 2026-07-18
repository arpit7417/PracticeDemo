package codestudio;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountHperLinks {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.calculator.net/");
		
		List<WebElement> linkelement=driver.findElements(By.tagName("a"));
		System.out.println(linkelement.size());
		
		for(WebElement el: linkelement) {
			System.out.println(el.getText());
		}
		
		Thread.sleep(3000);
		driver.close();
	}

}
