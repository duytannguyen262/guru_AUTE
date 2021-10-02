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

public class FindElementWithXpathAxesTest {
	
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
    	
    	//CÂU 2
    	List <WebElement> dateBox = driver.findElements(By.xpath("//h2[contains(text(),'A few of our most popular courses')]"
    			+ "/parent::div//div[//a[text()='SELENIUM']]/following-sibling::div[@class='rt-grid-2 rt-omega']"));
    	for (WebElement webElement : dateBox) {
            System.out.println(webElement.getText());
        }
    	
    	//CÂU 3
    	
    	//contains
    	List <WebElement> contain = driver.findElements(By.xpath("//font[contains(text(),'THIS IS A DEMO PAGE FOR TESTING')]"));
    	for (WebElement containExercise : contain) {
            System.out.println(containExercise.getText());
        }
    	
    	//preceding
    	WebElement preceding = driver.findElement(By.xpath("//*[@type='submit']//preceding::input"));
    	System.out.println(preceding.getText());
    	
    	//following
    	WebElement following = driver.findElement(By.xpath("//*[contains(text(),'Check out our newest courses')]//following::a[text()=\"SAP MM\"]"));
    	System.out.println(following.getText());
    	
    	//descendant
    	System.out.println("Descendant:");
    	List <WebElement> descendant = driver.findElements(By.xpath("//*[@id='rt-feature']//descendant::a[2]"));
    	for (WebElement descendantElement : descendant) {
            System.out.println(descendantElement.getText());
        }
    	
    	//following-sibling
    	WebElement followingSibling = driver.findElement(By.xpath("//*[contains(text(),'Check out our newest courses')]//following-sibling::div[1]"));
    	System.out.println(followingSibling.getText());
    }
    
    @After 
    public void tearDown() throws Exception { 
    	// Close the Firefox browser 
    	driver.close(); 
    	System.out.println("Closing the driver"); 
    } 
}

