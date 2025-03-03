package tests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;
import base.BaseTest;

import java.time.Duration;

public class LoginFailureTest extends BaseTest {

	@Test
	public void testLockedOutUserLogin() {
		LoginPage loginPage = new LoginPage(driver);

		// Navigate to login screen first
		loginPage.goToLoginScreen();

		// Enter locked-out username instead of regular username
		loginPage.enterUsername(ConfigReader.get("lockedusername"));  
		loginPage.enterPassword(ConfigReader.get("password"));  // Any valid password
		loginPage.clickLogin();


		//Error Message- //android.widget.TextView[@text="Sorry, this user has been locked out."]

		// Wait for the error message to be visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Sorry, this user has been locked out.\"]")));

		// Verify the error message is displayed
		Assert.assertTrue(errorMessage.isDisplayed(), "❌ Login failure error message not displayed!");

		// Verify the error message text (adjust based on actual app behavior)
		String expectedError = "Sorry, this user has been locked out.";
		Assert.assertEquals(errorMessage.getText(), expectedError, "❌ Unexpected error message!");

		System.out.println("✅ Test Passed: Locked-out user cannot log in.");
	}
}
