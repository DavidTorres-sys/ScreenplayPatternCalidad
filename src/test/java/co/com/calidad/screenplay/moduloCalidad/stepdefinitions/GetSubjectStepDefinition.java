package co.com.calidad.screenplay.moduloCalidad.stepdefinitions;

import co.com.calidad.screenplay.moduloCalidad.tasks.ConnectTo;
import co.com.calidad.screenplay.moduloCalidad.tasks.ConsumeAllSubject;
import co.com.calidad.screenplay.moduloCalidad.tasks.ConsumeSubject;
import co.com.calidad.screenplay.moduloCalidad.questions.AllSubjectsResponse;
import co.com.calidad.screenplay.moduloCalidad.questions.SubjectDetailResponse;
import co.com.calidad.screenplay.moduloCalidad.questions.SubjectNotFoundResponse;
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
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;


public class GetSubjectStepDefinition {

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

    @Given("the user is logged into the Toolbox platform")
    public void theUserIsLoggedIntoTheToolboxPlatform() {
        actor.attemptsTo(ConnectTo.theAPI());
    }

    @When("the user searches for subjects without any filter")
    public void theUserSearchesForSubjectsWithoutAnyFilter() {
        actor.attemptsTo(ConsumeAllSubject.service());
    }

    @When("the user enters the subject code {string}")
    public void theUserEntersTheSubjectCode(String subjectCode) {
        actor.attemptsTo(ConsumeSubject.service(subjectCode));
    }

    @Then("the system responds with a list containing information on all subjects")
    public void theSystemRespondsWithAListContainingInformationOnAllSubjects() {
        actor.should(seeThat(AllSubjectsResponse.hasFirstSubjectName("2508120"), is(true)));
    }

    @Then("the system responds with detailed information about the subject")
    public void theSystemRespondsWithDetailedInformationAboutTheSubject() {
        actor.should(seeThat(SubjectDetailResponse.hasName("2508120"), is(true)));
    }

    @Then("the system responds by informing that the subject does not exist")
    public void theSystemRespondsByInformingThatTheSubjectDoesNotExist() {
        actor.should(seeThat(SubjectNotFoundResponse.isReturned(), is(true)));
    }
}
