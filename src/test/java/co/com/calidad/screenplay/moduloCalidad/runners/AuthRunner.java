package co.com.calidad.screenplay.moduloCalidad.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/auth.feature",
        glue = "co.com.calidad.screenplay.moduloCalidad.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class AuthRunner { }
