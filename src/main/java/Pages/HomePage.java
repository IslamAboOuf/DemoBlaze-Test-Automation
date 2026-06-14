package Pages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openProduct(String name) {
        click(By.linkText(name));
    }

    public void openCart() {
        click(By.id("cartur"));
    }

    public void openAbout() {
        click(By.linkText("About us"));
    }
}