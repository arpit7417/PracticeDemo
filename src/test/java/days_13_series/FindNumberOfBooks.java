package days_13_series;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class FindNumberOfBooks {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		driver.get("https://www.booksbykilo.in/new-books");
		
		/*
		 * it give only the books which is displayed on the screen it can not scroll the pages
		List<WebElement>  books=driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
		System.out.println("Number of books "+books.size());
		*/
		/*
		 * it also not give all the books its only scroll only one step
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		List<WebElement>  books=driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
		System.out.println("Number of books "+books.size());
		
		*/
		JavascriptExecutor js= (JavascriptExecutor)driver;
		Actions act=new Actions(driver);
		// Logic
		int previouscount=0;
		int currentcount=0;
		
		while(true) {
			List<WebElement>  books=driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
			currentcount=books.size();
			
			if(currentcount==previouscount) {
				break;
			}
			
			previouscount=currentcount;
			//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			act.sendKeys(Keys.END).perform();
			Thread.sleep(1000);
			
		}
			System.out.println("Total number of books :"+currentcount);
			driver.quit();
			
		}
		
	}


