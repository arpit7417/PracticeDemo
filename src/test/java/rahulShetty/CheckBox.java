package rahulShetty;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBox {
	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		
		List<WebElement>  list=driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		System.out.println(list.size());
		List<WebElement> list1 = driver.findElements(
		        By.xpath("//input[@type='checkbox']/following-sibling::label"));

		System.out.println("Total Labels: " + list1.size());

		for (WebElement l1 : list1) {
		    System.out.println(l1.getText());
		}
			
			
			
			
			// Assisment 
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			driver.manage().window().maximize();
		//	Assert.assertFalse(	driver.findElement(By.xpath("//label[@for='bmw' ]/input[@id='checkBoxOption1']")).isSelected());
			driver.findElement(By.xpath("//label[@for='bmw' ]/input[@id='checkBoxOption1']")).click();
			Assert.assertTrue(	driver.findElement(By.xpath("//label[@for='bmw' ]/input[@id='checkBoxOption1']")).isSelected());
			driver.quit();
		}
	
	}


