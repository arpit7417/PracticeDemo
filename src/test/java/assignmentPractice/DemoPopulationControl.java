package assignmentPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoPopulationControl {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver =new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 
		 driver.get("https://www.worldometers.info/world-population/india-population/");
		 
		 List<WebElement> rows = driver.findElements(By.xpath("//h2[text()='Main Cities by Population in India']/ancestor::div[@class='prose max-w-none prose-table:text-sm/5 md:prose-table:text-base/6 text-sm/5 md:text-base/6 prose-headings:font-medium prose-headings:mt-10 prose-h1:text-4xl prose-h1:font-medium prose-h1:mb-8 prose-h2:text-3xl prose-h3:text-2xl prose-h4:text-xl prose-tr:border-0 prose-thead:border-0 prose-img:mb-0 prose-a:font-inherit prose-li:my-0.5 prose-h2:mb-1 mt-12!']//table/tbody/tr"));

				for(WebElement row : rows) {
				// System.out.println(row.getText());
					
				List<WebElement> value	=row.findElements(By.tagName("td"));
				
			/*	for(int i=1 ;i< value.size();i++) {
					
					System.out.print(value.get(i).getText() + " ");
				}
				System.out.println();
				
			*/
				
				 String[] data = new String[value.size()];

				    for (int i = 0; i < value.size(); i++) {
				        data[i] = value.get(i).getText();
				    }

				    

				    System.out.println(data[1] + " " + data[2]);
				}
					
					
				    
				    
				
			 
			  
			 
		 }
	}

