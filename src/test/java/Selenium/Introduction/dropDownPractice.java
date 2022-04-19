package Selenium.Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class dropDownPractice {

	public static <Select> void main(String[] args) {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nayan\\Documents\\Study material\\Selenium\\driver\\newchromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//select dropdown with select tag
		
		WebElement sdd = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select drop = new Select(sdd);
		
	}

}
