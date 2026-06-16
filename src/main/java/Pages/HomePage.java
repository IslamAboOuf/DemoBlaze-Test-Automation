package Pages;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) { super(driver); }

    private final By cartLink = By.id("cartur");
    private final By aboutUsLink = By.linkText("About us");
    private final By videoModal = By.id("videoModal");
    private final By playBtn = By.cssSelector(".vjs-big-play-button");
    private final By videoPlayer = By.id("example-video");
    private final By closeBtn = By.xpath("//div[@id='videoModal']//button[text()='Close']");

    public void openProduct(String name) {
        click(By.linkText(name));
    }
    public void openCart() {
        click(cartLink);
    }
    public void openAbout() {
        click(aboutUsLink);
    }

    public void playVideo() {

        wait.until(ExpectedConditions.elementToBeClickable(playBtn)).click();
    }

    public void closeAboutModal() {

        click(closeBtn);
    }

    public boolean isAboutModalDisplayed() {

        return isElementDisplayed(videoModal);
    }

    public boolean isVideoPlayerDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(videoPlayer)).isDisplayed();
    }

    public boolean isAboutModalHidden() {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(videoModal));
    }
}