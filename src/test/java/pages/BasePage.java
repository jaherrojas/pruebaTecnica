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
        // Obtener el WebDriver administrado por Serenity
        this.driver = Serenity.getWebdriverManager().getWebdriver();
        // Inicializar WebDriverWait con un tiempo de espera de 10 segundos
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navegar a una URL específica
    public void navigateTo(String url) {
        driver.get(url);
    }

    // Cerrar el navegador si está abierto
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Encontrar un elemento usando XPath y esperar a que esté presente
    protected WebElement findByXpath(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    // Encontrar un elemento usando ID y esperar a que esté presente
    protected WebElement findById(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
    }

    // Hacer clic en un elemento localizado por XPath
    public void clickElementXpath(String locator) {
        findByXpath(locator).click();
    }

    // Hacer clic en un elemento localizado por ID
    public void clickElementId(String locator) {
        findById(locator).click();
    }

    // Escribir texto en un campo localizado por ID
    public void write(String locator, String keysToSend) {
        findById(locator).sendKeys(keysToSend);
    }

    // Obtener el texto de una alerta presente
    public String getAlertText() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }

    // Aceptar una alerta presente
    public void acceptAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
