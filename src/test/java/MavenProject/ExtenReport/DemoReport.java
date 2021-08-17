package MavenProject.ExtenReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class DemoReport {
	
ExtentReports extent;

@BeforeTest
public void config()
{
	// Here need to create two objects "ExtentSparkReporter" and "ExtentReports"
	
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Results");
	reporter.config().setDocumentTitle("Test Results");
	
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Anuj");
}

	
@Test
public void BasicReport()
{
	ExtentTest test = extent.createTest("BasicReport");
	System.setProperty("WebDriver.Chrome.Driver", "C:\\Znujs\\TR\\Learning\\Selenium\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://rahulshettyacademy.com/");
	System.out.println(driver.getTitle());
	test.fail("This is failed");
	extent.flush();
}


}
