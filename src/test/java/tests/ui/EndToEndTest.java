package tests.ui;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.ConfigReader;



public class EndToEndTest extends BaseTest{
	
	
	@Test
	public void testEndToEndCheckoutProcess() throws InterruptedException {
	
		// Step 1: Add items to the cart
			driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])[1]/android.view.ViewGroup[1]/android.widget.ImageView")).click();
			driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Add To Cart button\"]")).click();
			driver.navigate().back();
			driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])[6]/android.view.ViewGroup/android.widget.ImageView")).click();
			driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Add To Cart button\"]")).click();
			
		// Step 2: Verify items in the cart
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='product row']")));

		List<WebElement> cartItems = driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc='product row']"));
		Assert.assertTrue(cartItems.size() > 0, "❌ Cart is empty!");
		System.out.println("✅ Items verified in the cart: " + cartItems.size());

		// Step 3: Proceed to checkout
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Proceed To Checkout button\"]")).click(); // Replace with actual locator

		// Step 4: Fill in login details
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Username input field']")).sendKeys(ConfigReader.get("username"));
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Password input field']")).sendKeys(ConfigReader.get("password"));
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]")).click();

		// Step 5: Enter address details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Enter a shipping address\"]"))); // Wait for address screen
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Full Name* input field']")).sendKeys("Ana De Aramas"); // Replace with actual address
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Address Line 1* input field\"]")).sendKeys("Apt No. 61, Harvey Street (East), Oregon"); // Replace with actual city
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"City* input field\"]")).sendKeys("Oregon"); // Replace with actual postal code
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"State/Region input field\"]")).sendKeys("Kansas"); // Replace with actual postal code
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Zip Code* input field\"]")).sendKeys("243601"); // Replace with actual postal code
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Country* input field\"]")).sendKeys("USA");
		
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"To Payment button\"]")).click(); // Replace with actual locator

		// Step 6: Proceed to payment
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement element = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Enter a payment method\"]")));
		
		// Step 7: Add payment details
			
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Full Name* input field\"]")).sendKeys("Ana De"); // Replace with actual card number
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Card Number* input field']")).sendKeys("1234567812345678"); // Replace with actual expiry date
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Expiration Date* input field']")).sendKeys("03/27"); // Replace with actual CVV
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Security Code* input field']")).sendKeys("978"); // Replace with actual locator
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Review Order button']")).click();
		//Twice Click
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Review Order button\"]")).click();
		
		// Step 8: Review order
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Review your order\"]"))); // Wait for review screen

		// Step 9: Place the order
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Place Order button\"]")).click(); // Replace with actual locator

		// Step 10: Checkout complete screen
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Checkout Complete\"]"))); // Wait for completion screen
		String actualMessage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Thank you for your order\"]")).getText();
		String expMessage= "Thank you for your order";
		Assert.assertEquals(actualMessage, expMessage, "❌ Checkout not completed! Confirmation message does not match.");
		System.out.println("✅ Checkout completed successfully. Confirmation message: " + actualMessage);
	}
}

