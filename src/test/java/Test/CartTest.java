package Test;

import Base.BaseTest;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeMethod
    public void setup() {
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void TC_0027_verifyProductAddedToCart() {
        homePage.openProduct("Samsung galaxy s6");
        productPage.addToCart();
        homePage.openCart();
        Assert.assertTrue(cartPage.isProductDisplayed("Samsung galaxy s6"), "Product not found in cart");
    }

    @Test
    public void TC_0028_verifyDeleteProductFromCart() {
        homePage.openProduct("Samsung galaxy s6");
        productPage.addToCart();
        homePage.openCart();
        cartPage.deleteProduct();
        Assert.assertFalse(cartPage.isProductDisplayed("Samsung galaxy s6"), "Product still exists after delete");
    }

    @Test
    public void TC_0029_verifyTotalPriceCalculation() {
        homePage.openProduct("Samsung galaxy s6");
        productPage.addToCart();
        homePage.openCart();
        Assert.assertFalse(cartPage.getTotal().isEmpty(), "Total price is empty");
    }

    @Test
    public void TC_0030_verifyCartPageLoads() {
        homePage.openCart();
        Assert.assertTrue(cartPage.isCartTableDisplayed(), "Cart table is not displayed");
    }

    @Test
    public void TC_0031_verifyPlaceOrderButtonExists() {
        homePage.openCart();
        Assert.assertTrue(cartPage.isPlaceOrderButtonDisplayed(), "Place Order button is missing");
    }
}