package co.com.calidad.screenplay.moduloCalidad.tasks;

import co.com.calidad.screenplay.moduloCalidad.models.Subject;
import co.com.calidad.screenplay.moduloCalidad.utils.BuildSubject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class CreateSubject implements Task {

    private static final String ENDPOINT = "subjectfull/";
    private final String jwtToken;

    public CreateSubject(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Subject subject = BuildSubject.build();
        actor.attemptsTo(
                Post.to(ENDPOINT).with(request -> request
                        .header("Authorization", "Bearer " + jwtToken)
                        .header("Content-Type", "application/json")
                        .body(subject)
                )
        );
    }


    /**
     * Factory method to create the task with the JWT token.
     *
     * @param jwtToken JWT token for authorization.
     * @return an instance of CreateSubject.
     */
    public static CreateSubject withDetails(String jwtToken) {
        return Tasks.instrumented(CreateSubject.class, jwtToken);
    }
}
