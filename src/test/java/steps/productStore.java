package steps;

import io.cucumber.java.en.Given;
import pages.PaginaPrincipal;

public class productStore {

    PaginaPrincipal main = new PaginaPrincipal();

    @Given("El usuario esta en la pagina de registro de Product Store")
    public void irAProdcutStore(){
        main.navegarAProductStore();
    }
    
}
