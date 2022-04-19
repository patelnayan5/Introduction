package Selenium.Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionDemo {

	public static void main(String[] args) {

		//path to chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nayan\\Documents\\Study material\\Selenium\\driver\\newchromedriver\\chromedriver.exe");
		//invoke chrome driver
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		WebElement move = driver.findElement(By.cssSelector("#mousehover"));
		
		Actions a = new Actions(driver);
		
		a.moveToElement(driver.findElement(By.cssSelector("#autocomplete"))).click().keyDown(Keys.SHIFT).sendKeys("INDIA").doubleClick().build().perform();
		
		a.moveToElement(move).contextClick().build().perform();
		
		
		
		
	}

}
