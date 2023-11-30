package LearnJenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Parameters({ "Browser", "Url" })
public class JenkinWithParameterAnnotationTest {
	WebDriver driver;

	@Test
	public void test(String BROWSER, String URL) {

		if (BROWSER.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else
			driver = new EdgeDriver();

		driver.get(URL);
		System.out.println("--Browser Opened In Jenkins------");
		System.out.println("--Url Opened In Jenkins------");
	}
}
