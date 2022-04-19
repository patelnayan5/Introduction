package Selenium.Introduction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Set Property
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nayan\\Documents\\Study material\\Selenium\\driver\\newchromedriver\\chromedriver.exe");
		
		//invoke chrome driver
		WebDriver driver = new ChromeDriver();
		
		//Get url, navigate to url, get current url, back to previous, forward to url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		Actions a = new Actions(driver);
		
		WebElement source = driver.findElement(By.cssSelector("#draggable"));
		WebElement target = driver.findElement(By.cssSelector("#droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent(); //switch back to default content 
		*/
		
		
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.switchTo().frame(0);
		System.out.println(driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='content']")).getText()));
	}

}
