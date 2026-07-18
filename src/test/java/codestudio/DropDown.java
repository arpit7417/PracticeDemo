package codestudio;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	WebElement element	=driver.findElement(By.id("country"));
		Select s1=new Select(element);
		
		s1.selectByIndex(2);
		//s1.selectByValue("australia");
		//s1.selectByVisibleText("Japan");
		
		List<WebElement> option=s1.getOptions();
		/*for(WebElement op: option) {
			System.out.println(op.getText());
		}
		*/
		for(int i=0;i<option.size();i++) {
			System.out.println(option.get(i).getText());
			
		}
		
		driver.quit();
		
		
	}

}
