package tests.ui;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseTest;
import utils.ConfigReader;

public class CartFlow extends BaseTest {

    @BeforeClass
    public void resetAppState() {
    			// Open Menu
    			driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView")).click();

    			// Select App Reset option
    			driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='menu item reset app']")).click(); 

    			// Confirm App Reset
    			driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
    			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    			// Click Confirm Reset
    			driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

    			// Navigate back to Catalog
    			driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='menu item catalog']")).click();

    			System.out.println("✅ Precondition: App reset successfully.");
    }

    @Test
    public void testCartFlow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Add item to cart & verify
        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//android.view.ViewGroup[@content-desc='store item'])[1]/android.view.ViewGroup[1]/android.widget.ImageView")));
        firstProduct.click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[@content-desc='Add To Cart button']"))).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView")).click();
        List<WebElement> cartItems = driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc='product row']"));
        Assert.assertTrue(cartItems.size() > 0, "❌ No items found in the cart!");
        System.out.println("✅ Test Passed: Item added to cart successfully.");

        // Remove item & verify
        driver.findElement(By.xpath("//android.widget.TextView[@text='Remove Item']")).click();
        String noItemVisible = driver.findElement(By.xpath("//android.widget.TextView[@text='No Items']")).getText();
        Assert.assertFalse(noItemVisible.isBlank(), "❌ Item not removed from cart!");
        System.out.println("✅ Test Passed: Item removed from cart successfully.");

        // Go back to catalog, add item, click cart & proceed to checkout
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='menu item catalog']")).click();
        driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc='store item'])[4]/android.view.ViewGroup[1]/android.widget.ImageView")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Add To Cart']")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView")).click();

        // Proceed to checkout
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[@content-desc='Proceed To Checkout button']"))).click();

        // Provide login details
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@content-desc='Username input field']"))).sendKeys(ConfigReader.get("username"));
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Password input field']")).sendKeys(ConfigReader.get("password"));
        driver.findElement(By.xpath("(//android.widget.TextView[@text='Login'])[2]")).click();

        // Verify checkout page
        WebElement checkoutTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.TextView[@text='Checkout']")));
        Assert.assertTrue(checkoutTitle.isDisplayed(), "❌ Checkout page not displayed!");
        System.out.println("✅ Test Passed: Proceeded to checkout successfully.");
    }
}
