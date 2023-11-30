package LearnJenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchBrowserTest {
	WebDriver driver;

	@Test
	public void test() {
          
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println("--Performed---Done------");

	}

}
