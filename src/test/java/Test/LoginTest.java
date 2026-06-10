package Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Base.BaseTest {

    @Test
    public void verifyLoginWithValidCredentials() {

        driver.findElement(By.id("login2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));

        driver.findElement(By.id("loginusername")).sendKeys("Shams mo");

        driver.findElement(By.id("loginpassword")).sendKeys("12345678");

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));

        Assert.assertTrue(driver.findElement(By.id("nameofuser")).isDisplayed(), "Welcome text should appear after successful login.");
    }

    @Test
    public void verifyLogout() {
        driver.findElement(By.id("login2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));

        driver.findElement(By.id("loginusername")).sendKeys("Shams mo");

        driver.findElement(By.id("loginpassword")).sendKeys("12345678");

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2")));

        driver.findElement(By.id("logout2")).click();

        Assert.assertTrue(driver.findElement(By.id("login2")).isDisplayed(), "Login button should be visible after logout.");
    }

    @Test
    public void verifyLoginWithWrongPassword() {

        driver.findElement(By.id("login2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));

        driver.findElement(By.id("loginusername")).sendKeys("Shams mo");

        driver.findElement(By.id("loginpassword")).sendKeys("43212234");

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String actualMessage = alert.getText();

        Assert.assertEquals(actualMessage, "Wrong password.");

        alert.accept();
    }

    @Test
    public void verifyLoginWithEmptyPassword() {

        driver.findElement(By.id("login2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));

        driver.findElement(By.id("loginusername")).sendKeys("Shams mo");

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String actualMessage = alert.getText();

        Assert.assertEquals(actualMessage, "Please fill out Username and Password.");

        alert.accept();
    }

    @Test
    public void verifyLoginWithEmptyUsername() {

        driver.findElement(By.id("login2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));

        driver.findElement(By.id("loginpassword")).sendKeys("12345678");

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String actualMessage = alert.getText();

        Assert.assertEquals(actualMessage, "Please fill out Username and Password.");

        alert.accept();
    }

    @Test
    public void verifyLoginWithEmptyUsernameAndPassword() {

        driver.findElement(By.id("login2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Log in']")));

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String actualMessage = alert.getText();

        Assert.assertEquals(actualMessage, "Please fill out Username and Password.");

        alert.accept();
    }

    @Test
    public void verifyLoginWithUnregisterUsername() {

        driver.findElement(By.id("login2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));

        driver.findElement(By.id("loginusername")).sendKeys("ITI user");

        driver.findElement(By.id("loginpassword")).sendKeys("11111111");

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String actualMessage = alert.getText();

        Assert.assertEquals(actualMessage, "User does not exist.");

        alert.accept();

    }
}
