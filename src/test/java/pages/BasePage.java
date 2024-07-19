package pages;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.core.Serenity;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor que inicializa el WebDriver proporcionado por Serenity
    public BasePage() {
        this.driver = Serenity.getWebdriverManager().getWebdriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit(); // Asegúrate de cerrar el navegador si es necesario
        }
    }

    protected WebElement findByXpath(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    protected WebElement findById(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
    }

    public void clickElementXpath(String locator) {
        findByXpath(locator).click();
    }

    public void clickElementId(String locator) {
        findById(locator).click();
    }

    public void write(String locator, String keysToSend) {
        findById(locator).sendKeys(keysToSend);
    }

    // Método para cambiar el foco a la alerta y obtener el texto
    public String getAlertText() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }

    // Método para aceptar la alerta
    public void acceptAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
