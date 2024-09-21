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

public class ValidData {
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
    public void ValidData() throws InterruptedException {
        //Open amazon site
        driver.navigate().to("https://www.amazon.com/");
        //type "car accessories";
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("car accessory");
        //press search button
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(2000);
        //select first item
        driver.findElement(By.cssSelector(".a-size-base-plus.a-color-base.a-text-normal")).click();
        //Add item to the cart
        driver.findElement(By.id("add-to-cart-button")).click();
        Thread.sleep(2000);
        //Go to the cart and check that item is added successfully
        driver.findElement(By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS")).getText();
        String expectedText = "Added to Cart";
        String actualText = driver.findElement(By.cssSelector("h1[class=\"a-size-medium-plus a-color-base sw-atc-text a-text-bold\"]")).getText();
        Assert.assertEquals(actualText,expectedText);
    }
    
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
}
