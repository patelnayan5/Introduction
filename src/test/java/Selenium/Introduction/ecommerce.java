package Selenium.Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ecommerce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nayan\\Documents\\Study material\\Selenium\\driver\\newchromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.name("name")).sendKeys("Nayan");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Patel");
		driver.findElement(By.cssSelector("#exampleInputPassword1")).sendKeys("npatel");
		driver.findElement(By.cssSelector("#exampleCheck1")).click();
		driver.findElement(By.xpath("//select/option[2]"));
		
		
		
		
		
	}

}
