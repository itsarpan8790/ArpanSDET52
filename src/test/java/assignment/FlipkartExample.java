package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartExample {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		Actions a = new Actions(driver);

		// Removing Popup
		driver.findElement(By.xpath("//span[text()='✕']")).click();

		// Locating Searchbar and SendKeys
		WebElement searchBOx = driver.findElement(By.cssSelector("input[name='q']"));
		a.sendKeys(searchBOx, "iphone 14 pro max").click().sendKeys(Keys.ENTER).perform();

		// Locating All Products
		List<WebElement> allProduct = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		// Locating All Prices
		List<WebElement> allPrice = driver
				.findElements(By.xpath("//div[@class='_4rR01T']/../..//div[@class='_30jeq3 _1_WHN1']"));

		int priceCount = allPrice.size();
		System.out.println(priceCount);
		int productCount = allProduct.size();
		System.out.println(productCount);

		System.out.println("Products----------------------------------------------------Price");
		int printed = 0;
		for (int i = 0; i <= (priceCount - 1); i++) {
			WebElement product = allProduct.get(i);
			WebElement price = allPrice.get(i);

			System.out.println("Product " + (i + 1) + ":" + product.getText() + "-------------------------------->"
					+ price.getText());
			printed++;
		}
		System.out.println("printed products = " + printed);
		driver.quit();
	}

}
