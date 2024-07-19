package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {
            "pretty", 
            "json:target/serenity-reports/cucumber-report.json", // Reporte en formato JSON
            "html:target/serenity-reports/cucumber-report.html"   // Reporte en formato HTML
        },
        features = "src/test/resources/features", // Ruta de los archivos .feature
        glue = "steps", // Paquete con las clases de steps
        tags = "@Caso2" // Opcional: Ejecutar solo escenarios etiquetados con @Caso1, si se aplica
)
public class SerenityRunner {
    // Puedes dejar esta clase vacía o agregar métodos adicionales si es necesario
}