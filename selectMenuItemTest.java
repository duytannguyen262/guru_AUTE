package TH_2_10_Team2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit; 
import org.junit.After; 
import org.junit.Before; 
import org.junit.Test; 
import org.openqa.selenium.By; 
import org.openqa.selenium.Keys;  
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.interactions.Actions; 

public class selectMenuItemTest {
	
	private WebDriver driver; 
	private String baseUrl; 
	
	@Before
    public void setUp() throws Exception {
        // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		driver = new FirefoxDriver();
		     
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        baseUrl = "http://demo.guru99.com/test/guru99home/";
    }
    
    @Test 
    public void test() throws Exception { 
    	driver.get(baseUrl);
        
        WebElement listElement = driver.findElement(By.xpath("//div[@class='menu-block']"));
        List <WebElement> childElements = listElement.findElements(By.xpath("//*[@class='item118 parent']"));
        for (int i=0; i< childElements.size(); i++) {
            if (childElements.get(i).getText().equals("Testing")) {
            	childElements.get(i).click();
            	System.out.println("PASSED");
            	break;
            }
            
        }
    }
    
    @After 
    public void tearDown() throws Exception { 
    	// Close the Firefox browser 
    	//driver.close(); 
    	System.out.println("Closing the driver"); 
    } 
}

