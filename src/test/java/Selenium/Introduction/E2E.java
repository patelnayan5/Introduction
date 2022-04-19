package Selenium.Introduction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class E2E {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nayan\\Documents\\Study material\\Selenium\\driver\\newchromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.manage().window().maximize();
		
		String password = getPassword(driver);
		
		
		
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("nayan");
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//System.out.println(driver.findElement(By.xpath("//form/p")).getText());
		
		//Assert.assertEquals((driver.findElement(By.xpath("//form/p")).getText()), "* Incorrect username or password");
		
		//System.out.println(driver.findElement(By.cssSelector("p")).getText());
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
	//	Assert.assertEquals((driver.findElement(By.xpath("//p")).getText()), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector(".login-container h2")).getText(),"Hello nayan,");
		
		Thread.sleep(10000);
		
		driver.findElement(By.cssSelector(".logout-btn"));
		Thread.sleep(5000);
		System.out.println("Test has been completed");
		
		//driver.close();
		
		
		
		
	}
	

	
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		System.out.println(driver.findElement(By.xpath("//form/p")).getText());
		//Please use temporary password 'rahulshettyacademy' to Login.
		
		String passwordText = driver.findElement(By.xpath("//form/p")).getText();
		String[] passwordArray = passwordText.split("'");
		String password = passwordArray[1].split("'")[0];
		return password;
		
	}
	
}


