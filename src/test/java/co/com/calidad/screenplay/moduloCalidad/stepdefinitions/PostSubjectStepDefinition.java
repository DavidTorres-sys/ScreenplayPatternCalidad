package co.com.calidad.screenplay.moduloCalidad.stepdefinitions;

import co.com.calidad.screenplay.moduloCalidad.models.Login;
import co.com.calidad.screenplay.moduloCalidad.tasks.ConnectTo;
import co.com.calidad.screenplay.moduloCalidad.tasks.CreateSubject;
import co.com.calidad.screenplay.moduloCalidad.tasks.ValidateCredentials;
import co.com.calidad.screenplay.moduloCalidad.utils.BuildLogin;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import static io.restassured.config.DecoderConfig.decoderConfig;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class PostSubjectStepDefinition {

    private final Actor actor = Actor.named("user");
    private String jwtToken;
    private final EnvironmentVariables environmentVariables= SystemEnvironmentVariables.createEnvironmentVariables();

    /**
     * Setup method executed before the tests begin. Configures the actor and RestAssured settings.
     * This method ensures that the actor is ready to perform tasks
     * and that the system can handle UTF-8 encoded requests and responses.
     */
    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
        RestAssured.config = RestAssured.config()
                .encoderConfig(encoderConfig().defaultContentCharset("UTF-8"))
                .decoderConfig(decoderConfig().defaultContentCharset("UTF-8"));
        actor.can(CallAnApi.at(environmentVariables.getProperty("webdriver.base.url")));
    }

    @Given("the user is authenticated to post a subject")
    public void theUserIsAuthenticatedToPostASubject() {
        Login login = BuildLogin.validLogin();
        actor.attemptsTo(ValidateCredentials.with(login));
        jwtToken = actor.recall("JWT_TOKEN");
    }

    @Given("the user is not authenticated to post a subject")
    public void theUserIsNotAuthenticatedToPostASubject() {
        actor.attemptsTo(ConnectTo.theAPI());
    }

    @When("the user submits the details of a new subject")
    public void theUserSubmitsTheDetailsOfANewSubject() {
        actor.attemptsTo(CreateSubject.withDetails(jwtToken));
    }

    @Then("the system should respond with an HTTP status {int}")
    public void theSystemShouldRespondWithAnHTTPStatus(int arg0) {
        actor.should(seeThatResponse(response -> response.statusCode(arg0)
        ));
    }

    @And("the response should contain the id {string} and the name {string}")
    public void theResponseShouldContainTheIdAndTheName(String arg0, String arg1) {
        actor.should(seeThatResponse( response -> response
                .body("name", equalTo(arg1))
                .body("id", equalTo(arg0))
        ));
    }
}
