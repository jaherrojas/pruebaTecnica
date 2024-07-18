package pages;

import com.github.javafaker.Faker;


public class PaginaPrincipal extends BasePage {

    private String signUpObject = "//a[contains(.,'Sign up')]";
    private String userNameObject = "sign-username";
    private String passwordObject = "sign-password";
    private String AfterSignUp = "//button[contains(.,'Sign up')]";

    private Faker faker;
    
    public PaginaPrincipal(){
        super(driver);
        this.faker = new Faker();
    }
    
    //Metodo para navegar a pagina Product Store
    public void navegarAProductStore(){
        navigateTo("https://www.demoblaze.com/");
    }

    // Metodo para clickear en el registro
    public void hacerClick() {
        clickElementXpath(signUpObject);
    }

    public void ingresarCredenciales(){
        try {
            // Espera 2 segundos después de hacer clic
            Thread.sleep(2000);
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

    //Finalizar registro.
    public void clickSignUp(){
        clickElementXpath(AfterSignUp);
    }
}
