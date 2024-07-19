package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import pages.PaginaPrincipal;

public class productStore extends ScenarioSteps {

    @Steps
    private PaginaPrincipal main;

    // Navega a la página principal de Product Store
    @Given("que el usuario esta en la pagina principal de Product Store")
    public void irAProductStore() {
        main.navegarAProductStore();
    }

    // Hace clic en el botón de registro
    @When("el usuario hace clic en Sign Up")
    public void clickSignUp() {
        main.hacerClick();
    }

    // Ingresa credenciales aleatorias para el registro
    @And("el usuario ingresa sus credenciales")
    public void registroCredenciales() {
        main.ingresarCredenciales();
    }

    // Verifica que el registro fue exitoso y acepta la alerta
    @Then("el sistema muestra el mensaje Registro exitoso")
    public void finalizarRegistro() {
        main.clickSignUp();
        String alertText = main.getAlertText(); // Obtiene el texto de la alerta
        System.out.println("Texto de la alerta: " + alertText);
        assertEquals("Sign up successful.", alertText); // Verifica el texto de la alerta
        main.acceptAlert();
    }

    // Selecciona una categoría en la tienda
    @When("el usuario selecciona la categoria {string}")
    public void seleccionarCategoria(String categoria) {
        main.seleccionarCategoria(categoria);
    }

    // Selecciona un producto dentro de la categoría
    @And("el usuario elige el producto {string}")
    public void seleccionarProducto(String producto) {
        main.seleccionarProducto(producto);
    }

    // Agrega el producto seleccionado al carrito
    @Then("el usuario agrega el producto al carrito")
    public void clickAddToCart() {
        main.clickAddToCart();
    }

    // Acepta la alerta y navega al carrito
    @And("el usuario acepta la aletar y genera un click en el tab Cart")
    public void clickTabCart() {
        String alertText = main.getAlertText(); // Obtiene el texto de la alerta
        System.out.println("Texto de la alerta: " + alertText);
        assertEquals("Product added", alertText); // Verifica el texto de la alerta
        main.acceptAlert();
        main.clickTabCart(); // Navega al carrito
    }

    // Inicia el proceso de orden de compra
    @Then("hace click en place older")
    public void clickPlaceOrder() {
        main.clickPlaceOrder();
    }

    // Ingresa información para completar la orden
    @And("diligencia formulario")
    public void diligenciaOrden() {
        main.ingresarCredencialesOrder();
    }

    // Finaliza la compra haciendo clic en "Purchase"
    @Then("genera la compra")
    public void finalizarCompra() {
        main.clickPurchase();
    }
}
