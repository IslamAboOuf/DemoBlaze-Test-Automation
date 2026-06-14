package Pages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) { super(driver); }

    public boolean isProductDisplayed(String name) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//td[contains(text(),'" + name + "')]"))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteProduct() {
        click(By.linkText("Delete"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("Delete")));
    }

    public void openPlaceOrder() { click(By.xpath("//button[text()='Place Order']")); }

    public String getTotal() {
        return getText(By.id("totalp"));
    }
}