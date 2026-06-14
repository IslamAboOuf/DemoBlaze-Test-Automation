package Pages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) { super(driver); }

    public void addToCart() {
        click(By.linkText("Add to cart"));
        wait.until(ExpectedConditions.alertIsPresent());
        getAlertTextAndAccept();
    }

    public boolean isProductDetailsVisible() {
        return wait.until(d -> driver.findElement(By.cssSelector(".name")).isDisplayed());
    }
}