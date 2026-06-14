package Test;

import Base.BaseTest;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    private CheckoutPage checkoutPage;
    private HomePage homePage;
    private CartPage cartPage;

    @BeforeMethod
    public void setupScenario() {
        checkoutPage = new CheckoutPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);

        homePage.openProduct("Samsung galaxy s6");
        new ProductPage(driver).addToCart();
        homePage.openCart();
        cartPage.openPlaceOrder();
    }

    @Test
    public void verifyUserCanOpenPlaceOrderForm() {
        Assert.assertTrue(checkoutPage.isModalVisible(), "Place Order form did not open");
    }

    @Test
    public void verifyUserCompletesPurchaseSuccessfully() {
        checkoutPage.fillForm("Shams mo", "Egypt", "Mansoura", "123456789", "6", "2026");
        checkoutPage.clickPurchase();
        Assert.assertEquals(checkoutPage.getSuccessMessage(), "Thank you for your purchase!");
    }

    @Test
    public void verifyPurchaseFailsWhenNameIsEmpty() {
        checkoutPage.fillForm("", "Egypt", "Mansoura", "123456789", "6", "2026");
        checkoutPage.clickPurchase();
        Assert.assertEquals(checkoutPage.getAlertTextAndAccept(), "Please fill out Name and Creditcard.");
    }

    @Test
    public void verifyPurchaseFailsWhenCreditCardIsEmpty() {
        checkoutPage.fillForm("Shams mo", "Egypt", "Mansoura", "", "6", "2026");
        checkoutPage.clickPurchase();
        Assert.assertEquals(checkoutPage.getAlertTextAndAccept(), "Please fill out Name and Creditcard.");
    }

    @Test
    public void verifyPurchaseFailsWhenNameAndCardEmpty() {
        checkoutPage.fillForm("", "Egypt", "Mansoura", "", "6", "2026");
        checkoutPage.clickPurchase();
        Assert.assertEquals(checkoutPage.getAlertTextAndAccept(), "Please fill out Name and Creditcard.");
    }

    @Test
    public void verifyCartIsEmptyAfterSuccessfulPurchase() {
        checkoutPage.fillForm("Shams mo", "Egypt", "Mansoura", "123456789", "6", "2026");
        checkoutPage.clickPurchase();
        checkoutPage.clickOk();
        homePage.openCart();
        Assert.assertFalse(cartPage.isProductDisplayed("Samsung galaxy s6"), "Product is still in cart!");
    }

    @Test
    public void verifyNameRejectsWhitespace() {
        checkoutPage.fillForm("   ", "Egypt", "Mansoura", "123456789", "6", "2026");
        checkoutPage.clickPurchase();
        Assert.assertEquals(checkoutPage.getAlertTextAndAccept(), "Invalid Name.");
    }

    @Test
    public void verifyCreditCardRejectsLetters() {
        checkoutPage.fillForm("Shams mo", "Egypt", "Mansoura", "abcdef", "6", "2026");
        checkoutPage.clickPurchase();
        Assert.assertEquals(checkoutPage.getAlertTextAndAccept(), "Invalid Credit Card.");
    }

    @Test
    public void verifyCreditCardRejectsSpecialCharacters() {
        checkoutPage.fillForm("Shams mo", "Egypt", "Mansoura", "@#$%^&*", "6", "2026");
        checkoutPage.clickPurchase();
        Assert.assertEquals(checkoutPage.getAlertTextAndAccept(), "Invalid Credit Card.");
    }

    @Test
    public void verifyMonthAcceptsValidValuesOnly() {
        checkoutPage.fillForm("Shams mo", "Egypt", "Mansoura", "123456789", "13", "2026");
        checkoutPage.clickPurchase();
        Assert.assertEquals(checkoutPage.getAlertTextAndAccept(), "Month must be between 1 and 12");
    }

    @Test
    public void verifyPlaceOrderNotOpenedWhenCartEmpty() {
        // يحتاج فتح الكارت بدون إضافة منتج
        homePage.openCart();
        Assert.assertTrue(cartPage.isPlaceOrderButtonMissing());
    }

    @Test
    public void verifyCannotPurchaseWithEmptyCart() {
        homePage.openCart();
        cartPage.openPlaceOrder();
        checkoutPage.clickPurchase();
        Assert.assertEquals(checkoutPage.getAlertTextAndAccept(), "Cart is empty");
    }
}