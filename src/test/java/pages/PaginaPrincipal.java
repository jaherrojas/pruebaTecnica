package pages;



public class PaginaPrincipal extends BasePage {

    private String signUpObject = "//a[contains(.,'Sign up')]";
    private String userNameObject = "sign-username";
    private String passwordObject = "sign-password";
    private String AfterSignUp = "//button[contains(.,'Sign up')]";
    
    public PaginaPrincipal(){
        super(driver);
    }
    
    //Metodo para navegar a pagina Product Store
    public void navegarAProductStore(){
        navigateTo("https://www.demoblaze.com/");
    }

    // Metodo para clickear en el registro
    public void hacerRegistro() {
        clickElementXpath(signUpObject);
        try {
            // Espera 2 segundos después de hacer clic
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        write(userNameObject, "Hola");
        write(passwordObject, "Hola");
        clickElementXpath(AfterSignUp);
    }

}
