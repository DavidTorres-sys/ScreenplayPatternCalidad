package co.com.calidad.screenplay.moduloCalidad.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostSubjectStepDefinition {

    @Given("the user is logged into the Toolbox platform")
    public void theUserIsLoggedIntoTheToolboxPlatform() {
    }

    @Given("the user is not authenticated on the Toolbox platform")
    public void theUserIsNotAuthenticatedOnTheToolboxPlatform() {
    }

    @When("the user submits the details of a new subject")
    public void theUserSubmitsTheDetailsOfANewSubject() {
    }

    @Then("the system should respond with an HTTP status {int}")
    public void theSystemShouldRespondWithAnHTTPStatus(int arg0) {

    }

    @And("the response should contain the id {string} and the name {string}")
    public void theResponseShouldContainTheIdAndTheName(String arg0, String arg1) {
    }
}
