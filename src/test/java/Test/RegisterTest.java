package Test;

import Base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {


    @Test
    public void verifyRegistrationWithExistingUsername() {

        driver.findElement(By.id("signin2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));

        driver.findElement(By.id("sign-username")).sendKeys("Shams mo");

        driver.findElement(By.id("sign-password")).sendKeys("12345678");

        driver.findElement(By.xpath("//button[text()='Sign up']")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String actualMessage = alert.getText();

        Assert.assertEquals(actualMessage, "This user already exist.");

        alert.accept();
    }

    @Test
    public void verifyRegistrationWithEmptyUsername() {

        driver.findElement(By.id("signin2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-password")));

        driver.findElement(By.id("sign-password")).sendKeys("12345678");

        driver.findElement(By.xpath("//button[text()='Sign up']")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String actualMessage = alert.getText();

        Assert.assertEquals(actualMessage, "Please fill out Username and Password.");

        alert.accept();
    }

    @Test
    public void verifyRegistrationWithEmptyPassword() {

        driver.findElement(By.id("signin2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));

        driver.findElement(By.id("sign-username")).sendKeys("Shams mo");

        driver.findElement(By.xpath("//button[text()='Sign up']")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String actualMessage = alert.getText();

        Assert.assertEquals(actualMessage, "Please fill out Username and Password.");

        alert.accept();
    }

    @Test
    public void verifyRegistrationWithEmptyUsernameAndPassword() {

        driver.findElement(By.id("signin2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Sign up']")));

        driver.findElement(By.xpath("//button[text()='Sign up']")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String actualMessage = alert.getText();

        Assert.assertEquals(actualMessage, "Please fill out Username and Password.");

        alert.accept();
    }
}