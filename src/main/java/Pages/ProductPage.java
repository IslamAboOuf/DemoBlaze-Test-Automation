package Pages;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) { super(driver); }

    private final By addToCartBtn = By.linkText("Add to cart");
    private final By productName = By.cssSelector(".name");
    private final By priceContainer = By.cssSelector(".price-container");

    public void addToCart() {
        click(addToCartBtn);
        getAlertTextAndAccept();
    }
    public boolean isProductDetailsVisible() {
        return isElementDisplayed(productName);
    }
    public boolean isPriceVisible() {
        return isElementDisplayed(priceContainer);
    }
}