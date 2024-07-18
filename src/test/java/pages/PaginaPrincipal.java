package pages;

public class PaginaPrincipal extends BasePage {

    private String signUp = "//a[contains(.,'Sign up')]";
    
    public PaginaPrincipal(){
        super(driver);
    }
    
    //Metodo para navegar a pagina Product Store
    public void navegarAProductStore(){
        navigateTo("https://www.demoblaze.com/");
    }

    //Metodo para clickear en el registro
    public void hacerClickSignUp(){
        clickElementXpath(signUp);
    }

}
