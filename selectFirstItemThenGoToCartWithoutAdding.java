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

public class selectFirstItemThenGoToCartWithoutAdding {
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
    public void selectFirstItemThenGoToCartWithoutAdding() throws InterruptedException {
        // Open amazon site
        driver.navigate().to("https://www.amazon.com/");
        // Type "car accessories"
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("car accessory");
        // Press search button
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(2000);
        // Select first item
        driver.findElement(By.cssSelector(".a-size-base-plus.a-color-base.a-text-normal")).click();
        // Go back to search results
        driver.navigate().back();
        // Go to the cart
        driver.findElement(By.id("nav-cart")).click();
        // Verify that the cart is empty
        Assert.assertTrue(driver.findElement(By.cssSelector(".a-row.sc-your-amazon-cart-is-empty")).isDisplayed());
    }
	
	@AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
