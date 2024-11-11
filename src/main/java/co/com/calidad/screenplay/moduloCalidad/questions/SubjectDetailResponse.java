package co.com.calidad.screenplay.moduloCalidad.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import java.nio.charset.StandardCharsets;

public class SubjectDetailResponse implements Question<Boolean> {

    private final String expectedName;

    public SubjectDetailResponse(String expectedName) {
        this.expectedName = expectedName;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Response response = SerenityRest.lastResponse();
        String actualName = response.jsonPath().getString("id");
        return response.statusCode() == 200 && actualName.equals(expectedName);
    }

    public static SubjectDetailResponse hasName(String expectedName) {
        return new SubjectDetailResponse(expectedName);
    }
}
