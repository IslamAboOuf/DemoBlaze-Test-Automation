package Test;

import Base.BaseTest;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutTest extends BaseTest {

    private void addProductAndGoToCheckout() {
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);

        home.openProduct("Samsung galaxy s6");
        product.addToCart();
        home.openCart();
        cart.openPlaceOrder();
    }

    @Test
    public void TC_0032_verifyUserCanOpenPlaceOrderForm() {
        addProductAndGoToCheckout();

        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.id("name")));
        Assert.assertTrue(nameField.isDisplayed(), "Place Order form did not open");
    }

    @Test
    public void TC_0033_verifyUserCompletesPurchaseSuccessfully() {
        addProductAndGoToCheckout();
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillForm("Shams mo", "Egypt", "Mansoura", "123456789", "6", "2026");
        checkout.clickPurchase();
        Assert.assertEquals(checkout.getSuccessMessage(), "Thank you for your purchase!");
    }

    @Test
    public void TC_0034_verifyPurchaseFailsWhenNameIsEmpty() {
        addProductAndGoToCheckout();
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillForm("", "Egypt", "Mansoura", "123456789", "6", "2026");
        checkout.clickPurchase();
        Assert.assertEquals(checkout.getAlertTextAndAccept(), "Please fill out Name and Creditcard.");
    }

    @Test
    public void TC_0035_verifyPurchaseFailsWhenCreditCardIsEmpty() {
        addProductAndGoToCheckout();
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillForm("Shams mo", "Egypt", "Mansoura", "", "6", "2026");
        checkout.clickPurchase();
        Assert.assertEquals(checkout.getAlertTextAndAccept(), "Please fill out Name and Creditcard.");
    }

    @Test
    public void TC_0036_verifyPurchaseFailsWhenNameAndCardEmpty() {
        addProductAndGoToCheckout();
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillForm("", "Egypt", "Mansoura", "", "6", "2026");
        checkout.clickPurchase();
        Assert.assertEquals(checkout.getAlertTextAndAccept(), "Please fill out Name and Creditcard.");
    }

    @Test
    public void TC_0037_verifyCartIsEmptyAfterSuccessfulPurchase() {
        addProductAndGoToCheckout();
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillForm("Shams mo", "Egypt", "Mansoura", "123456789", "6", "2026");
        checkout.clickPurchase();

        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
        okButton.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("orderModal")));

        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        home.openCart();
        Assert.assertFalse(cart.isProductDisplayed("Samsung galaxy s6"), "Product is still in cart!");
    }
    @Test
    public void TC_0038_verifyNameRejectsWhitespace() {
        addProductAndGoToCheckout();
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillForm("   ", "Egypt", "Mansoura", "123456789", "6", "2026");
        checkout.clickPurchase();
        Assert.assertEquals(checkout.getAlertTextAndAccept(), "Invalid Name.");
    }

    @Test
    public void TC_0039_verifyCreditCardRejectsLetters() {
        addProductAndGoToCheckout();
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillForm("Shams mo", "Egypt", "Mansoura", "abcdef", "6", "2026");
        checkout.clickPurchase();
        Assert.assertEquals(checkout.getAlertTextAndAccept(), "Invalid Credit Card.");
    }

    @Test
    public void TC_0040_verifyCreditCardRejectsSpecialCharacters() {
        addProductAndGoToCheckout();
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillForm("Shams mo", "Egypt", "Mansoura", "@#$%^&*", "6", "2026");
        checkout.clickPurchase();
        Assert.assertEquals(checkout.getAlertTextAndAccept(), "Invalid Credit Card.");
    }

    @Test
    public void TC_0041_verifyMonthAcceptsValidValuesOnly() {
        addProductAndGoToCheckout();
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillForm("Shams mo", "Egypt", "Mansoura", "123456789", "13", "2026");
        checkout.clickPurchase();
        Assert.assertEquals(checkout.getAlertTextAndAccept(), "Month must be between 1 and 12");
    }

    @Test
    public void TC_0042_verifyPlaceOrderNotOpenedWhenCartEmpty() {
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        home.openCart();
        Assert.assertTrue(driver.findElements(org.openqa.selenium.By.xpath("//button[text()='Place Order']")).isEmpty());
    }

    @Test
    public void TC_0043_verifyCannotPurchaseWithEmptyCart() {
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        home.openCart();
        cart.openPlaceOrder();
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.clickPurchase();
        Assert.assertEquals(checkout.getAlertTextAndAccept(), "Cart is empty");
    }
}