package co.edu.uniquindio.ingesis.professor;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepsLowUpdateProfessor {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();
    private Map<String, Object> professorData = new HashMap<>();

    @When("realizo una actualización minima del profesor con ID {int}")
    public void realizoUnaActualizaciónMinimaDelProfesorConID(int profesorID) {
        professorData.put("name", "Lucía");
        professorData.put("lastName", "Ramírez");
        professorData.put("identification", "1122334455");
        professorData.put("email", "lucia.ramirez@example.com");
        professorData.put("birthDate", "1990-01-15");
        professorData.put("phoneNumber", "3012345678");

        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .body(professorData)
                .when()
                .patch("/professors/" + profesorID);

        context.setResponse(response);
    }

    @And("el cuerpo de la respuesta debe contener los nuevos datos")
    public void elCuerpoDeLaRespuestaDebeContenerLosNuevosDatos() {

        JsonPath json = response.jsonPath();

        assertEquals(professorData.get("name"), json.getString("name"));
        assertEquals(professorData.get("lastName"), json.getString("lastName"));
        assertEquals(professorData.get("email"), json.getString("email"));
        assertEquals(professorData.get("phoneNumber"), json.getString("phoneNumber"));
    }

    @When("realizo una actualización del email del profesor con ID {int}")
    public void realizoUnaActualizaciónDelEmailDelProfesorConID(int profesorID) {
        professorData.put("email", "emailnovalido");

        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .body(professorData)
                .when()
                .patch("/professors/" + profesorID);

        context.setResponse(response);
    }
}
