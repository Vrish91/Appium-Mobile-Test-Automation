package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By menuButton = By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView");
    private By loginOption = By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]");
    private By usernameField = By.xpath("//android.widget.EditText[@content-desc='Username input field']");
    private By passwordField = By.xpath("//android.widget.EditText[@content-desc='Password input field']");
    private By loginButton = By.xpath("(//android.widget.TextView[@text=\"Login\"])[2]");
    
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to login screen
    public void goToLoginScreen() {
        driver.findElement(menuButton).click();
        driver.findElement(loginOption).click();
    }

    // Enter username
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Enter password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Click Login button
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // Full login function (Navigate + Login)
    public void login(String username, String password) {
        goToLoginScreen();
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
