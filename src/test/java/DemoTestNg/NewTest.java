package DemoTestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class NewTest {
    WebDriver driver;
    JavascriptExecutor js;
  
    @Test(priority=1)
    public void websiteopen() {
       
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver-win64\\chromedriver.exe");
  
        driver = new ChromeDriver();
               
        driver.manage().window().maximize();
               
        driver.get("https://www.amazon.com");
       
       
    }

   
    @Test(priority=2)
    public void searchbox() {
 
    	System.out.println("Page title is: " + driver.getTitle());
//    	String acttitle = driver.getTitle();
//        Assert.assertEquals(acttitle, "Amazon.com. Spend less. Smile more.", "Price is not correct");
    	WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        
    	searchBox.sendKeys("remote car");
      
        searchBox.sendKeys(Keys.ENTER);
        
    }

 
    @Test(priority=3)

    	public void clickImage() throws InterruptedException {
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
        js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000);");
    	
    	 WebElement imageElement = driver.findElement(By.xpath("//img[contains(@class, 's-image')]"));
    	 
     	 imageElement.click();
     	 Thread.sleep(2000);
     	 js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0, 2000);");
     	driver.quit();	
    }
   // @Test(priority=4)

//	public void addtocart() 
//	{
//    	
//    	try {
//    	     
//    		  WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\'add-to-cart-button\']"));
//			loginBtn.click();
//			Thread.sleep(5000);
//			
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		}
//    	
//   		
//    }
	}
