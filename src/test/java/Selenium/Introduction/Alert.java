package Selenium.Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

	public static void main(String[] args) throws InterruptedException {

		
		//path to chrome driver
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nayan\\Documents\\Study material\\Selenium\\driver\\newchromedriver\\chromedriver.exe");
				//invoke chrome driver
				WebDriver driver = new ChromeDriver();
				
				//navigate to URL
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				
				String text = "Nayan";
				
				Thread.sleep(5000);
				driver.findElement(By.xpath("//input[@id='name']")).sendKeys(text);
				driver.findElement(By.cssSelector("#alertbtn")).click();
				
				Thread.sleep(5000);
				driver.switchTo().alert();
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
				driver.findElement(By.cssSelector("#confirmbtn")).click();
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().dismiss();
				
	}

}
