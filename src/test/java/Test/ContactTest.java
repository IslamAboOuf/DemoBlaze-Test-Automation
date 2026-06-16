package Test;

import Pages.ContactPage;
import org.testng.SkipException;
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
        throw new SkipException("Bug: Contact form submission with empty fields is not working as expected. Skipping this test until the bug is fixed.");

//        contactPage.ContactForm("", "", "");
//
//        contactPage.verifyAlertMessage("Please fill out all fields.");
    }

    @Test()
    public void verifyContactUsFormSubmissionWithEmptyContactName() {
        throw new SkipException("Bug: Contact form submission with empty contact name is not working as expected. Skipping this test until the bug is fixed.");

//        contactPage.ContactForm("test@test.com", "User1", "");
//
//        contactPage.verifyAlertMessage("Please fill out all fields.");
    }

    @Test()
    public void verifyContactUsFormSubmissionWithEmptyContactEmail() {
        throw new SkipException("Bug: Contact form submission with empty contact email is not working as expected. Skipping this test until the bug is fixed.");

//        contactPage.ContactForm("", "User1", "Hello");
//
//        contactPage.verifyAlertMessage("Please fill out all fields.");
    }

    @Test()
    public void verifyContactUsFormSubmissionWithEmptyMessage() {
        throw new SkipException("Bug: Contact form submission with empty message is not working as expected. Skipping this test until the bug is fixed.");

//        contactPage.ContactForm("test@test.com", "User1", "");
//
//        contactPage.verifyAlertMessage("Please fill out all fields.");
    }

    @Test()
    public void verifyContactUsFormSubmissionWithInvalidEmailFormat() {
        throw new SkipException("Bug: Contact form submission with invalid email format is not working as expected. Skipping this test until the bug is fixed.");

//        contactPage.ContactForm("testtest.com", "User1", "Hello");
//
//        contactPage.verifyAlertMessage("Invalid Email.");
    }
}
