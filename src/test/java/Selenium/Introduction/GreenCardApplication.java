package Selenium.Introduction;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenCardApplication {

	private static final TimeUnit SECONDS = null;

	public static void main(String[] args) throws InterruptedException {

		//path to chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nayan\\Documents\\Study material\\Selenium\\driver\\newchromedriver\\chromedriver.exe");
		//invoke chrome driver
		WebDriver driver = new ChromeDriver();
		String[] itemNeeded = {"Cucumber","Brocolli","Beetroot","Almonds"};

		
		//navigate to URL
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		driver.manage().window().maximize();
		int j=0; // variable to count the loop
		
		//imlicite wait for 10 seconds 
		//adj - apply globally , 
		//disadj - 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
				//driver.findElements(By.cssSelector("h4.product-name"));
				
		
		
		for(int i = 0;i<products.size();i++)
		{
			String[] name = products.get(i).getText().split("-");
			
			String formattedName=name[0].trim();
			
			List<String> itemNeededList = Arrays.asList(itemNeeded);
		
			//List<String> itemsNeededList = Arrays.asList(itemNeeded);
			if(itemNeededList.contains(formattedName))
			//if(itemsNeededList.contains(formattedName))
			{
				j++; //increment the loop
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); //do not write xpath with text
				
				if(j == itemNeeded.length) //loop break when it matches to itemneeded count
				break;
			}
		} 
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		//driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
		Thread.sleep(5000);
		
		//Click on Proceed to checkout
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		//entering the promo code
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		//click Apply to apply the promo code
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//Capture the text to verify promocode applied
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		//click on Place an order
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		
		//Choose county
		//driver.findElement(By.xpath("//div[@style='width: 360px; margin: 10px auto;']/select")).click();
	driver.findElement(By.xpath("//option[@value='India']")).click();
	System.out.println(driver.findElement(By.xpath("//option[@value='India']")).getText());
	
	//check radio button agree to Terms & condition
	driver.findElement(By.cssSelector(".chkAgree")).click();
	System.out.println(driver.findElement(By.cssSelector(".chkAgree")).isSelected());
	
	//Click on proceed
	driver.findElement(By.xpath("//button[contains(text(),\"Proceed\")]")).click();
	
	
	
		
		
	}

}
