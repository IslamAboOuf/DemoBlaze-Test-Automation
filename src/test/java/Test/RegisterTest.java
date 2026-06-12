package Test;

import Base.BaseTest;
import Pages.RegisterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    protected RegisterPage registerPage;

    @BeforeMethod
    public void pageSetup() {
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void verifyRegistrationWithExistingUsername() {
        registerPage.register("Shams mo", "12345678");

        registerPage.verifyAlertMessage("This user already exist.");
    }

    @Test
    public void verifyRegistrationWithEmptyUsername() {
        registerPage.register("", "12345678");

        registerPage.verifyAlertMessage("Please fill out Username and Password.");
    }


    @Test
    public void verifyRegistrationWithEmptyPassword() {

        registerPage.register("Shams mo", "");

        registerPage.verifyAlertMessage("Please fill out Username and Password.");
    }

    @Test
    public void verifyRegistrationWithEmptyUsernameAndPassword() {
        registerPage.register("", "");
        
        registerPage.verifyAlertMessage("Please fill out Username and Password.");
    }
}