package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    private static final String DATE_FORMAT = "yyyyMMdd_HHmmss";
    private String timestamp;

    @Before
    public void beforeScenario() {
        timestamp = new SimpleDateFormat(DATE_FORMAT).format(new Date());
        // Establecer el directorio de resultados con un timestamp único
        String resultsDirectory = "target/serenity-reports/" + timestamp;
        System.setProperty("serenity.results.directory", resultsDirectory);
    }

    @After
    public void afterScenario() {
        WebDriver driver = Serenity.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }

    public String getTimestamp() {
        return timestamp;
    }
}
