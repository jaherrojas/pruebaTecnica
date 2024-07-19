package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;

public class PaginaPrincipal extends BasePage {

    // Caso 1
    private String signUpObject = "//a[contains(.,'Sign up')]";
    private String userNameObject = "sign-username";
    private String passwordObject = "sign-password";
    private String afterSignUp = "//button[contains(.,'Sign up')]";

    // Caso 2
    private String addToCart = "//a[@href='#'][contains(.,'Add to cart')]";
    private String tabCart = "//a[@href='cart.html']";
    private String orden = "//button[@type='button'][contains(.,'Place Order')]";

    // deligenciamiento orden de compra
    private String userNameOrder = "(//input[contains(@type,'text')])[4]";
    private String countryOrder = "//input[@id='country']";
    private String cityOrder = "//input[@id='city']";
    private String cardOrder = "//input[@id='card']";
    private String monthOrder = "//input[@id='month']";
    private String yearOrder = "//input[@id='year']";

    // Botón de compra
    private String purchase = "//button[contains(.,'Purchase')]";

    private Faker faker;

    public PaginaPrincipal() {
        super(); // Usar el constructor de la clase base sin parámetros
        this.faker = new Faker();
    }

    private void pauseForSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaurar el estado de interrupción
        }
    }

    // Método para navegar a la página Product Store
    public void navegarAProductStore() {
        navigateTo("https://www.demoblaze.com/");
    }

    // Método para hacer clic en el botón Sign up
    public void hacerClick() {
        clickElementXpath(signUpObject);
    }

    // Método para ingresar credenciales aleatorias
    public void ingresarCredenciales() {
        // Esperar a que los campos de entrada sean visibles antes de interactuar
        WebElement userNameField = findById(userNameObject);
        WebElement passwordField = findById(passwordObject);

        wait.until(ExpectedConditions.visibilityOf(userNameField));
        wait.until(ExpectedConditions.visibilityOf(passwordField));

        // Generar datos aleatorios para el nombre de usuario y la contraseña
        String randomUsername = faker.name().username();
        String randomPassword = faker.internet().password();

        // Escribir los datos generados en los campos correspondientes
        write(userNameObject, randomUsername);
        write(passwordObject, randomPassword);
    }

    // Método para hacer clic en el botón Sign up después de ingresar credenciales
    public void clickSignUp() {
        clickElementXpath(afterSignUp);
    }

    // Método para obtener el texto de la alerta y aceptarla
    public String getAlertText() {
        return super.getAlertText(); // Llama al método de la clase base
    }

    public void acceptAlert() {
        super.acceptAlert(); // Llama al método de la clase base
        pauseForSeconds(1);
    }

    public void seleccionarCategoria(String categoria) {
        pauseForSeconds(1); // Pausa de 1 segundo antes de interactuar
        clickElementXpath(String.format("//a[contains(text(),'%s')]", categoria));
    }

    public void seleccionarProducto(String producto) {
        pauseForSeconds(1); // Pausa de 1 segundo antes de interactuar
        clickElementXpath(String.format("//a[contains(text(),'%s')]", producto));
    }

    public void clickAddToCart() {
        WebElement addToCartElement = findByXpath(addToCart);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartElement));
        addToCartElement.click();
    }

    public void clickTabCart() {
        pauseForSeconds(1); // Pausa de 1 segundo antes de interactuar
        clickElementXpath(tabCart);
    }

    public void clickPlaceOrder() {
        clickElementXpath(orden);
        pauseForSeconds(1);
    }

    // acciones para orden de compra

    public void ingresarCredencialesOrder() {
        WebElement nameField = findByXpath(userNameOrder);
        WebElement countryField = findByXpath(countryOrder);
        WebElement cityField = findByXpath(cityOrder);
        WebElement cardField = findByXpath(cardOrder);
        WebElement monthField = findByXpath(monthOrder);
        WebElement yearField = findByXpath(yearOrder);

        wait.until(ExpectedConditions.visibilityOf(nameField));
        // // Generar datos aleatorios
        String randomName = faker.name().firstName();
        String randomCountry = faker.country().name();
        String randomCity = faker.country().capital();
        String randomCard = faker.number().digits(16);

        String[] months = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };
        String randomMonth = months[faker.number().numberBetween(0, 12)];

        String year = "2024";

        nameField.sendKeys(randomName);
        countryField.sendKeys(randomCountry);
        cityField.sendKeys(randomCity);
        cardField.sendKeys(randomCard);
        monthField.sendKeys(randomMonth);
        yearField.sendKeys(year);
        pauseForSeconds(1);
    }
}
