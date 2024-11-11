package co.com.calidad.screenplay.moduloCalidad.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class AllSubjectsResponse implements Question<Boolean> {

    private final String expectedFirstSubjectName;

    public AllSubjectsResponse(String expectedFirstSubjectName) {
        this.expectedFirstSubjectName = expectedFirstSubjectName;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Response response = SerenityRest.lastResponse();
        return response.statusCode() == 200 &&
                response.jsonPath().getString("[0].id").equals(expectedFirstSubjectName);
    }

    public static AllSubjectsResponse hasFirstSubjectName(String expectedFirstSubjectName) {
        return new AllSubjectsResponse(expectedFirstSubjectName);
    }
}
