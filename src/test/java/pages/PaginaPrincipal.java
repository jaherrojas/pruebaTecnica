package pages;

public class PaginaPrincipal extends BasePage {
    
    public PaginaPrincipal(){
        super(driver);
    }
    
    //Metodo para navegar a pagina Product Store
    public void navegarAProductStore(){
        navigateTo("https://www.demoblaze.com/");
    }

}
