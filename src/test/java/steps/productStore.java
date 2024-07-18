package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.*;
import pages.PaginaPrincipal;

public class productStore {

    PaginaPrincipal main;

    @Given("que el usuario esta en la pagina principal de Product Store")
    public void irAProdcutStore() {
        main = new PaginaPrincipal("chrome"); // Cambiar a "firefox" para Firefox
        main.navegarAProductStore();
    }

    @When("el usuario hace clic en Sign Up")
    public void clickSignUp(){
        main.hacerClick();
    }

    @And("el usuario ingresa sus credenciales")
    public void registroCredenciales(){
        main.ingresarCredenciales();
    }

    @Then("el sistema muestra el mensaje Registro exitoso")
    public void finalizarRegistro(){
        main.clickSignUp();

        // Obtener el texto de la alerta y aceptarla
        String alertText = main.getAlertText();
        System.out.println("Texto de la alerta: " + alertText);
        // Asegurarse de que el texto de la alerta es "Sign up successful."
        assertEquals("Sign up successful.", alertText);
        main.acceptAlert();
    }
}
