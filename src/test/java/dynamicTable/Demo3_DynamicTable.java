package dynamicTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo3_DynamicTable {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		driver.get("https://practice.expandtesting.com/dynamic-table");
		
	List<WebElement>	rows=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		
		System.out.println("Number of rows"+ rows.size());
		
		for(int r=1;r<=rows.size();r++) {
		WebElement	name=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+r+"]//td[1]"));
			System.out.println(name.getText());
			////table[@class='table table-striped']/tbody/tr[4]//td[1]
			if(name.getText().equals("Chrome")) {
			String cpuload	=driver.findElement(By.xpath("//td[text()='Chrome']//following-sibling::*[contains(text(),'%')]")).getText();
			
			String value=driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();
			
			if(value.contains(cpuload)) {
				System.out.println("CPU Load of chrome is equal");
			}
			else {
				System.out.println("CPU LOad of chrome is not equal");
			}
			break;
			}
		}
		
	}
	
	

}
