package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver("chrome"); // or "firefox"
        driver.get("http://example.com/login"); // Replace with your login page URL
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.enterEmail("test@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login should be successful with valid credentials.");
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        loginPage.enterEmail("wrong@example.com");
        loginPage.enterPassword("wrongpass");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed for invalid credentials.");
    }

    @Test
    public void testForgotPasswordLink() {
        loginPage.clickForgotPassword();
        Assert.assertTrue(loginPage.isForgotPasswordPageDisplayed(), "Forgot Password page should be displayed.");
        driver.navigate().back(); // Go back to login page for other tests
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}