package DemoTestNg;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class Demo {
	
	WebDriver driver;
	
  @Test(priority=1)
 
  public void websiteopen() {
	
	  driver = new ChromeDriver();
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver-win64\\chromedriver.exe");
	  driver.manage().window().maximize();
	  driver.get("https://demoqa.com/login");
	
  }
  
  
  @Test(priority=2)
  public void login()
  {
	  
		String title = driver.getTitle();
		System.out.println("The page title is : " +title);
	    WebElement uName = driver.findElement(By.xpath("//*[@id='userName']"));
		WebElement pswd = driver.findElement(By.xpath("//*[@id='password']"));
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='login']"));
		
		uName.sendKeys("testuser");
		pswd.sendKeys("Password@123");
		 
//		Actions actions = new Actions(driver);
//		actions.moveToElement(loginBtn).perform();
	
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 1000);");
		try {
				Thread.sleep(3000);
				loginBtn.click();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
  }
  
    
  @Test(priority=3)
  public void logout()
  {
	  driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		try {
			
		
			WebElement logoutBtn = driver.findElement(By.xpath("//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']"));
						
			if(logoutBtn.isDisplayed())
			{
			
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0, 500);");
				Thread.sleep(1000);
				logoutBtn.click();
				System.out.println("LogOut Successful!");
			}
		} 
		catch (Exception e) {
			System.out.println("Incorrect login....");
		}
		driver.quit();	
	}
  
  
  
  
  
}