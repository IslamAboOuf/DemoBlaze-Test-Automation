package Test;

import Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Base.BaseTest {

    protected LoginPage loginPage;

    @BeforeMethod
    public void pageSetup() {
        loginPage = new LoginPage(driver);
    }


    @Test
    public void verifyLoginWithValidCredentials() {
        loginPage.login("Shams mo", "12345678");

        Assert.assertTrue(loginPage.isWelcomeTextDisplayed(), "Welcome text should appear after successful login.");
    }

    @Test
    public void verifyLogout() {
        loginPage.login("Shams mo", "12345678");

        loginPage.logout();

        Assert.assertTrue(driver.findElement(By.id("login2")).isDisplayed(), "Login button should be visible after logout.");
    }

    @Test
    public void verifyLoginWithWrongPassword() {
        loginPage.login("Shams mo", "43212234");

        loginPage.verifyAlertMessage("Wrong password.");

    }

    @Test
    public void verifyLoginWithEmptyPassword() {
        loginPage.login("Shams mo", "");

        loginPage.verifyAlertMessage("Please fill out Username and Password.");

    }

    @Test
    public void verifyLoginWithEmptyUsername() {
        loginPage.login("", "12345678");

        loginPage.verifyAlertMessage("Please fill out Username and Password.");


    }

    @Test
    public void verifyLoginWithEmptyUsernameAndPassword() {
        loginPage.login("", "");

        loginPage.verifyAlertMessage("Please fill out Username and Password.");

    }

    @Test
    public void verifyLoginWithUnregisterUsername() {
        loginPage.login("ITI user", "11111111");

        loginPage.verifyAlertMessage("User does not exist.");

    }
}
