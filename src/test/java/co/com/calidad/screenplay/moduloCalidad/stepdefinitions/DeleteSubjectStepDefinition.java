package co.com.calidad.screenplay.moduloCalidad.stepdefinitions;

import co.com.calidad.screenplay.moduloCalidad.models.Login;
import co.com.calidad.screenplay.moduloCalidad.tasks.DeleteSubject;
import co.com.calidad.screenplay.moduloCalidad.tasks.ValidateCredentials;
import co.com.calidad.screenplay.moduloCalidad.utils.BuildLogin;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import static io.restassured.config.DecoderConfig.decoderConfig;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class DeleteSubjectStepDefinition {

    private final EnvironmentVariables environmentVariables= SystemEnvironmentVariables.createEnvironmentVariables();
    private final Actor actor = Actor.named("user");
    private String jwtToken;

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
        RestAssured.config = RestAssured.config()
                .encoderConfig(encoderConfig().defaultContentCharset("UTF-8"))
                .decoderConfig(decoderConfig().defaultContentCharset("UTF-8"));
        actor.can(CallAnApi.at(environmentVariables.getProperty("webdriver.base.url")));
    }

    @Given("the user is authenticated to delete a subject")
    public void TheUserIsAuthenticatedToDeleteASubject() {
        Login login = BuildLogin.validLogin();
        actor.attemptsTo(ValidateCredentials.with(login));
        jwtToken = actor.recall("JWT_TOKEN");
    }

    @When("the user requests to delete the course with id {string}")
    public void theUserRequestsToDeleteTheCourseWithId(String arg0) {
        actor.attemptsTo(DeleteSubject.withId(jwtToken, arg0));
    }

    @Then("the system should confirm the deletion with an HTTP status {int}")
    public void theSystemShouldConfirmTheDeletionWithAnHTTPStatus(int arg0) {
        actor.should(seeThatResponse(response -> response.statusCode(arg0)));
    }

}
