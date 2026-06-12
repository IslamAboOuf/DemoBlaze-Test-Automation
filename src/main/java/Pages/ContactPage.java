package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ContactPage {
    //locators
    private final By contactButton = By.xpath("//a[text()='Contact']");
    private final By emailField = By.id("recipient-email");
    private final By nameField = By.id("recipient-name");
    private final By messageField = By.id("message-text");
    private final By sendMessageButton = By.xpath("//button[text()='Send message']");

    //variables
    protected WebDriver driver;
    protected WebDriverWait wait;

    //constructor
    public ContactPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //actions
    public void ContactForm(String email, String name, String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactButton));
        driver.findElement(contactButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(messageField).sendKeys(message);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sendMessageButton));
        driver.findElement(sendMessageButton).click();

    }

    public void verifyAlertMessage(String ExpectedMessage) {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        alert.accept();
        Assert.assertEquals(actualMessage, ExpectedMessage);
    }
}
