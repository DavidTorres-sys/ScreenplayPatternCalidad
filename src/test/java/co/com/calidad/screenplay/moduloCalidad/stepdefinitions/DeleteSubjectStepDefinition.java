package co.com.calidad.screenplay.moduloCalidad.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteSubjectStepDefinition {

    @Given("the user is authenticated on the Toolbox platform")
    public void theUserIsAuthenticatedOnTheToolboxPlatform() {
    }

    @When("the user requests to delete the course with id {string}")
    public void theUserRequestsToDeleteTheCourseWithId(String arg0) {

    }

    @Then("the system should confirm the deletion with an HTTP status {int}")
    public void theSystemShouldConfirmTheDeletionWithAnHTTPStatus(int arg0) {
    }

}
