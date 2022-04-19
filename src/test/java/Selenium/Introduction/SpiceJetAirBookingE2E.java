package Selenium.Introduction;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpiceJetAirBookingE2E {

	public static void main(String[] args) throws InterruptedException {

		
		//path to chrome driver
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nayan\\Documents\\Study material\\Selenium\\driver\\newchromedriver\\chromedriver.exe");
				//invoke chrome driver
				WebDriver driver = new ChromeDriver();
				
				//navigate to URL
				driver.get("https://www.spicejet.com/");
				
				Thread.sleep(9000);

				Alert alert = driver.switchTo().alert(); // switch to alert

				String alertMessage= driver.switchTo().alert().getText(); // capture alert message

				System.out.println(alertMessage); // Print Alert Message
				Thread.sleep(5000);
				alert.accept();
				
				//Select departure
				
				
				driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-xb2eav r-majxgm r-q4m81j']")).click();
				
				driver.findElement(By.cssSelector("input[type='text']")).sendKeys("ahm");
				Thread.sleep(5000);
				
				driver.findElement(By.className("css-76zvg2 r-12rm3iy r-ubezar")).click();
				
				System.out.println(driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-xb2eav r-majxgm r-q4m81j']")).getText());
	}

}
