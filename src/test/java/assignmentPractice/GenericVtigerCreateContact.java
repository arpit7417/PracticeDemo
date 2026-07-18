package assignmentPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

import ddt.EXcelUtility;

public class GenericVtigerCreateContact {
	
	public static void main(String[] args) throws IOException {
		
		
		FileUtility fis=new FileUtility();
		EXcelUtility exc=new EXcelUtility();
		JavaUtility js=new JavaUtility();
		
		String BROWSER=fis.getDataFroamPropertiesFile("browser");
		String URL=fis.getDataFroamPropertiesFile("url");
		String USERNAME=fis.getDataFroamPropertiesFile("username");
		String PASSWORD=fis.getDataFroamPropertiesFile("password");
		
		
		
          WebDriver driver= null;
          if(BROWSER.equals("chrome")) {
        	  driver= new ChromeDriver();
          } else if (BROWSER.equals("firefox")) {
        	  driver=new FirefoxDriver();
          }else if(BROWSER.equals("edge")) {
        	  driver=new EdgeDriver();
          } else {
        	  driver=new ChromeDriver();
          }
		
		
		// READ DATA FROM EXCEL FILE
          String lastName =  exc.getDataFroamExcel("contact", 1, 2) +js.getRandomNumber();
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		
		Date dobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyy-MM-dd");
	     String startdate = sim.format(dobj);
	     
	     Calendar cal = sim.getCalendar();
	     cal.add(Calendar.DAY_OF_MONTH,30);
	     String enddate = sim.format(cal.getTime());
		
		
		
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startdate);
		
		driver.findElement(By.id("jscal_field_support_end_date")).clear();
		driver.findElement(By.id("jscal_field_support_end_date")).sendKeys(enddate);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		String actlastname = driver.findElement(By.id("mouseArea_Last Name")).getText();
		if(actlastname.contains(lastName)) {
			System.out.println(lastName+ " is mached");
		} else {
			System.out.println(lastName+ " is not matched");
		}
		 String actstartdate= driver.findElement(By.id("dtlview_Support Start Date")).getText();
		    if(actstartdate.contains(startdate)) {
		    	System.out.println(startdate + " is created===pass");
		    }else {
		    	System.out.println(startdate + " is not created ===fail");
		    }
		    
		    String actendtdate= driver.findElement(By.id("dtlview_Support End Date")).getText();
		    if(actendtdate.contains(enddate)) {
		    	System.out.println(enddate + " is created===pass");
		    }else {
		    	System.out.println(enddate + " is not created ===fail");
		    }
	}

}
