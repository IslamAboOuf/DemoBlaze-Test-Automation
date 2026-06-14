package Pages;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) { super(driver); }

    private final By placeOrderBtn = By.xpath("//button[text()='Place Order']");
    private final By deleteLink = By.linkText("Delete");
    private final By totalLabel = By.id("totalp");
    private final By cartTable = By.cssSelector("table");

    public boolean isProductDisplayed(String name) { return isElementDisplayed(By.xpath("//td[contains(text(),'" + name + "')]")); }
    public void deleteProduct() { click(deleteLink); wait.until(ExpectedConditions.invisibilityOfElementLocated(deleteLink)); }
    public void openPlaceOrder() { click(placeOrderBtn); }
    public String getTotal() { return getText(totalLabel); }
    public boolean isCartTableDisplayed() { return isElementDisplayed(cartTable); }
    public boolean isPlaceOrderButtonDisplayed() { return isElementDisplayed(placeOrderBtn); }
    public boolean isPlaceOrderButtonMissing() { return !isElementDisplayed(placeOrderBtn); }
}