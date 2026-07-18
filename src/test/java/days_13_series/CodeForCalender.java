package days_13_series;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CodeForCalender {
	
	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // Navigate to a sample calendar page
	        driver.get("https://jqueryui.com/datepicker/");
	        
	        // Switch to iframe (the datepicker is inside a frame on this site)
	        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
	        
	        // Open the calendar by clicking the input field
	        driver.findElement(By.id("datepicker")).click();
	        
	     // Target date
	        String targetYear = "2025";
	        String targetMonth = "December";
	        String targetDay = "15";
	        
	        
	        while(true) {
	        	
	        	 String currentMonth =driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
	             String currentYear = driver.findElement(By.className("ui-datepicker-year")).getText();
	             if(currentMonth.equalsIgnoreCase(targetMonth)&&currentYear.equalsIgnoreCase(targetYear)) {
	            	 break;
	            	 
	             }
	             else {
	            	// Click the "Next" button
	                 driver.findElement(By.xpath("//a[@data-handler='next']")).click();
	             }
	             // Select the desired day
	             driver.findElement(By.xpath("//a[text()='" + targetDay + "']")).click();

	             // Pause to visually confirm (optional)
	             Thread.sleep(2000);

	             // Close the browser
	             driver.quit();
	            	 
	             
	        }
	}

}
