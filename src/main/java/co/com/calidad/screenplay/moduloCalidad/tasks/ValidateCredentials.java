package co.com.calidad.screenplay.moduloCalidad.tasks;

import co.com.calidad.screenplay.moduloCalidad.models.Login;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

/**
 * A task that performs the action of validating user credentials by sending a login request to an authentication endpoint.
 * This task will send a POST request with the user's login details (username and password) in JSON format.
 * If the login is successful (status code 200), it will store the access token in the actor's memory.
 */
public class ValidateCredentials implements Task {

    private static final String ENDPOINT = "auth/login";
    private final Login login;

    /**
     * Constructor to initialize the ValidateCredentials task with the Login model.
     *
     * @param login The Login object containing the username and password for the authentication request.
     */
    public ValidateCredentials(Login login) {
        this.login = login;
    }

    /**
     * Executes the login validation task. It sends a POST request to the "auth/login" endpoint with the user's credentials.
     * If the login is successful (HTTP status code 200), it stores the JWT token in the actor's memory.
     *
     * @param actor The actor performing the task, which can later retrieve the JWT token from memory.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(ENDPOINT)
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body(login)
                        )
        );
        if (SerenityRest.lastResponse().getStatusCode() == 200) {
            String token = SerenityRest.lastResponse().jsonPath().getString("accessToken");
            actor.remember("JWT_TOKEN", token);
        }
    }

    /**
     * Factory method to create an instance of the ValidateCredentials task with the provided Login object.
     *
     * @param login The Login object containing the credentials for authentication.
     * @return A new instance of the ValidateCredentials task.
     */
    public static ValidateCredentials with(Login login) {
        return Tasks.instrumented(ValidateCredentials.class, login);
    }
}
