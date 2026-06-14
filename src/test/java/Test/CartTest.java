package Test;

import Base.BaseTest;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void TC_0027_verifyProductAddedToCart() {
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);

        home.openProduct("Samsung galaxy s6");
        product.addToCart();
        home.openCart();

        Assert.assertTrue(cart.isProductDisplayed("Samsung galaxy s6"), "Product not found in cart");
    }

    @Test
    public void TC_0028_verifyDeleteProductFromCart() {
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);

        home.openProduct("Samsung galaxy s6");
        product.addToCart();
        home.openCart();

        cart.deleteProduct();

        Assert.assertFalse(cart.isProductDisplayed("Samsung galaxy s6"), "Product still exists after delete");
    }

    @Test
    public void TC_0029_verifyTotalPriceCalculation() {
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);

        home.openProduct("Samsung galaxy s6");
        product.addToCart();
        home.openCart();

        String total = cart.getTotal();
        Assert.assertFalse(total.isEmpty(), "Total price is empty");
    }

    @Test
    public void TC_0030_verifyCartPageLoads() {
        HomePage home = new HomePage(driver);
        home.openCart();

        Assert.assertTrue(driver.findElement(org.openqa.selenium.By.cssSelector("table")).isDisplayed(),
                "Cart table is not displayed");
    }

    @Test
    public void TC_0031_verifyPlaceOrderButtonExists() {
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);

        home.openCart();

        Assert.assertTrue(driver.findElement(org.openqa.selenium.By.xpath("//button[text()='Place Order']")).isDisplayed(),
                "Place Order button is missing");
    }
}