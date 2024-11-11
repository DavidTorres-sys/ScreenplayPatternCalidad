package co.com.calidad.screenplay.moduloCalidad.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

/**
 * Task to consume the API endpoint for retrieving all subjects.
 *
 * This task performs a GET request to the "subjectfull/" endpoint to obtain details
 * for all subjects. It configures the request with relaxed HTTPS validation and includes
 * a form parameter "Grant_type" to the request as required by the API.
 *
 */
public class ConsumeAllSubject implements Task {

    private static final String ENDPOINT = "subjectfull/";

    /**
     * Performs the task of sending a GET request to retrieve subject details.
     * Configures the request with relaxed HTTPS validation and adds a form parameter
     * "Grant_type" to the request.
     *
     * @param actor The actor performing the task.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(ENDPOINT).with(
                        request -> request
                                .relaxedHTTPSValidation()
                                .formParam("Grant_type", "Typer_value")
                )
        );
    }

    /**
     * Factory method to create an instance of the ConsumeAllSubject task.
     *
     * @return A new instance of ConsumeAllSubject.
     */
    public static ConsumeAllSubject service() {
        return Tasks.instrumented(ConsumeAllSubject.class);
    }

}
