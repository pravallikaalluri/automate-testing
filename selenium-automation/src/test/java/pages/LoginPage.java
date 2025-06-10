package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Locators (update these as per your actual HTML)
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");
    private By errorMessage = By.id("errorMsg");
    private By forgotPasswordLink = By.linkText("Forgot Password?");
    private By forgotPasswordPageHeader = By.xpath("//h1[contains(text(),'Forgot Password')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginSuccessful() {
        // Replace with a check for a post-login element unique to your app
        return driver.findElements(errorMessage).isEmpty();
    }

    public boolean isErrorDisplayed() {
        return driver.findElements(errorMessage).size() > 0;
    }

    public void clickForgotPassword() {
        driver.findElement(forgotPasswordLink).click();
    }

    public boolean isForgotPasswordPageDisplayed() {
        return driver.findElements(forgotPasswordPageHeader).size() > 0;
    }
}