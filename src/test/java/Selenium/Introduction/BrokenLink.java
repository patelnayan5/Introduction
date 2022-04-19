package Selenium.Introduction;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nayan\\Documents\\Study material\\Selenium\\driver\\newchromedriver\\chromedriver.exe");
		
		//invoke chrome driver
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://rahulshettyacademy.com/AutomationPractice/");
		
		
	List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
	SoftAssert sa = new SoftAssert(); //soft assertion 
	
	for(WebElement link : links)
	{
	String url = link.getAttribute("href");
		
		HttpURLConnection comm = (HttpURLConnection)new URL(url).openConnection();
		
		comm.setRequestMethod("HEAD");
		comm.connect();
		int responseCode = comm.getResponseCode();
		System.out.println(responseCode);
		sa.assertTrue(responseCode<400, "The link with text "+link.getText()+" is broken with code "+responseCode);
		
		
	}
	
	
	}

}
