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

public class invalid_addToCartWithoutItem {
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
    public void invalid_addToCartWithoutItem() throws InterruptedException {
    	driver.navigate().to("https://www.amazon.com/");
    	// Go to the cart directly without adding any item
    	driver.findElement(By.id("nav-cart-count")).click();
    	Thread.sleep(2000);
    	// Check if the cart is empty
    	String expectedText = "Your Amazon Cart is empty";
    	String actualText = driver.findElement(By.cssSelector("div[class='a-row sc-your-amazon-cart-is-empty']")).getText();
    	Assert.assertEquals(actualText, expectedText);
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
