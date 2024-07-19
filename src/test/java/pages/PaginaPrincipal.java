package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;

public class PaginaPrincipal extends BasePage {

    private String signUpObject = "//a[contains(.,'Sign up')]";
    private String userNameObject = "sign-username";
    private String passwordObject = "sign-password";
    private String afterSignUp = "//button[contains(.,'Sign up')]";
    private String addToCart = "//a[@href='#'][contains(.,'Add to cart')]";
    
    private Faker faker;

    public PaginaPrincipal() {
        super(); // Usar el constructor de la clase base sin parámetros
        this.faker = new Faker();
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
    }

    private void pauseForSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaurar el estado de interrupción
        }
    }

    public void seleccionarCategoria(String categoria) {
        pauseForSeconds(1); // Pausa de 2 segundos antes de interactuar
        clickElementXpath(String.format("//a[contains(text(),'%s')]", categoria));
    }

    public void seleccionarProducto(String producto) {
        pauseForSeconds(1); // Pausa de 2 segundos antes de interactuar
        clickElementXpath(String.format("//a[contains(text(),'%s')]", producto));

    }

    public void clickAddToCart() {
        WebElement addToCartElement = findByXpath(addToCart);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartElement));
        addToCartElement.click();
        pauseForSeconds(3);
    }


    
}


