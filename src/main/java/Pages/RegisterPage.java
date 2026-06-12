package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class RegisterPage {
    //locators
    private final By registerButton = By.id("signin2");
    private final By username = By.id("sign-username");
    private final By password = By.id("sign-password");
    private final By submitButton = By.xpath("//button[text()='Sign up']");

    //variables
    protected WebDriver driver;
    protected WebDriverWait wait;

    //constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    //actions
    public void register(String user, String Pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerButton));
        driver.findElement(registerButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(Pass);
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        driver.findElement(submitButton).click();
    }

    public void verifyAlertMessage(String ExpectedMessage) {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        alert.accept();
        Assert.assertEquals(actualMessage, ExpectedMessage);
    }
}
