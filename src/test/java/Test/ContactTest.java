package Test;

import Pages.ContactPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactTest extends Base.BaseTest {

    protected ContactPage contactPage;

    @BeforeMethod
    public void pageSetup() {
        contactPage = new ContactPage(driver, wait);
    }

    @Test
    public void verifyContactUsFormSubmissionWithValidData() {

        contactPage.ContactForm("test@test.com", "User1", "Hello");

        contactPage.verifyAlertMessage("Thanks for the message!!");
    }

    @Test()
    public void verifyContactUsFormSubmissionWithEmptyFields() {

        contactPage.ContactForm("", "", "");

        contactPage.verifyAlertMessage("Please fill out all fields.");
    }

    @Test()
    public void verifyContactUsFormSubmissionWithEmptyContactName() {

        contactPage.ContactForm("test@test.com", "User1", "");

        contactPage.verifyAlertMessage("Please fill out all fields.");
    }

    @Test()
    public void verifyContactUsFormSubmissionWithEmptyContactEmail() {

        contactPage.ContactForm("", "User1", "Hello");

        contactPage.verifyAlertMessage("Please fill out all fields.");
    }

    @Test()
    public void verifyContactUsFormSubmissionWithEmptyMessage() {

        contactPage.ContactForm("test@test.com", "User1", "");

        contactPage.verifyAlertMessage("Please fill out all fields.");
    }

    @Test()
    public void verifyContactUsFormSubmissionWithInvalidEmailFormat() {

        contactPage.ContactForm("testtest.com", "User1", "Hello");

        contactPage.verifyAlertMessage("Invalid Email.");
    }
}
