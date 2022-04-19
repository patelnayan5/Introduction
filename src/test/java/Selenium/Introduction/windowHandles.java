package Selenium.Introduction;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandles {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nayan\\Documents\\Study material\\Selenium\\driver\\newchromedriver\\chromedriver.exe");
		//invoke chrome driver
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Thread.sleep(5000);
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		//Thread.sleep(5000);
		//System.out.println(driver.findElement(By.cssSelector(".im-para red")).getText());
		System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText());
		driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
		System.out.println(driver.findElement(By.xpath("//p[@class='im-para'][1]")).getText());
		driver.findElement(By.xpath("//p[@class='im-para'][1]")).getText();
		String password = driver.findElement(By.xpath("//p[@class='im-para'][1]")).getText().split(" ")[3];
		
		String emailId = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
		
		driver.switchTo().window(parentId);
		driver.findElement(By.cssSelector("#username")).sendKeys(emailId);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);

		System.out.println(driver.findElement(By.xpath("//span[contains(text(),\"User\")]")).isSelected());
		driver.findElement(By.xpath("//span[contains(text(),\"User\")]")).click();
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),\"User\")]")).isSelected());
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#okayBtn")).click();
		
		System.out.println(driver.findElement(By.xpath("//select[@class='form-control']")).getText());
		driver.findElement(By.xpath("//option[@value='consult']")).click();
		System.out.println(driver.findElement(By.xpath("//select[@class='form-control']")).getText());
		
		driver.findElement(By.cssSelector("#terms")).click();
		
		driver.findElement(By.cssSelector("#signInBtn")).click();
		
		
		
	}

}
