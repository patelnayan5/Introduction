package Selenium.Introduction;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class SeleniumByJava {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Set Property
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nayan\\Documents\\Study material\\Selenium\\driver\\newchromedriver\\chromedriver.exe");
		
		//invoke chrome driver
		WebDriver driver = new ChromeDriver();
		
		//Get url, navigate to url, get current url, back to previous, forward to url
		driver.get("url");
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.navigate().to("http://google.com");
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//set implicite wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//sleep time set up by java
		Thread.sleep(5000);
		
		
		//JavaScriptExecutor - Scroll page down, scroll table up & down
			//scroll page down using javascriptexecutor
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			driver.manage().window().maximize();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			
			//scroll table up & down using dom script
				//go to consol type document, querySelector is css selector use for driver,5000 is coordinates 
			Thread.sleep(5000);
			js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
			
			// Parsing string and comparing with generated sum value- continue lecture 102
			List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
			
			int sum = 0;
			for(int i=0;i<values.size();i++)
			{
				System.out.println(Integer.parseInt(values.get(i).getText()));
				sum = sum + Integer.parseInt(values.get(i).getText()); 
				//Integer.parseInt change string value to integervalue
			}
			System.out.println(sum);//to get the total sum
			
			driver.findElement(By.cssSelector(".totalAmount")).getText();
			int total=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
			Assert.assertEquals(sum, total);
			
			
		//limiting WebDriver scope - section 93
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size()); //count of total weblink on webpage	
		WebElement footer = driver.findElement(By.id("gf-BIG")); //creating object of footersection from webpage
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		//how to open the weblink on tab without clicking manually one by one - section 93-Time 4 min
		WebElement column = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(column.findElements(By.tagName("a")).size());
		for(int i=1;i<column.findElements(By.tagName("a")).size();i++)
		{
			String clickonlinktab = Keys.chord(Keys.CONTROL,Keys.Enter);
			column.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
			Thread.sleep(5000); //set the delay
		}
		
			//Open weblink on seperate tab & get the title - section 94
				Set<String> abc = driver.getWindowHandles();
				Iterator<String> it = abc.iterator();
				
				while (it.hasNext())
				{
					driver.switchTo().window(it.next());
					System.out.println(driver.getTitle());
				}
		
		
		
		//windowHandles to get child & parent id of browser
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId); // switch to child id of browser
		driver.switchTo().window(parentId); // switch to parent id of browser
		
		//Action class for mouse, mouse hover, keyboard movement note: build().perform() at the end of the command
		WebElement move = driver.findElement(By.cssSelector("#mousehover"));
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("#autocomplete"))).click().keyDown(Keys.SHIFT).sendKeys("INDIA").doubleClick().build().perform();
		a.moveToElement(move).contextClick().build().perform();
		
		//Frame (iframe)
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
			//drag and drop
			Actions a = new Actions(driver);
			
			WebElement source = driver.findElement(By.cssSelector("#draggable"));
			WebElement target = driver.findElement(By.cssSelector("#droppable"));
		
			a.dragAndDrop(source, target).build().perform();
		
		
		//Alert
		Alert al = new Alert(); //just to get to the program
		driver.switchTo().alert();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.findElement(By.cssSelector("#confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		//Static Dropdown practice - use select class
		WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select select = new Select(staticdropdown);
		select.selectByIndex(3);
		System.out.println(select.getFirstSelectedOption().getText());
		select.selectByVisibleText("AED");
		System.out.println(select.getFirstSelectedOption().getText());
		
		//How to handle HTTP (SSL) certificate issue on automating browser
		SSLCertificate sslc = new SSLCertificate(); //just to get to the program
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			options.addExtensions(paths);
			Proxy proxy = new Proxy(); //object of proxy
			proxy.setHttpProxy("ipaddress:4444");//set http proxy
			options.setCapability("proxy", proxy);//set capability
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nayan\\Documents\\Study material\\Selenium\\driver\\newchromedriver\\chromedriver.exe");
			//invoke chrome driver
			WebDriver driver = new ChromeDriver(options);
			//cast options to chromedriver
			
			//ChromeOption - block pop on window 
			//referenace-https://chromedriver.chromium.org/capabilities
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("excludeSwitches",
						Arrays.asList("disable-popup-blocking"));
				
				
			//delete the cookies
				Miscelenious ms = new Miscelenious(); //get to the program
				driver.manage().deleteAllCookies();
				driver.get("https://www.google.com/");
				// To get the screenshot of whole page
				 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 FileUtils.copyFile(src, new File("C:\\Users\\Nayan\\screenshot.png"));
			
				 
			//How to find the broken link (Applied on multiple link)
				 BrokenLink bl = new BrokenLink();
					List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
					SoftAssert sa = new SoftAssert();
					
					for(WebElement link : links)
					{
					String url = link.getAttribute("href");
						
						HttpURLConnection comm = (HttpURLConnection)new URL(url).openConnection();
						
						comm.setRequestMethod("HEAD");
						comm.connect();
						int responseCode = comm.getResponseCode();
						System.out.println(responseCode);
						sa.assertTrue(responseCode<400, "The link with text "+link.getText()+" is broken with code "+responseCode);
					
						
					}
				 
		
	}

}
