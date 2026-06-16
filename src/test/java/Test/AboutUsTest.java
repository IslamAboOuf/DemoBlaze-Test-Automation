package Test;

import Base.BaseTest;
import Pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AboutUsTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void setup() {

        homePage = new HomePage(driver);
    }

    @Test
    public void TC_0044_verifyUserCanOpenAboutUsModal() {
        homePage.openAbout();
        Assert.assertTrue(homePage.isAboutModalDisplayed(), "About Us modal should be visible");
    }

    @Test
    public void TC_0045_verifyUserCanPlayAboutUsVideo() {
        homePage.openAbout();
        homePage.playVideo();

        boolean isVideoVisible = wait.until(d -> homePage.isVideoPlayerDisplayed());
        Assert.assertTrue(isVideoVisible, "Video player should be displayed");
    }

    @Test
    public void TC_0046_verifyUserCanCloseAboutUsModal() {
        homePage.openAbout();
        homePage.closeAboutModal();

        boolean isModalHidden = wait.until(d -> homePage.isAboutModalHidden());
        Assert.assertTrue(isModalHidden, "Modal should be invisible after clicking Close!");
    }
}