package testingProjectver2;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class testingClass5 {

    public static void main(String[] args) {

        String baseURL= "http://demo.guru99.com/test/web-table-element.php";

        //trigger browser
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        WebDriver driver= new FirefoxDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        //utilize the defined method
        getTotalRowNumber(driver);
        getTotalColumnNumber(driver);
        getRowNumberByValue("REC",driver);
        getTableCellValue(5,4,driver);    
    }

    //define method
    public static void getTotalRowNumber(WebDriver dr) {
    	List <WebElement> rows = dr.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
        System.out.println("Total Rows: " + rows.size());
    }

    public static void getTotalColumnNumber(WebDriver dr) {
        List<WebElement> columns = dr.findElements(By.xpath("/html/body/div/div[3]/div[1]/table/thead/tr/th"));
        System.out.println("Total Colums: " + columns.size());
    }
    
    public static void getRowNumberByValue(String value, WebDriver dr) {
    	List <WebElement> rows = dr.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
    	for (int i = 0; i < rows.size(); i++) {
    		if (rows.get(i).getText().equals(value)) {
            	System.out.println("Found item at row " + (i+1));
            }
    		System.err.println("Item " + value + " not found at row " + (i+1));
        }
    }
    
    public static void getTableCellValue(int row, int col ,WebDriver dr) {
    	WebElement SelectedRow = dr.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr" + "[" + row + "]"));
    	System.out.println("//*[@id='leftcontainer']/table/tbody/tr" + "[" + row + "]");
    	WebElement SelectedCol = SelectedRow.findElement(By.xpath("//td" +"[" + col + "]"));
    	System.out.println(SelectedCol.getText());
    }
}