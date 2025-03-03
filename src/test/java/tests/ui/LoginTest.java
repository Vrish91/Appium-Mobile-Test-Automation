package tests.ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;
import base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        // Navigate to login screen first
        loginPage.goToLoginScreen();

        // Enter credentials
        loginPage.enterUsername(ConfigReader.get("username"));
        loginPage.enterPassword(ConfigReader.get("password"));
        loginPage.clickLogin();
        
        //Validate Product name is showing on catalog page once logged in
        boolean isCatalogueDisplayed = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Products\"]")).isDisplayed();
        Assert.assertTrue(isCatalogueDisplayed, "Login failed! Cart page not displayed.");

        System.out.println("✅ Test Passed: Login successful.");
    }
}
