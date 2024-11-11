package co.com.calidad.screenplay.moduloCalidad.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeleteSubject implements Task {

    private static final String ENDPOINT = "subjectfull/";

    private final String jwtToken;
    private final String id;

    public DeleteSubject(String jwtToken, String id) {
        this.jwtToken = jwtToken;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(ENDPOINT + id)
                        .with(request -> request
                                .header("Authorization", "Bearer " + jwtToken)
                                .header("Content-Type", "application/json")
        ));
    }

    public static DeleteSubject withId( String jwtToken, String id) {
        return Tasks.instrumented(DeleteSubject.class, jwtToken, id);
    }
}
