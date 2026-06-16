package Test;

import Base.BaseTest;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.SkipException;
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

    }

    private void AddToCartAndOpenPlaceOrder() {
        homePage.openProduct("Samsung galaxy s6");
        new ProductPage(driver).addToCart();
        homePage.openCart();
        cartPage.openPlaceOrder();
    }

    @Test
    public void verifyUserCanOpenPlaceOrderForm() {
        AddToCartAndOpenPlaceOrder();
        Assert.assertTrue(checkoutPage.isModalVisible(), "Place Order form did not open");
    }

    @Test
    public void verifyUserCompletesPurchaseSuccessfully() {
        AddToCartAndOpenPlaceOrder();
        checkoutPage.fillForm("Shams mo", "Egypt", "Mansoura", "123456789", "6", "2026");
        checkoutPage.clickPurchase();
        Assert.assertEquals(checkoutPage.getSuccessMessage(), "Thank you for your purchase!");
    }

    @Test
    public void verifyPurchaseFailsWhenNameIsEmpty() {
        AddToCartAndOpenPlaceOrder();
        checkoutPage.fillForm("", "Egypt", "Mansoura", "123456789", "6", "2026");
        checkoutPage.clickPurchase();
        Assert.assertEquals(checkoutPage.getAlertTextAndAccept(), "Please fill out Name and Creditcard.");
    }

    @Test
    public void verifyPurchaseFailsWhenCreditCardIsEmpty() {
        AddToCartAndOpenPlaceOrder();
        checkoutPage.fillForm("Shams mo", "Egypt", "Mansoura", "", "6", "2026");
        checkoutPage.clickPurchase();
        Assert.assertEquals(checkoutPage.getAlertTextAndAccept(), "Please fill out Name and Creditcard.");
    }

    @Test
    public void verifyPurchaseFailsWhenNameAndCardEmpty() {
        AddToCartAndOpenPlaceOrder();
        checkoutPage.fillForm("", "Egypt", "Mansoura", "", "6", "2026");
        checkoutPage.clickPurchase();
        Assert.assertEquals(checkoutPage.getAlertTextAndAccept(), "Please fill out Name and Creditcard.");
    }

    @Test
    public void verifyCartIsEmptyAfterSuccessfulPurchase() {
        throw new SkipException("This test is ignored because the current implementation does not clear the cart after purchase, but it should be implemented in the future.");
//        AddToCartAndOpenPlaceOrder();
//        checkoutPage.fillForm("Shams mo", "Egypt", "Mansoura", "123456789", "6", "2026");
//        checkoutPage.clickPurchase();
//        checkoutPage.clickOk();
//        homePage.openCart();
//        Assert.assertFalse(cartPage.isProductDisplayed("Samsung galaxy s6"), "Product is still in cart!");
    }

    @Test
    public void verifyNameRejectsWhitespace() {
        throw new SkipException("This test is ignored because the current implementation does not validate whitespace in name input, but it should be implemented in the future.");
//        AddToCartAndOpenPlaceOrder();
//        checkoutPage.fillForm("   ", "Egypt", "Mansoura", "123456789", "6", "2026");
//        checkoutPage.clickPurchase();
//        Assert.assertEquals(checkoutPage.getAlertTextAndAccept(), "Invalid Name.");
    }

    @Test
    public void verifyCreditCardRejectsLetters() {
        throw new SkipException("This test is ignored because the current implementation does not validate letters in credit card input, but it should be implemented in the future.");
//        AddToCartAndOpenPlaceOrder();
//        checkoutPage.fillForm("Shams mo", "Egypt", "Mansoura", "abcdef", "6", "2026");
//        checkoutPage.clickPurchase();
//        Assert.assertEquals(checkoutPage.getAlertTextAndAccept(), "Invalid Credit Card.");
    }

    @Test
    public void verifyCreditCardRejectsSpecialCharacters() {
        throw new SkipException("This test is ignored because the current implementation does not validate special characters in credit card input, but it should be implemented in the future.");
//        AddToCartAndOpenPlaceOrder();
//        checkoutPage.fillForm("Shams mo", "Egypt", "Mansoura", "@#$%^&*", "6", "2026");
//        checkoutPage.clickPurchase();
//        Assert.assertEquals(checkoutPage.getAlertTextAndAccept(), "Invalid Credit Card.");
    }

    @Test
    public void verifyMonthAcceptsValidValuesOnly() {
        throw new SkipException("This test is ignored because the current implementation does not validate month input, but it should be implemented in the future.");
//        AddToCartAndOpenPlaceOrder();
//        checkoutPage.fillForm("Shams mo", "Egypt", "Mansoura", "123456789", "13", "2026");
//        checkoutPage.clickPurchase();
//        Assert.assertEquals(checkoutPage.getAlertTextAndAccept(), "Month must be between 1 and 12");
    }

    @Test
    public void verifyPlaceOrderNotOpenedWhenCartEmpty() {
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