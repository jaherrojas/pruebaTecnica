package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;

public class PaginaPrincipal extends BasePage {

    // Localizadores de elementos para registro y compra
    private String signUpObject = "//a[contains(.,'Sign up')]";
    private String userNameObject = "sign-username";
    private String passwordObject = "sign-password";
    private String afterSignUp = "//button[contains(.,'Sign up')]";

    private String addToCart = "//a[@href='#'][contains(.,'Add to cart')]";
    private String tabCart = "//a[@href='cart.html']";
    private String orden = "//button[@type='button'][contains(.,'Place Order')]";

    private String userNameOrder = "(//input[contains(@type,'text')])[4]";
    private String countryOrder = "//input[@id='country']";
    private String cityOrder = "//input[@id='city']";
    private String cardOrder = "//input[@id='card']";
    private String monthOrder = "//input[@id='month']";
    private String yearOrder = "//input[@id='year']";

    private String purchase = "//button[contains(.,'Purchase')]";

    private Faker faker;

    public PaginaPrincipal() {
        super(); // Inicializa el WebDriver y WebDriverWait
        this.faker = new Faker(); // Inicializa Faker para generar datos aleatorios
    }

    private void pauseForSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds); // Pausa la ejecución durante los segundos especificados
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaurar el estado de interrupción si se interrumpe
        }
    }

    // Navega a la página Product Store
    public void navegarAProductStore() {
        navigateTo("https://www.demoblaze.com/");
    }

    // Hace clic en el botón de registro
    public void hacerClick() {
        clickElementXpath(signUpObject);
    }

    // Ingresa credenciales aleatorias en los campos de registro
    public void ingresarCredenciales() {
        WebElement userNameField = findById(userNameObject);
        WebElement passwordField = findById(passwordObject);

        wait.until(ExpectedConditions.visibilityOf(userNameField));
        wait.until(ExpectedConditions.visibilityOf(passwordField));

        String randomUsername = faker.name().username(); // Genera un nombre de usuario aleatorio
        String randomPassword = faker.internet().password(); // Genera una contraseña aleatoria

        write(userNameObject, randomUsername); // Escribe el nombre de usuario
        write(passwordObject, randomPassword); // Escribe la contraseña
    }

    // Hace clic en el botón de registro después de ingresar credenciales
    public void clickSignUp() {
        clickElementXpath(afterSignUp);
    }

    // Obtiene el texto de la alerta y la acepta
    public String getAlertText() {
        return super.getAlertText(); // Devuelve el texto de la alerta
    }

    public void acceptAlert() {
        super.acceptAlert(); // Acepta la alerta
        pauseForSeconds(1); // Pausa para asegurar la acción
    }

    // Selecciona una categoría en la tienda
    public void seleccionarCategoria(String categoria) {
        pauseForSeconds(1); // Pausa antes de interactuar
        clickElementXpath(String.format("//a[contains(text(),'%s')]", categoria));
    }

    // Selecciona un producto en la tienda
    public void seleccionarProducto(String producto) {
        pauseForSeconds(1); // Pausa antes de interactuar
        clickElementXpath(String.format("//a[contains(text(),'%s')]", producto));
    }

    // Hace clic en "Add to cart" para un producto
    public void clickAddToCart() {
        WebElement addToCartElement = findByXpath(addToCart);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartElement));
        addToCartElement.click();
    }

    // Abre la pestaña del carrito
    public void clickTabCart() {
        pauseForSeconds(1); // Pausa antes de interactuar
        clickElementXpath(tabCart);
    }

    // Inicia el proceso de orden de compra
    public void clickPlaceOrder() {
        clickElementXpath(orden);
        pauseForSeconds(1);
    }

    // Ingresa información aleatoria para completar la orden de compra
    public void ingresarCredencialesOrder() {
        WebElement nameField = findByXpath(userNameOrder);
        WebElement countryField = findByXpath(countryOrder);
        WebElement cityField = findByXpath(cityOrder);
        WebElement cardField = findByXpath(cardOrder);
        WebElement monthField = findByXpath(monthOrder);
        WebElement yearField = findByXpath(yearOrder);

        wait.until(ExpectedConditions.visibilityOf(nameField));

        String randomName = faker.name().firstName(); // Nombre aleatorio
        String randomCountry = faker.country().name(); // País aleatorio
        String randomCity = faker.country().capital(); // Ciudad aleatoria
        String randomCard = faker.number().digits(16); // Número de tarjeta aleatorio

        String[] months = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };
        String randomMonth = months[faker.number().numberBetween(0, 12)]; // Mes aleatorio

        String year = "2024"; // Año fijo

        //Ingresamos el texto al formuralio
        nameField.sendKeys(randomName);
        countryField.sendKeys(randomCountry);
        cityField.sendKeys(randomCity);
        cardField.sendKeys(randomCard);
        monthField.sendKeys(randomMonth);
        yearField.sendKeys(year);
        pauseForSeconds(1); // Pausa después de ingresar datos
    }

    // Hace clic en "Purchase" para completar la compra
    public void clickPurchase() {
        clickElementXpath(purchase);
        pauseForSeconds(1);
    }
}
