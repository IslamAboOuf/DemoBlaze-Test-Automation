package Test;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutUsTest extends BaseTest {

    @Test
    public void TC_0044_verifyUserCanOpenAboutUsModal() {
        HomePage home = new HomePage(driver);
        home.openAbout();

        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("videoModal")));
        Assert.assertTrue(modal.isDisplayed());
    }

    @Test
    public void TC_0045_verifyUserCanPlayAboutUsVideo() {
        HomePage home = new HomePage(driver);
        home.openAbout();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".vjs-big-play-button"))).click();

        Assert.assertTrue(driver.findElement(By.id("example-video")).isDisplayed());
    }

    @Test
    public void TC_0046_verifyUserCanCloseAboutUsModal() {
        HomePage home = new HomePage(driver);
        home.openAbout();

        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("videoModal")));

        driver.findElement(By.xpath("//div[@id='videoModal']//button[text()='Close']")).click();

        boolean isInvisible = wait.until(ExpectedConditions.invisibilityOf(modal));
        Assert.assertTrue(isInvisible, "Modal should be invisible after clicking Close!");
    }
}