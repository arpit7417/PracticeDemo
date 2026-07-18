package assignmentPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VtigerCreateContactWithOrzanition {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new  FileInputStream("E:\\eclipse java\\SeleniumCRMGUIFramework\\src\\test\\java\\practicedatadriventesting\\commandata.properties");
		Properties poj=new Properties();
		poj.load(fis);
		String BROWSER=poj.getProperty("browser");
		String URL=poj.getProperty("url");
		String USERNAME=poj.getProperty("username");
		String PASSWORD=poj.getProperty("password");
		
		Random randno=new Random();
		int getrandno = randno.nextInt(1000);
		
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
		FileInputStream fis1=new FileInputStream("E:\\data\\genericPractice1.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("contact");
		Row row1 = sheet.getRow(7);
		String orgname = row1.getCell(2).toString()+getrandno;
		String lastName = row1.getCell(3).toString()+getrandno;
		
		wb.close();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		 // 
		
		// create orzanization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		// select industry dropdown
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		
		String shipadd="noida Sector16" + getrandno;
		
		
	driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys(shipadd);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		// verification
		String actorg = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actorg.equals(orgname)) {
			System.out.println(orgname+ "is matched");
		}else {
			System.out.println(orgname+ " is not matched");
		}
		
		String actshipadd = driver.findElement(By.id("dtlview_Shipping Address")).getText();
		if(actshipadd.equals(shipadd)) {
			System.out.println(shipadd+ " is matched");
		} else {
			System.out.println(shipadd+ " is not matched");
		}
		
		
		// create contact with organization
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		
	//	driver.findElement(By.xpath("//input[@name='account_name']/../img")).click();
		// switch to child window
		String parentID = driver.getWindowHandle();

		driver.findElement(By.xpath("//input[@name='account_name']/../img")).click();
		
		Set<String> allIDs = driver.getWindowHandles();

		for(String id : allIDs) {
		    if(!id.equals(parentID)) {
		        driver.switchTo().window(id);
		        break;
		    }
		}
		 driver.findElement(By.name("search_text")).sendKeys(orgname);
		 driver.findElement(By.name("search")).click();
		 driver.findElement(By.xpath(" //a[text()='"+orgname+"']")).click();
		 
		 // switch to parent window
		 driver.switchTo().window(parentID);


		
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
