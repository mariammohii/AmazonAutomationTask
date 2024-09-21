package Task1_OpenAmazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class searchEmptyString {

	WebDriver driver;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver",
				"C:\\Driver\\chromedriver.exe");
    	driver = new ChromeDriver();
        //Set Browser resolution
        driver.manage().window().setSize(new Dimension(1024, 768));
        //Open amazon site
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(3000);
    }
    
    @Test
    public void SearchEmptyString() throws InterruptedException {
        //Open Amazon site
        driver.navigate().to("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(" ");
        //press search button
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(2000);
        //no results should be displayed
    }
    
	@AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
