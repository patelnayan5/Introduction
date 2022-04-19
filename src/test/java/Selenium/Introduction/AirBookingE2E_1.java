package Selenium.Introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class AirBookingE2E_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//path to chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nayan\\Documents\\Study material\\Selenium\\driver\\newchromedriver\\chromedriver.exe");
		//invoke chrome driver
		WebDriver driver = new ChromeDriver();
		
		//navigate to URL
		driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
		
		//maximize the broswer
		driver.manage().window().maximize();
		
		//add sleep time
		Thread.sleep(5000);
		
		//autosuggestive dropdown - select country 
		driver.findElement(By.id("autosuggest")).sendKeys("ind");

		Thread.sleep(5000);
		List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item"));
		
		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
		}
		
		Thread.sleep(5000);
		
		
		//Select the oneway radio & validating calender arrival date
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			System.out.println("its enabled");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		Thread.sleep(5000);
		//locate the departure city
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1")).sendKeys("Ben");
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1")).getText());
		Thread.sleep(5000);
		//locate the arrival city
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1")).sendKeys("Che");
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1")).getText());
		
		
		//Calender located & select current departure date
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		
		//located the radio button - SeniorCitizenDiscount
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//count radio button 
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		//System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).get;
		
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		Thread.sleep(5000);
		
		
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(5000);
		
		//To select 5 adult use while loop
		int i =1;
		while(i<5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Thread.sleep(5000);
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click(); //click on search
		
	}

}
