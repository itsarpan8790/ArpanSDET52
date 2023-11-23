package com.practise_package;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {
	public static void main(String[] args) throws IOException {

		// Step 1. Launch The browser
		WebDriver driver = new ChromeDriver();

		// Step 2.Maximize the browser
		driver.manage().window().maximize();

		// enter url
		driver.get("http://localhost:8888/");

		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));

		ArrayList<String> al = new ArrayList<String>();

		for (int i = 0; i < allLinks.size(); i++) {
			String eachLinkText = allLinks.get(i).getAttribute("href");

			URL url = null;
			int statusCode = 0;
			try {
				url = new URL(eachLinkText);
				HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
				statusCode = urlConn.getResponseCode();
				if (statusCode >= 400) {
					al.add(eachLinkText);
					System.out.println(eachLinkText + " is broken link " + statusCode);

				}
			} catch (MalformedURLException e) {
				System.out.println(eachLinkText + " is broken link " + statusCode);
			}

		}

	}

}
