package co.com.calidad.screenplay.moduloCalidad.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

/**
 * Task to consume a specific subject resource from the API.
 * This task retrieves the details of a subject identified by the subject ID.
 *
 * The API endpoint uses the path "subjectfull/{subjectId}", where `{subjectId}`
 * is dynamically inserted based on the ID provided when creating this task.
 *
 */
public class ConsumeSubject implements Task {

    private final String subjectId;

    /**
     * Constructor to initialize the subject ID.
     *
     * @param subjectId The ID of the subject to be retrieved from the API.
     */
    public ConsumeSubject(String subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * Performs the task of sending a GET request to retrieve subject details.
     * Configures the request with relaxed HTTPS validation and adds a form parameter
     * "Grant_type" to the request.
     *
     * @param actor The actor performing the task.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        String getOf = "subjectfull/" + subjectId;
        actor.attemptsTo(
                Get.resource(getOf).with(
                        request -> request
                                .relaxedHTTPSValidation()
                                .formParam("Grant_type", "Typer_value")
                )
        );
    }

    /**
     * Static method to create an instance of the ConsumeSubject task.
     *
     * @param subjectId The ID of the subject to be retrieved.
     * @return A new ConsumeSubject task instance configured with the given subject ID.
     */
    public static ConsumeSubject service(String subjectId) {
        return Tasks.instrumented(ConsumeSubject.class, subjectId);
    }
}
