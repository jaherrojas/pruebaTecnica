package steps;

import io.cucumber.java.en.*;
import pages.PaginaPrincipal;

public class productStore {

    PaginaPrincipal main = new PaginaPrincipal();

    @Given("El usuario esta en la pagina www.demoblaze.com")
    public void irAProdcutStore(){
        main.navegarAProductStore();
    }

    @When("El usuario hace click en sign up")
    public void clickSignUp(){
        main.hacerClickSignUp();
    }
    
}
