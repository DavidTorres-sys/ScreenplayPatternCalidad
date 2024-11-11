package co.com.calidad.screenplay.moduloCalidad.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class SubjectNotFoundResponse implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Response response = SerenityRest.lastResponse();
        return response.statusCode() == 404;
    }

    public static SubjectNotFoundResponse isReturned() {
        return new SubjectNotFoundResponse();
    }
}
