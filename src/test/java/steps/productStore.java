package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import pages.PaginaPrincipal;

public class productStore extends ScenarioSteps {

    @Steps
    private PaginaPrincipal main;

    @Given("que el usuario esta en la pagina principal de Product Store")
    public void irAProductStore() {
        main.navegarAProductStore();
    }

    @When("el usuario hace clic en Sign Up")
    public void clickSignUp() {
        main.hacerClick();
    }

    @And("el usuario ingresa sus credenciales")
    public void registroCredenciales() {
        main.ingresarCredenciales();
    }

    @Then("el sistema muestra el mensaje Registro exitoso")
    public void finalizarRegistro() {
        main.clickSignUp();

        // Obtener el texto de la alerta y aceptarla
        String alertText = main.getAlertText();
        System.out.println("Texto de la alerta: " + alertText);
        // Asegurarse de que el texto de la alerta es "Sign up successful."
        assertEquals("Sign up successful.", alertText);
        main.acceptAlert();
    }


    @When("el usuario selecciona la categoria {string}")
    public void seleccionarCategoria(String categoria) {
        main.seleccionarCategoria(categoria);
    }

    @And("el usuario elige el producto {string}")
    public void seleccionarProducto(String producto) {
        main.seleccionarProducto(producto);
    }

    @Then("el usuario agrega el producto al carrito")
    public void clickAddToCart() {
        main.clickAddToCart();
    }

    @And("el usuario acepta la aletar y genera un click en el tab Cart")
    public void clickTabCart() {
        // Obtener el texto de la alerta y aceptarla
        String alertText = main.getAlertText();
        System.out.println("Texto de la alerta: " + alertText);
        // Asegurarse de que el texto de la alerta es "Sign up successful."
        assertEquals("Product added", alertText);
        main.acceptAlert();
        main.clickTabCart();
    }

    @Then("hace click en place older")
    public void clickPlaceOrder(){
        main.clickPlaceOrder();
    }

    @And("diligencia formulario")
    public void diligenciaOrden(){
        main.ingresarCredencialesOrder();
    }

}
