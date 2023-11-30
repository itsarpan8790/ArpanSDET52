package LearnJenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicParameterJenkin {
	WebDriver driver;

	@Test
	public void test() {
		String BROWSER = System.getProperty("S_browser"); //S_browser=Script Browser
		String URL = System.getProperty("S_url");

		if (BROWSER.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else
			driver = new EdgeDriver();

		driver.get(URL);
		System.out.println("--Open In Jenkins------");
	}

}
