import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.DriverFactory;

public class SampleTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver("chrome"); // or "firefox"
        homePage = new HomePage(driver);
        driver.get("http://example.com"); // Replace with your application URL
    }

    @Test
    public void testWelcomeMessage() {
        String welcomeMessage = homePage.getWelcomeMessage();
        Assert.assertEquals(welcomeMessage, "Welcome to Example!"); // Replace with expected message
    }

    @Test
    public void testLoginButton() {
        homePage.clickLoginButton();
        // Add assertions to verify login functionality
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}