package rahulShetty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {
	
	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement dropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select sel=new Select(dropdown);
		
	//	sel.selectByIndex(1);
		sel.selectByValue("AED");
		sel.selectByVisibleText(" USD");
		//System.out.println(sel.getFirstSelectedOption().getText());
		System.out.println(sel.getAllSelectedOptions());
	}

}
