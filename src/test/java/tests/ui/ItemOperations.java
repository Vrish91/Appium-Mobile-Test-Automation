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

public class ItemOperations extends BaseTest {

	@BeforeClass
	public void resetAppState() {
		// Open Menu
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView")).click();

		// Select App Reset option
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='menu item reset app']")).click(); 

		// Confirm App Reset
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// Click Confirm Reset
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

		// Navigate back to Catalog
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='menu item catalog']")).click();

		System.out.println("✅ Precondition: App reset successfully.");
	}

	@Test
	public void testAddItemToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		// Wait for product to be visible and click
		WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//android.view.ViewGroup[@content-desc='store item'])[1]/android.view.ViewGroup[1]/android.widget.ImageView")));
		firstProduct.click();

		// Click Add to Cart
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//android.view.ViewGroup[@content-desc='Add To Cart button']"))).click();

		// Open cart and verify item is added
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView")).click();
		List<WebElement> cartItems = driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc='product row']"));
		Assert.assertTrue(cartItems.size() > 0, "❌ No items found in the cart!");

		System.out.println("✅ Test Passed: Item added to cart successfully."+cartItems.size());
	}

	@Test
	public void testRemoveItemFromCart() throws InterruptedException {

		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		List<WebElement> addedItems= driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc=\"product row\"]"));
		int initialItemCount = addedItems.size();
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Remove Item\"][1]")).click();

		// Wait for the item to be removed and navigate back to the cart
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView"))).click();

		// Re-fetch the list of items in the cart
		addedItems = driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc='product row']"));
		int updatedItemCount = addedItems.size();

		// Assert that the item count has decreased
		Assert.assertTrue(updatedItemCount < initialItemCount, "❌ Item not removed from cart!");
		System.out.println("✅ Test Passed: Item removed from cart successfully.");

	}

	/*
	 * @Test public void testProceedToCheckout() { WebDriverWait wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(3)); driver.findElement(By.
	 * xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView"
	 * )).click(); driver.findElement(By.
	 * xpath("//android.view.ViewGroup[@content-desc='menu item catalog']")).click()
	 * ;
	 * 
	 * 
	 * 
	 * //Add Items to Cart
	 * 
	 * driver.findElement(By.
	 * xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])[4]/android.view.ViewGroup[1]/android.widget.ImageView"
	 * )).click(); driver.findElement(By.
	 * xpath("//android.widget.TextView[@text=\"Add To Cart\"]")).click();
	 * 
	 * // Open cart driver.findElement(By.
	 * xpath("//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView"
	 * )).click(); // Proceed to checkout
	 * wait.until(ExpectedConditions.elementToBeClickable( By.
	 * xpath("//android.view.ViewGroup[@content-desc='Proceed To Checkout button']")
	 * )).click();
	 * 
	 * driver.findElement(By.
	 * xpath("//android.widget.EditText[@content-desc='Username input field']")).
	 * sendKeys(ConfigReader.get("username")); driver.findElement(By.
	 * xpath("//android.widget.EditText[@content-desc='Password input field']")).
	 * sendKeys(ConfigReader.get("password")); driver.findElement(By.
	 * xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]")).click();
	 * 
	 * // Verify checkout page is displayed WebElement checkoutTitle =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(
	 * By.xpath("//android.widget.TextView[@text='Checkout']")));
	 * Assert.assertTrue(checkoutTitle.isDisplayed(),
	 * "❌ Checkout page not displayed!");
	 * 
	 * System.out.println("✅ Test Passed: Proceeded to checkout successfully."); }
	 */
}
