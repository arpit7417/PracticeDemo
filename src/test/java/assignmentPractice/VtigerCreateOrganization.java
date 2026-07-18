package assignmentPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VtigerCreateOrganization {
	
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
		Sheet sheet = wb.getSheet("org");
		Row row1 = sheet.getRow(1);
		String orgname = row1.getCell(2).toString()+getrandno;
		Row row4 = sheet.getRow(4);
		String industry=row4.getCell(3).toString();
		String type=row4.getCell(4).toString();
		Row row7 = sheet.getRow(7);
		String phone = row7.getCell(3).toString();
		wb.close();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		// create org page open
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		// select industry dropdown
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		WebElement ind=driver.findElement(By.name("industry"));
		Select sel=new Select(ind);
		sel.selectByVisibleText(industry);
		
		// select Type dropdown
		WebElement typ=driver.findElement(By.name("accounttype"));
		Select sel1= new Select(typ);
		sel1.selectByVisibleText(type);
		
		driver.findElement(By.id("phone")).sendKeys(phone);
		
		String shipadd="noida Sector16" + getrandno;
		
		driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys(shipadd);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		
		//vrification
		  
	    String headrinfo= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(headrinfo.contains(orgname)) {
	    	System.out.println(orgname + " is created===pass");
	    }else {
	    	System.out.println(orgname + " is not created ===fail");
	    }
	     // verify HEader orgName into Expected Result
	 String actOrgName  = driver.findElement(By.id("mouseArea_Organization Name")).getText();
	 if(actOrgName.contains(orgname)) {
	    	System.out.println(actOrgName + " is created===pass");
	    }else {
	    	System.out.println(actOrgName + " is not created ===fail");
	    }
	     
		
		String actindus = driver.findElement(By.id("mouseArea_Industry")).getText();
		if(actindus.contains(industry)) {
			System.out.println(industry +" it is created suc cessful");
		} else {
			System.out.println(industry + " is not created succssful");
		}
		
		
		String actphone = driver.findElement(By.id("mouseArea_Phone")).getText();
		if(actphone.contains(phone)) {
			System.out.println(phone + " is created");
		}
		else {
			System.out.println(phone + " is not created");
		}
		
		
	}

}
