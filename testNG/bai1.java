package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class bai1 {

	
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
    
   
    @BeforeMethod
    public void HomepageTitle() {
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    
    @Test(priority = 0)
    public void register() {
        driver.findElement(By.linkText("REGISTER")).click();
        expected = "Register: Mercury Tours";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
    }
    
    @Test(priority = 1)
    public void support() {
        driver.findElement(By.linkText("SUPPORT")).click();
        expected = "Under Construction: Mercury Tours";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
    }
    
    @AfterMethod
    public void goBackToHomepage() {
        driver.findElement(By.linkText("Home")).click();
    }
    
    @AfterTest
    public void terminatoBrowser() {
        driver.close();
    }
}
