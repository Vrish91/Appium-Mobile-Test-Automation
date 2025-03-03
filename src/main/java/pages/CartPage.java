package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private AndroidDriver driver;

    // Locators
    private By cartIcon = By.id("com.saucelabs.mydemoapp.android:id/cartIV");
    private By cartItems = By.id("com.saucelabs.mydemoapp.android:id/titleTV");
    private By removeFromCartBtn = By.id("com.saucelabs.mydemoapp.android:id/removeFromCartBtn");
    private By checkoutBtn = By.id("com.saucelabs.mydemoapp.android:id/checkoutBtn");

    // Constructor
    public CartPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Open cart
    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    // Get cart item count
    public int getCartItemCount() {
        List<WebElement> items = driver.findElements(cartItems);
        return items.size();
    }

    // Remove item from cart
    public void removeItemFromCart() {
        if (!driver.findElements(cartItems).isEmpty()) {
            driver.findElement(removeFromCartBtn).click();
        }
    }

    // Proceed to checkout
    public void proceedToCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}
