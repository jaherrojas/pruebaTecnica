package pages;

import org.openqa.selenium.By;
import com.github.javafaker.Faker;

public class PaginaPrincipal extends BasePage {

    private String signUpObject = "//a[contains(.,'Sign up')]";
    private String userNameObject = "sign-username";
    private String passwordObject = "sign-password";
    private String afterSignUp = "//button[contains(.,'Sign up')]";

    private Faker faker;

    public PaginaPrincipal(String browser) {
        super(browser); // Llama al constructor de la clase base con el navegador seleccionado
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
        try {
            Thread.sleep(2000); // Espera 2 segundos después de hacer clic
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
}
