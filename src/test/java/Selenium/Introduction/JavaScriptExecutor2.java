package Selenium.Introduction;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nayan\\Documents\\Study material\\Selenium\\driver\\newchromedriver\\chromedriver.exe");
		
		//invoke chrome driver
		WebDriver driver = new ChromeDriver();
		
		//Get url, navigate to url, get current url, back to previous, forward to url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000);
		
		List<WebElement> values = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
		int sum = 0;
		for(int i=0;i<values.size();i++)
		{
			System.out.println(Integer.parseInt(values.get(i).getText()));
			sum =sum +Integer.parseInt(values.get(i).getText());
		}
		System.out.println(sum);
		
	}

}
