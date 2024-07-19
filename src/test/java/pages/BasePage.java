package pages;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.pages.PageObject;

public class BasePage extends PageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor que inicializa el WebDriver según la configuración del navegador
    public BasePage() {
        String browser = System.getProperty("webdriver.driver", "firefox"); // Obtén el navegador de las propiedades

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /*
     * Constructor que acepta un objeto WebDriver como argumento.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        driver.quit();
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
