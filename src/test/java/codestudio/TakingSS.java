package codestudio;

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

public class TakingSS {
	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.youtube.com/watch?v=lRKogU8Yfw4&list=PLUDwpEzHYYLtQzEEEldbjPAR-gnStv4sR&index=11");
		/*TakesScreenshot tsk=(TakesScreenshot)driver;
		File s1=tsk.getScreenshotAs(OutputType.FILE);
		File d1=new File("E:\\eclipse java\\RevisionSelenium\\src\\test\\java\\codestudio\\screen.png");
		FileHandler.copy(s1, d1);
		driver.quit();
		*/
		WebElement topicss=driver.findElement(By.xpath("//span[text()='See what others said about this video while it was live.']"));
		File s1=topicss.getScreenshotAs(OutputType.FILE);
		File d1= new File("E:\\eclipse java\\RevisionSelenium\\src\\test\\java\\codestudio\\topicss.png");
		FileHandler.copy(s1, d1);
		driver.quit();

		
		
	}

}
