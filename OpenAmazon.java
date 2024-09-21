package Task1_OpenAmazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OpenAmazon {
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
    
    @Test
    public void invalid_enterWrongData() throws InterruptedException {
        driver.navigate().to("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("accessory");
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".a-size-base-plus.a-color-base.a-text-normal")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        Thread.sleep(2000);
        //Go to the cart and check that item is added successfully
        driver.findElement(By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS")).getText();
        String expectedText = "Added to Cart";
        String actualText = driver.findElement(By.cssSelector("h1[class=\"a-size-medium-plus a-color-base sw-atc-text a-text-bold\"]")).getText();
        Assert.assertEquals(actualText,expectedText);
    }
    
    @Test
    public void Invalid_selectSecondItem() throws InterruptedException {
        driver.navigate().to("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("car accessory");
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(2000);
        driver.findElements(By.cssSelector(".a-size-base-plus.a-color-base.a-text-normal")).get(1).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.id("add-to-cart-button")).isDisplayed());
    }
    
    @Test
    public void SearchEmptyString() throws InterruptedException {
        //Open amazon site
        driver.navigate().to("https://www.amazon.com/");
        //type "car accessories";
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(" ");
        //press search button
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(2000);
        //no results should be displayed
    }
    
}
