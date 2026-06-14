package Test;

import Base.BaseTest;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    private HomePage homePage;
    private ProductPage productPage;
    // 1. يجب تعريف cartPage هنا ليصبح متاحاً داخل الكلاس
    private CartPage cartPage;

    @BeforeMethod
    public void setupProductTests() {
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        // 2. يجب تهيئة الأوبجيكت هنا (حتى "يُبنى المنزل")
        cartPage = new CartPage(driver);
    }

    @Test
    public void TC_0025_verifyProductDetailsPageOpens() {
        homePage.openProduct("Samsung galaxy s6");
        Assert.assertTrue(productPage.isProductDetailsVisible(), "Product name should be visible");
        Assert.assertTrue(productPage.isPriceVisible(), "Price container should be visible");
    }

    @Test
    public void TC_0026_verifyAddToCartFromProductPage() {
        homePage.openProduct("Samsung galaxy s6");
        productPage.addToCart();
        homePage.openCart();

        // 3. الآن يمكنك استخدام cartPage (الذي تم تهيئته) بنجاح
        Assert.assertTrue(cartPage.isProductDisplayed("Samsung galaxy s6"),
                "Product should be visible in the cart after adding it.");
    }
}