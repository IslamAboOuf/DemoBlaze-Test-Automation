package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    //locators
    private final By loginButton = By.id("login2");
    private final By username = By.id("loginusername");
    private final By password = By.id("loginpassword");
    private final By submitButton = By.xpath("//button[text()='Log in']");
    private final By welcomeText = By.id("nameofuser");
    private final By logoutButton = By.id("logout2");

    //variables
    private WebDriver driver;
    private WebDriverWait wait;

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //actions
    public void login(String user, String Pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(Pass);
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        driver.findElement(submitButton).click();
    }

    public boolean isWelcomeTextDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText));
        return driver.findElement(welcomeText).isDisplayed();
    }

    public void logout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
    }

    public void verifyAlertMessage(String ExpectedMessage) {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        alert.accept();
        Assert.assertEquals(actualMessage, ExpectedMessage);
    }
}