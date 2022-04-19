package Selenium.Introduction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandles_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nayan\\Documents\\Study material\\Selenium\\driver\\newchromedriver\\chromedriver.exe");
		//invoke chrome driver
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//p[@class='text-center text-white']")).getText();
		String username = driver.findElement(By.xpath("//p[@class='text-center text-white']")).getText().split(" ")[2];
		String password = driver.findElement(By.xpath("//p[@class='text-center text-white']")).getText().split(" ")[6].replaceAll("[)]*", "");
		
		
		driver.findElement(By.cssSelector("#username")).sendKeys(username);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		//set up path to chrome driver
		
		//invoke the driver
		//maximize the webpage 
		//implicite wait 10 seconds

		//System.out.println(driver.findElement(By.xpath("//span[contains(text(),\"User\")]")).isSelected());
		driver.findElement(By.xpath("//span[contains(text(),\"User\")]")).click();
		//System.out.println(driver.findElement(By.xpath("//span[contains(text(),\"User\")]")).isSelected());
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#okayBtn")).click();
		
		System.out.println(driver.findElement(By.xpath("//select[@class='form-control']")).getText());
		driver.findElement(By.xpath("//option[@value='consult']")).click();
		System.out.println(driver.findElement(By.xpath("//select[@class='form-control']")).getText());
		
		driver.findElement(By.cssSelector("#terms")).click();
		
		driver.findElement(By.cssSelector("#signInBtn")).click();
		

	}

}
