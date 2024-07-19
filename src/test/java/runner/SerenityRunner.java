package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/serenity-reports/cucumber-report.json"}, // Asegúrate de incluir los plugins necesarios
        features = "src/test/resources/features", // Asegúrate de la ubicación correcta
        glue = "steps"
)
public class SerenityRunner {
    // Opcional: métodos adicionales o configuración si es necesario
}

