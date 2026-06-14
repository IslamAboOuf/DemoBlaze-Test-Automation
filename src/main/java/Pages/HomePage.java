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
    // التعديل: استخدام ID الفيديو الدقيق كما في الكود الناجح
    private final By videoPlayer = By.id("example-video");
    // التعديل: استخدام نص الزر بدقة كما في الكود الناجح
    private final By closeBtn = By.xpath("//div[@id='videoModal']//button[text()='Close']");

    public void openProduct(String name) { click(By.linkText(name)); }
    public void openCart() { click(cartLink); }
    public void openAbout() { click(aboutUsLink); }

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
        // ننتظر حتى يظهر الفيديو فعلياً
        return wait.until(ExpectedConditions.visibilityOfElementLocated(videoPlayer)).isDisplayed();
    }

    public boolean isAboutModalHidden() {
        // ننتظر حتى يختفي المودال تماماً من الصفحة
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(videoModal));
    }
}