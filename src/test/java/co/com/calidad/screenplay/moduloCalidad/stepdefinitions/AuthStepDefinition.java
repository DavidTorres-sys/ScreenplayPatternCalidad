package co.com.calidad.screenplay.moduloCalidad.stepdefinitions;

import co.com.calidad.screenplay.moduloCalidad.models.Login;
import co.com.calidad.screenplay.moduloCalidad.tasks.ConnectTo;
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

import static io.restassured.config.DecoderConfig.decoderConfig;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.containsString;

public class AuthStepDefinition {

    private final Actor actor = Actor.named("user");

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
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        actor.attemptsTo(ConnectTo.theAPI());
    }

    @When("the user enters a valid username and password")
    public void theUserEntersAValidUsernameAndPassword() {
        Login login = BuildLogin.validLogin();
        actor.attemptsTo(ValidateCredentials.with(login));
    }

    @When("the user enters an invalid username and password")
    public void theUserEntersAnInvalidUsernameAndPassword() {
        Login login = BuildLogin.invalidLogin();
        actor.attemptsTo(ValidateCredentials.with(login));
    }

    @Then("the system responds with an acceptance code and a token")
    public void theSystemRespondsWithAnAcceptanceCodeAndAToken() {
        actor.should(seeThatResponse(response -> response.statusCode(200)
                .body("accessToken", containsString("eyJhbGciOiJIUzUxMiJ9"))
                .body("tokenType", containsString("Bearer "))
        ));
    }

    @Then("the system responds with a rejection code due to unauthorized access")
    public void theSystemRespondsWithARejectionCodeDueToUnauthorizedAccess() {
        actor.should(seeThatResponse(response -> response.statusCode(401)));
    }
}
