package Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest extends Base.BaseTest {

    @Test
    public void verifyContactUsFormSubmissionWithValidData() {

        driver.findElement(By.linkText("Contact")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recipient-email")));

        driver.findElement(By.id("recipient-email")).sendKeys("test@test.com");

        driver.findElement(By.id("recipient-name")).sendKeys("User1");

        driver.findElement(By.id("message-text")).sendKeys("Hello");

        driver.findElement(By.xpath("//button[text()='Send message']")).click();

        Alert alert = driver.switchTo().alert();

        String actualMessage = alert.getText();

        Assert.assertEquals(actualMessage, "Thanks for the message!!");

        alert.accept();
    }

    @Test(enabled = false)
    public void verifyContactUsFormSubmissionWithEmptyFields() {

        driver.findElement(By.linkText("Contact")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recipient-email")));

        driver.findElement(By.xpath("//button[text()='Send message']")).click();

        Alert alert = driver.switchTo().alert();

        String actualMessage = alert.getText();

        Assert.assertEquals(actualMessage, "Please fill out all fields.");

        alert.accept();
    }

    @Test(enabled = false)
    public void verifyContactUsFormSubmissionWithEmptyContactName() {

        driver.findElement(By.linkText("Contact")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recipient-email")));

        driver.findElement(By.id("recipient-email")).sendKeys("test@test.com");

        driver.findElement(By.id("message-text")).sendKeys("Hello");

        driver.findElement(By.xpath("//button[text()='Send message']")).click();

        Alert alert = driver.switchTo().alert();

        String actualMessage = alert.getText();

        Assert.assertEquals(actualMessage, "Please fill out all fields.");

        alert.accept();
    }

    @Test(enabled = false)
    public void verifyContactUsFormSubmissionWithEmptyContactEmail() {

        driver.findElement(By.linkText("Contact")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recipient-name")));

        driver.findElement(By.id("recipient-name")).sendKeys("User1");

        driver.findElement(By.id("message-text")).sendKeys("Hello");

        driver.findElement(By.xpath("//button[text()='Send message']")).click();

        Alert alert = driver.switchTo().alert();

        String actualMessage = alert.getText();

        Assert.assertEquals(actualMessage, "Please fill out all fields.");

        alert.accept();
    }

    @Test(enabled = false)
    public void verifyContactUsFormSubmissionWithEmptyMessage() {

        driver.findElement(By.linkText("Contact")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recipient-email")));

        driver.findElement(By.id("recipient-email")).sendKeys("test@test.com");

        driver.findElement(By.id("recipient-name")).sendKeys("User1");

        driver.findElement(By.xpath("//button[text()='Send message']")).click();

        Alert alert = driver.switchTo().alert();

        String actualMessage = alert.getText();

        Assert.assertEquals(actualMessage, "Please fill out all fields.");

        alert.accept();
    }

    @Test(enabled = false)
    public void verifyContactUsFormSubmissionWithInvalidEmailFormat() {

        driver.findElement(By.linkText("Contact")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recipient-email")));

        driver.findElement(By.id("recipient-email")).sendKeys("testtest.com");

        driver.findElement(By.id("recipient-name")).sendKeys("User1");

        driver.findElement(By.id("message-text")).sendKeys("Hello");

        driver.findElement(By.xpath("//button[text()='Send message']")).click();

        Alert alert = driver.switchTo().alert();

        String actualMessage = alert.getText();

        Assert.assertEquals(actualMessage, "Invalid Email.");

        alert.accept();

    }
}
