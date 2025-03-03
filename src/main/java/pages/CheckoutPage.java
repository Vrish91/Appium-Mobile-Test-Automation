package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CheckoutPage {
    private AndroidDriver driver;

    // Locators
    private By nameField = By.id("com.saucelabs.mydemoapp.android:id/nameET");
    private By addressField = By.id("com.saucelabs.mydemoapp.android:id/addressET");
    private By zipField = By.id("com.saucelabs.mydemoapp.android:id/zipET");
    private By paymentField = By.id("com.saucelabs.mydemoapp.android:id/paymentET");
    private By placeOrderBtn = By.id("com.saucelabs.mydemoapp.android:id/placeOrderBtn");
    private By confirmationMsg = By.id("com.saucelabs.mydemoapp.android:id/confirmationMsg");

    // Constructor
    public CheckoutPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Fill checkout form
    public void enterShippingDetails(String name, String address, String zip, String payment) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(zipField).sendKeys(zip);
        driver.findElement(paymentField).sendKeys(payment);
    }

    // Place order
    public void placeOrder() {
        driver.findElement(placeOrderBtn).click();
    }

    // Verify order confirmation
    public boolean isOrderConfirmed() {
        return driver.findElement(confirmationMsg).isDisplayed();
    }
}
