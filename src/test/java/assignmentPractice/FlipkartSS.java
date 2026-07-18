package assignmentPractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class FlipkartSS {
	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.flipkart.com/");
		
	/*	TakesScreenshot tsk=(TakesScreenshot)driver;
		File src = tsk.getScreenshotAs(OutputType.FILE);
		File dest= new File("E:\\eclipse java\\RevisionSelenium\\src\\test\\java\\assignmentPractice\\ss1.png");
		FileHandler.copy(src, dest);
		driver.quit();
		*/
		
		WebElement cart = driver.findElement(By.xpath("//a[text()='Cart']"));
		File scr = cart.getScreenshotAs(OutputType.FILE);
		File dst=new File("E:\\eclipse java\\RevisionSelenium\\src\\test\\java\\assignmentPractice\\ss.png");
		FileHandler.copy(scr, dst);
		driver.quit();
		
	}

}
