package co.com.calidad.screenplay.moduloCalidad.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

/**
 * Task to connect the actor to a predefined API URL.
 * This task uses the environment variable 'webdriver.base.url' to determine
 * the base URL for the API connection.
 *
 * It resets any previous API state and assigns the base URL to the actor,
 * allowing the actor to interact with the API.
 *
 * The 'webdriver.base.url' environment variable must be defined in the
 * environment or configuration for this task to work correctly.
 *
 */
public class ConnectTo implements Task {

    private final String url;

    /**
     * Constructor that retrieves the base URL from the environment.
     * The base URL is fetched from the environment variable 'webdriver.base.url'.
     */
    public ConnectTo() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        this.url = environmentVariables.getProperty("webdriver.base.url");
    }

    /**
     * Perform the task of connecting the actor to the API.
     * This method resets any existing API connection and configures the actor
     * to use the base URL for future API requests.
     *
     * @param actor The actor performing the task.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.whoCan(CallAnApi.at(url));
    }

    /**
     * A static method to create and return a new instance of the ConnectTo task.
     *
     * @return A new ConnectTo task instance that connects the actor to the API.
     */
    public static ConnectTo theAPI() {
        return Tasks.instrumented(ConnectTo.class);
    }
}
