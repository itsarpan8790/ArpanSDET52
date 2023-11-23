package LearnTestNGExecution;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.bixi.genericutility.FileUtility;

public class BaseClass {
	public FileUtility fUtil = new FileUtility();
	public WebDriver driver; 
	
   @Parameters("GATEWAY")
	@BeforeClass(alwaysRun = true)
	public void openBrowser(String GATEWAY) throws Throwable {
		//String BROWSER=fUtil.readDataFromPropertyFile("browser");
		if(GATEWAY.equals("chrome"))
		driver = new ChromeDriver();
		else if (GATEWAY.equals("firefox"))
			driver = new FirefoxDriver();
		else
			System.out.println("---invalid browser---");
		driver.manage().window().maximize();

	}

	@BeforeMethod
	public void login() throws Throwable {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

	}

	@AfterMethod
	public void logout() throws Throwable {
		driver.findElement(By.xpath("(//tr/td[2]/img)[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();

	}

	@AfterClass(alwaysRun = true)
	public void CloseBrowser() {
		driver.quit();
	}
}
