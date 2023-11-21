package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricbuzzEx {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.cricbuzz.com/");
		driver.findElement(By.xpath("//div[@id='match_menu_container']//li[1]")).click();
		String score1 = driver
				.findElement(By.xpath(
						"//div[@ng-show='isMiniscoreRendered']//div[@class='cb-col-100 cb-col cb-col-scores']//h2"))
				.getText();
		System.out.println(score1);
		String score2 = null;
		try {
			score2 = driver.findElement(By.xpath(
					"//div[@ng-show='isMiniscoreRendered']//div[@class='cb-col-100 cb-col cb-col-scores']//div[@class='cb-text-inprogress']"))
					.getText();
			System.out.println(score2);
		} catch (Exception e) {

		}
	}

}
