package day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListtener implements ITestListener{

	 public void onStart(ITestContext context) {
		    System.out.println("Test execution is started......"); // execute only one time
		  }
	 
	public void onTestStart(ITestResult result) {
		System.out.println("Test started.......");
	    
	  }
	
	 public void onTestSuccess(ITestResult result) {
		    System.out.println("Test Passed");
		  }
	 
	 
	 public void onTestFailure(ITestResult result) {
		    System.out.println("Test Failure");
		  }
	 
	 
	 public void onTestSkipped(ITestResult result) {
		  System.out.println("Test Skipped");
		  }
	 
	 
	 
	  public void onFinish(ITestContext context) {
		    System.out.println("Test  execution is completed ");
		  }
	 

}
