package assignmentPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Crickbuzz {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.cricbuzz.com/");
		
		driver.findElement(By.xpath("//a[text()='Rankings']")).click();
		
		driver.findElement(By.xpath("//div[text()='ODI']")).click();
		
		driver.findElement(By.xpath("//a[text()='Batting']")).click();
		
		String playerName="Harry Brook";
		 
		
		
	}

}
