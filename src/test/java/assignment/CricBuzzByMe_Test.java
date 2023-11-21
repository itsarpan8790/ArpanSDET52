package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricBuzzByMe_Test {
	public static void main(String[] args) {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cricbuzz.com/");
		
		//driver.findElement(By.xpath("//ul[@class='cb-col cb-col-100 videos-carousal-wrapper cb-mtch-crd-rt-itm']/li[1]")).click();
		driver.findElement(By.xpath("//div[@id='match_menu_container']//li[1]")).click();


		String score=driver.findElement(By.xpath("//div[@class='cb-col-100 cb-col cb-col-scores']/descendant::h2[@class='cb-font-20 text-bold inline-block ng-binding']")).getText();
		
		
		String Batter1=driver.findElement(By.xpath("(//div[text()='Batter']/ancestor::div[@class='cb-col cb-col-100 cb-mini-col cb-bg-white cb-min-lv ng-scope']//a[@class='cb-text-link ng-binding'])[1]")).getText();
		String Batter1Run=driver.findElement(By.xpath("(//div[text()='Batter']/ancestor::div[@class='cb-col cb-col-100 cb-mini-col cb-bg-white cb-min-lv ng-scope']//a[@class='cb-text-link ng-binding'])[1]/../../div[2]")).getText();
		String Batter1Ball=driver.findElement(By.xpath("(//div[text()='Batter']/ancestor::div[@class='cb-col cb-col-100 cb-mini-col cb-bg-white cb-min-lv ng-scope']//a[@class='cb-text-link ng-binding'])[1]/../../div[3]")).getText();
		String Batter14s=driver.findElement(By.xpath("(//div[text()='Batter']/ancestor::div[@class='cb-col cb-col-100 cb-mini-col cb-bg-white cb-min-lv ng-scope']//a[@class='cb-text-link ng-binding'])[1]/../../div[4]")).getText();
		String Batter16s=driver.findElement(By.xpath("(//div[text()='Batter']/ancestor::div[@class='cb-col cb-col-100 cb-mini-col cb-bg-white cb-min-lv ng-scope']//a[@class='cb-text-link ng-binding'])[1]/../../div[5]")).getText();
		String Batter1SR=driver.findElement(By.xpath("(//div[text()='Batter']/ancestor::div[@class='cb-col cb-col-100 cb-mini-col cb-bg-white cb-min-lv ng-scope']//a[@class='cb-text-link ng-binding'])[1]/../../div[6]")).getText();
		
		String Batter2=driver.findElement(By.xpath("(//div[text()='Batter']/ancestor::div[@class='cb-col cb-col-100 cb-mini-col cb-bg-white cb-min-lv ng-scope']//a[@class='cb-text-link ng-binding'])[2]")).getText();
		String Batter2Run=driver.findElement(By.xpath("(//div[text()='Batter']/ancestor::div[@class='cb-col cb-col-100 cb-mini-col cb-bg-white cb-min-lv ng-scope']//a[@class='cb-text-link ng-binding'])[2]/../../div[2]")).getText();
		String Batter2Ball=driver.findElement(By.xpath("(//div[text()='Batter']/ancestor::div[@class='cb-col cb-col-100 cb-mini-col cb-bg-white cb-min-lv ng-scope']//a[@class='cb-text-link ng-binding'])[2]/../../div[3]")).getText();
		String Batter24s=driver.findElement(By.xpath("(//div[text()='Batter']/ancestor::div[@class='cb-col cb-col-100 cb-mini-col cb-bg-white cb-min-lv ng-scope']//a[@class='cb-text-link ng-binding'])[2]/../../div[4]")).getText();
		String Batter26s=driver.findElement(By.xpath("(//div[text()='Batter']/ancestor::div[@class='cb-col cb-col-100 cb-mini-col cb-bg-white cb-min-lv ng-scope']//a[@class='cb-text-link ng-binding'])[2]/../../div[5]")).getText();
		String Batter2SR=driver.findElement(By.xpath("(//div[text()='Batter']/ancestor::div[@class='cb-col cb-col-100 cb-mini-col cb-bg-white cb-min-lv ng-scope']//a[@class='cb-text-link ng-binding'])[2]/../../div[6]")).getText();
		
		System.out.println("Live Score: "+score);
		System.out.println(Batter1+" "+Batter1Run+" "+Batter1Ball+" "+Batter14s+" "+Batter16s+" "+Batter1SR);
		
		System.out.println(Batter2+" "+Batter2Run+" "+Batter2Ball+" "+Batter24s+" "+Batter26s+" "+Batter2SR);
		
	
	
	
	
	
	
	}
	
	
	

}
