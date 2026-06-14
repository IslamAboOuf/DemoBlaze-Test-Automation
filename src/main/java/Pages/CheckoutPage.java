package Pages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) { super(driver); }

    private By name = By.id("name");
    private By country = By.id("country");
    private By city = By.id("city");
    private By card = By.id("card");
    private By month = By.id("month");
    private By year = By.id("year");
    private By purchaseBtn = By.xpath("//button[text()='Purchase']");
    private By successMsg = By.xpath("//h2[text()='Thank you for your purchase!']");

    public void fillForm(String n, String co, String ci, String ca, String m, String y) {
        sendText(name, n);
        sendText(country, co);
        sendText(city, ci);
        sendText(card, ca);
        sendText(month, m);
        sendText(year, y);
    }

    public void clickPurchase() { click(purchaseBtn); }
    public String getSuccessMessage() { return getText(successMsg); }
}