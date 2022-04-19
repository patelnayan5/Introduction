package Selenium.Introduction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCertificate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FirefoxOptions options1 = new FirefoxOptions();
		options1.setAcceptInsecureCerts(true);
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nayan\\Documents\\Study material\\Selenium\\driver\\newchromedriver\\chromedriver.exe");
		
		//invoke chrome driver
		WebDriver driver = new ChromeDriver(options);
		//cast options to chromedriver
		
		//Get url, navigate to url, get current url, back to previous, forward to url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://expired.badssl.com/");
		driver.getTitle();
		driver.manage().window().maximize();
		

	}

}
