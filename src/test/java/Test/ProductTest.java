package Test;

import Base.BaseTest;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test
    public void TC_0025_verifyProductDetailsPageOpens() {
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);

        home.openProduct("Samsung galaxy s6");

        Assert.assertTrue(product.isProductDetailsVisible(), "Product name should be visible");
        // يمكن إضافة دالة checkPriceVisibility في ProductPage للتحقق من السعر
        Assert.assertTrue(driver.findElement(org.openqa.selenium.By.cssSelector(".price-container")).isDisplayed(),
                "Price container should be visible");
    }

    @Test
    public void TC_0026_verifyAddToCartFromProductPage() {
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);

        home.openProduct("Samsung galaxy s6");

        product.addToCart();


    }
}