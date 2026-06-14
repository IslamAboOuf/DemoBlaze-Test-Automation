package Pages;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) { super(driver); }

    private final By nameField = By.id("name");
    private final By purchaseBtn = By.xpath("//button[text()='Purchase']");
    private final By successMsg = By.xpath("//h2[text()='Thank you for your purchase!']");
    private final By okBtn = By.xpath("//button[text()='OK']");
    private final By orderModal = By.id("orderModal");

    public void fillForm(String name, String country, String city, String card, String month, String year) {
        sendText(nameField, name);
        // ... باقي الحقول بنفس الطريقة
    }
    public void clickPurchase() { click(purchaseBtn); }
    public void clickOk() { click(okBtn); }
    public String getSuccessMessage() { return getText(successMsg); }
    public boolean isModalVisible() { return isElementDisplayed(orderModal); }
}