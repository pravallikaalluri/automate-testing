package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SignupPage;
import utils.DriverFactory;

public class SignupTest {
    private WebDriver driver;
    private SignupPage signupPage;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver("chrome"); // or "firefox"
        driver.get("http://example.com/signup"); // Replace with your signup page URL
        signupPage = new SignupPage(driver);
    }

    @Test
    public void testSuccessfulSignup() {
        signupPage.enterName("Test User");
        signupPage.enterEmail("newuser@example.com");
        signupPage.enterPassword("password123");
        signupPage.clickSignup();
        Assert.assertTrue(signupPage.isSignupSuccessful(), "Signup should be successful with valid details.");
    }

    @Test
    public void testSignupWithExistingEmail() {
        signupPage.enterName("Test User");
        signupPage.enterEmail("existing@example.com");
        signupPage.enterPassword("password123");
        signupPage.clickSignup();
        Assert.assertTrue(signupPage.isErrorDisplayed(), "Error message should be displayed for existing email.");
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}