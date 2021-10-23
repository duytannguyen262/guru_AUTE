package testNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(testNG.ListenerTest.class)

public class bai2 {

	
	public static String baseUrl = "http://demo.guru99.com/test/newtours/";
    public static String driverPath = "C:\\geckodriver.exe";
    public static WebDriver driver; 
   
    public static String expected = null;
    public static String actual = null;
    
    @BeforeTest 
	public void beforeTest()
	{
    	System.out.println("Launching firefox browser");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
	}
    
    
    @Test(priority = 0)
    public void register() {
    	String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    	
    	driver.findElement(By.linkText("REGISTER")).click();
        expected = "Register: Mercury Tours";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
        
        List<WebElement> childElements = driver.findElements(By.xpath("//*[@style='font-family:Arial, Helvetica;font-size:13px;color:#000;padding:5px;']//input"));
        
        for(int i = 0; i<childElements.size();i++) {          
        	childElements.get(0).sendKeys("Duy");
            childElements.get(1).sendKeys("Tan");
            childElements.get(2).sendKeys("1234456789");
            childElements.get(3).sendKeys("duydz@gmail.com");

            childElements.get(4).sendKeys("123 Nguyen Tan Duy");
            childElements.get(5).sendKeys("TP HCM");
            childElements.get(6).sendKeys("Phuong 10");
            childElements.get(7).sendKeys("113457178347");

            childElements.get(8).sendKeys("duy262");
            childElements.get(9).sendKeys("123");
            childElements.get(10).sendKeys("123");
            break;
        }
        
        WebElement sort = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/select"));
        Select dropDown = new Select(sort);
        dropDown.selectByValue("VIETNAM");

        WebElement submit = driver.findElement(By.xpath("//*[@name='submit']"));
        submit.click();
        System.out.println("Registered!");
        
        
    }
    
    @Test(priority = 1)
    public void signin() {
    	WebElement signinBtn = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/a"));
        signinBtn.click();
        
        List<WebElement> signInElements = driver.findElements(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody//input"));
        for(int i = 0; i<signInElements.size();i++) {
        	signInElements.get(0).sendKeys("duy262");
        	signInElements.get(1).sendKeys("123");
        	break;
        }
        
        WebElement submit = driver.findElement(By.xpath("//*[@name='submit']"));
        submit.click();
        
        String expectedTitle = "Login: Mercury Tours";
        String actualTitle = driver.getTitle();
        if (actualTitle.contentEquals(expectedTitle)){
        	System.out.println("Signed in!");
		}
                
    }
    
    
    @AfterTest
    public void terminatoBrowser() {
        driver.close();
    }
}
