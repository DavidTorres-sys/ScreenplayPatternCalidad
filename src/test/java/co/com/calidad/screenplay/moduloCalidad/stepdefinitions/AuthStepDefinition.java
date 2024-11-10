package co.com.calidad.screenplay.moduloCalidad.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthStepDefinition {

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
    }

    @When("the user enters a valid username and password")
    public void theUserEntersAValidUsernameAndPassword() {
        
    }

    @When("the user enters an invalid username and password")
    public void theUserEntersAnInvalidUsernameAndPassword() {
        
    }

    @Then("the system responds with an acceptance code and a token")
    public void theSystemRespondsWithAnAcceptanceCodeAndAToken() {
        
    }

    @Then("the system responds with a rejection code due to unauthorized access")
    public void theSystemRespondsWithARejectionCodeDueToUnauthorizedAccess() {
    }
}
